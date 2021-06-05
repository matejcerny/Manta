package cz.matejcerny.manta

import cats.effect._
import com.typesafe.scalalogging.LazyLogging
import cz.matejcerny.manta.config.AppConfig
import org.http4s.server.blaze.BlazeServerBuilder

import scala.concurrent.ExecutionContext.global

object Manta extends IOApp with LazyLogging {

  def runServer[F[_]: ContextShift: ConcurrentEffect: Timer]: Resource[F, Unit] =
    for {
      appConfig <- Resource.eval(AppConfig[F]())
      (port, host) = (appConfig.http.port, appConfig.http.host)
      server <- BlazeServerBuilder[F](global).bindHttp(port, host).resource
    } yield server

  def run(args: List[String]): IO[ExitCode] =
    runServer.use(_ => IO.never).as(ExitCode.Success)
}
