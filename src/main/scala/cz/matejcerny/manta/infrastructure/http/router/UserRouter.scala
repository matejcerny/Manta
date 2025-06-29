package cz.matejcerny.manta.infrastructure.http.router

import cats.effect.IO
import cz.matejcerny.manta.infrastructure.http.endpoint.internal.UserEndpoint
import cz.matejcerny.manta.infrastructure.http.router.Routes.handleErrors
import cz.matejcerny.manta.service.UserService
import sttp.tapir.server.ServerEndpoint

class UserRouter(userService: UserService):
  val endpoints: List[ServerEndpoint[Any, IO]] = List(
    UserEndpoint.ListAllUsers.serverLogic(_ => userService.listAllUsers.handleErrors),
    UserEndpoint.CheckAuth
      .serverSecurityLogic(_ => IO.pure(Right("Done")))
      .serverLogic(_ => userService.checkAuth(_).handleErrors)
  )
