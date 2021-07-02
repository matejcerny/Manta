package cz.matejcerny.manta.config

import cats.implicits._
import cats.ApplicativeError
import com.typesafe.config.{Config, ConfigFactory}
import configs.syntax._
import cz.matejcerny.manta.domain.MantaError
import cz.matejcerny.manta.domain.MantaError.CannotParseConfig

import java.io.{BufferedReader, InputStreamReader}
import scala.util.Try

case class AppConfig(
  httpConfig: HttpConfig,
  dbConfig: DbConfig
)

object AppConfig {

  private def reader(path: String): Either[MantaError, BufferedReader] =
    Try(new BufferedReader(new InputStreamReader(getClass.getResourceAsStream(path)))).toEither.left
      .map(_ => CannotParseConfig(s"Cannot open file $path"))

  private def configReader(bufferedReader: BufferedReader): Either[MantaError, Config] =
    Try(ConfigFactory.parseReader(bufferedReader).resolve()).toEither.left
      .map(e => CannotParseConfig(e.getMessage))

  private def configParser(config: Config): Either[MantaError, AppConfig] =
    Try(
      AppConfig(
        config.get[HttpConfig]("http").value,
        config.get[DbConfig]("db").value
      )
    ).toEither.left.map(e => CannotParseConfig(e.getMessage))

  def apply[F[_]](path: String = "/application.conf")(implicit ev: ApplicativeError[F, Throwable]): F[AppConfig] =
    (
      for {
        reader <- reader(path)
        config <- configReader(reader)
        appConfig <- configParser(config)
      } yield appConfig
    ).liftTo[F]

}
