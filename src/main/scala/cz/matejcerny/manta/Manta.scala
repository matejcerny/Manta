package cz.matejcerny.manta

import cats.effect.*
import cats.implicits.*
import cz.matejcerny.manta.config.AppConfig
import cz.matejcerny.manta.infrastructure.db.DbClient
import cz.matejcerny.manta.infrastructure.http.HttpServer
import cz.matejcerny.manta.infrastructure.http.endpoint.{ HealthEndpoint, UserEndpoint }
import cz.matejcerny.manta.service.UserService
import org.typelevel.log4cats.*
import org.typelevel.log4cats.slf4j.*
import sttp.model.StatusCode

object Manta extends IOApp:

  private val logger: SelfAwareStructuredLogger[IO] = Slf4jFactory.create[IO].getLogger

  def build: Resource[IO, Unit] =
    for
      appConfig <- AppConfig.resource
      _ <- DbClient.prepareDatabase(appConfig.db)
      _ <- DbClient.createResource(appConfig.db)
      routes = HttpServer.createRoutes(
        List(
          HealthEndpoint.GetHealth.serverLogicSuccess(_ => IO.pure(StatusCode.Ok)),
          UserEndpoint.ListAllUsers.serverLogicSuccess(_ => UserService().listAllUsers)
        )
      )
      _ <- HttpServer.createResource(appConfig.http, routes)
      _ <- Resource.eval(logger.info("Manta started"))
    yield ()

  override def run(args: List[String]): IO[ExitCode] =
    build.use(_ => IO.never).as(ExitCode.Success)
