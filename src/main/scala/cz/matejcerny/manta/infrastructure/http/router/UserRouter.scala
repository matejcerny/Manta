package cz.matejcerny.manta.infrastructure.http.router

import cats.effect.IO
import cz.matejcerny.manta.infrastructure.http.HttpServer.Routes
import cz.matejcerny.manta.infrastructure.http.endpoint.UserEndpoint
import cz.matejcerny.manta.service.UserService
import sttp.tapir.server.ServerEndpoint

class UserRouter[F[_]](userService: UserService):
  val endpoints: List[ServerEndpoint[Any, IO]] = List(
    UserEndpoint.ListAllUsers.serverLogicSuccess(_ => userService.listAllUsers)
  )
