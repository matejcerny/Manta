package cz.matejcerny.manta

import cats.effect._
import com.typesafe.scalalogging.LazyLogging
import cz.matejcerny.manta.config.AppConfig
import cz.matejcerny.manta.domain.user.UserService
import cz.matejcerny.manta.infrastructure.interpreter.DoobieUserInterpreter
import cz.matejcerny.manta.infrastructure.util.DatabaseUtil
import doobie.util.ExecutionContexts
import org.http4s.server.blaze.BlazeServerBuilder

import scala.concurrent.ExecutionContext.global

object Manta extends IOApp with LazyLogging {

  def runServer[F[_]: ContextShift: ConcurrentEffect: Timer]: Resource[F, Unit] =
    for {
      appConfig <- Resource.eval(AppConfig())
      dbEc <- ExecutionContexts.fixedThreadPool(appConfig.dbConfig.maxConnections)
      ec <- ExecutionContexts.cachedThreadPool
      xa <- DatabaseUtil.createTransactor(appConfig.dbConfig, dbEc, Blocker.liftExecutionContext(ec))
      userInterpreter = DoobieUserInterpreter(xa)
      userService = UserService(userInterpreter)
      (port, host) = (appConfig.httpConfig.port, appConfig.httpConfig.host)
      server <- BlazeServerBuilder[F](global).bindHttp(port, host).resource
    } yield server

  def run(args: List[String]): IO[ExitCode] =
    runServer.use(_ => IO.never).as(ExitCode.Success)
}
