package cz.matejcerny.manta

import cats.effect._
import cats.implicits._
import com.typesafe.scalalogging.LazyLogging
import cz.matejcerny.manta.config.AppConfig

object Manta extends IOApp with LazyLogging {

  def runServer[F[_]: ContextShift: ConcurrentEffect: Timer]: Resource[F, Unit] =
    for {
      appConfig <- Resource.eval(AppConfig[F]())
    } yield println(appConfig)

  def run(args: List[String]): IO[ExitCode] =
    runServer.use(_ => IO.unit).as(ExitCode.Success)
}
