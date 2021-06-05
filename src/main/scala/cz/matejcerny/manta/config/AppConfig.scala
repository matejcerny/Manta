package cz.matejcerny.manta.config

import cats.implicits._
import cats.ApplicativeError
import com.typesafe.config.{Config, ConfigFactory}
import configs.syntax._
import cz.matejcerny.manta.config.AppConfig.{Database, Http}
import cz.matejcerny.manta.domain.MantaError
import cz.matejcerny.manta.domain.MantaError.CannotParseConfig

import java.io.{BufferedReader, InputStreamReader}
import scala.util.Try

case class AppConfig(
  http: Http,
  database: Database
)

object AppConfig {

  case class Http(port: Int, host: String)
  case class Database(
    user: String,
    password: String,
    url: String,
    driver: String,
    schema: String
  )

  private def reader(path: String): Either[MantaError, BufferedReader] =
    Try(new BufferedReader(new InputStreamReader(getClass.getResourceAsStream(path)))).toEither.left
      .map(_ => CannotParseConfig(s"Cannot open file $path"))

  private def configReader(bufferedReader: BufferedReader): Either[MantaError, Config] =
    Try(ConfigFactory.parseReader(bufferedReader).resolve()).toEither.left
      .map(e => CannotParseConfig(e.getMessage))

  private def configParser(config: Config): Either[MantaError, AppConfig] =
    config
      .get[AppConfig]("manta")
      .toEither
      .left
      .map(e => CannotParseConfig(e.messages.mkString("\n")))

  def apply[F[_]](path: String = "/application.conf")(implicit ev: ApplicativeError[F, Throwable]): F[AppConfig] =
    (
      for {
        reader <- reader(path)
        config <- configReader(reader)
        appConfig <- configParser(config)
      } yield appConfig
    ).liftTo[F]

}
