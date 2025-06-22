package cz.matejcerny.manta

import cats.effect.*
import cz.matejcerny.manta.config.AppConfig
import cz.matejcerny.manta.infrastructure.db.DbClient
import cz.matejcerny.manta.infrastructure.db.repository.PostgresUserRepository
import cz.matejcerny.manta.infrastructure.http.HttpServer
import cz.matejcerny.manta.infrastructure.http.router.{ HealthRouter, UserRouter }
import cz.matejcerny.manta.service.UserService
import org.typelevel.log4cats.*
import org.typelevel.log4cats.slf4j.*

object Manta extends IOApp:

  private val logger: SelfAwareStructuredLogger[IO] = LoggerFactory[IO].getLogger

  def build: Resource[IO, Unit] =
    for
      appConfig <- AppConfig.resource
      userService = UserService(PostgresUserRepository())
      routes = HttpServer.createRoutes(
        HealthRouter.endpoints ++ UserRouter(userService).endpoints
      )
      _ <- HttpServer.createResource(appConfig.http, routes)
      _ <- DbClient.prepareDatabase(appConfig.db)
      _ <- DbClient.createResource(appConfig.db)
      _ <- Resource.eval(logger.info("Manta started"))
    yield ()

  override def run(args: List[String]): IO[ExitCode] =
    build.use(_ => IO.never).as(ExitCode.Success)
