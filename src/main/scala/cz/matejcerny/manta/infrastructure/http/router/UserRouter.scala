package cz.matejcerny.manta.infrastructure.http.router

import cats.effect.IO
import cz.matejcerny.manta.infrastructure.http.Auth
import cz.matejcerny.manta.infrastructure.http.endpoint.internal.UserEndpoint
import cz.matejcerny.manta.infrastructure.http.endpoint.public.UserPublicEndpoint
import cz.matejcerny.manta.infrastructure.http.router.Routes.handleErrors
import cz.matejcerny.manta.service.UserService
import sttp.tapir.server.ServerEndpoint

class UserRouter(auth: Auth, userService: UserService):

  private val listAllUsers =
    UserEndpoint.ListAllUsers.serverLogic(_ => userService.listAllUsers.handleErrors)

  private val checkAuth =
    UserPublicEndpoint.CheckAuth
      .serverSecurityLogic(auth.authenticate(_).handleErrors)
      .serverLogic(_ => userService.checkAuth(_).handleErrors)

  val endpoints: List[ServerEndpoint[Any, IO]] = List(listAllUsers)
  val publicEndpoints: List[ServerEndpoint[Any, IO]] = List(checkAuth)
