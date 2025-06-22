package cz.matejcerny.manta.infrastructure.http

import cats.effect.{ IO, Resource }
import com.comcast.ip4s.{ Hostname, Port }
import cz.matejcerny.manta.config.HttpConfig
import cz.matejcerny.manta.infrastructure.http.router.Routes
import org.http4s.ember.server.EmberServerBuilder
import org.http4s.server.{ Router, Server }
import sttp.tapir.server.ServerEndpoint
import sttp.tapir.server.http4s.Http4sServerInterpreter

object HttpServer:
  def createRoutes(endpoints: List[ServerEndpoint[Any, IO]]): Routes =
    Routes(Http4sServerInterpreter[IO]().toRoutes(endpoints))

  def createResource(httpConfig: HttpConfig, routes: Routes): Resource[IO, Server] =
    EmberServerBuilder
      .default[IO]
      .withHostOption(Hostname.fromString(httpConfig.host))
      .withPort(Port.fromInt(httpConfig.port).get)
      .withHttpApp(Router("/" -> routes.underlying).orNotFound)
      .build
