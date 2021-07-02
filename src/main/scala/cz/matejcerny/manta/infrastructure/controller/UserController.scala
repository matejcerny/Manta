package cz.matejcerny.manta.infrastructure.controller

import cz.matejcerny.manta.domain.user.{User, UserService}
import cz.matejcerny.manta.infrastructure.endpoint.UserEndpoint
import org.http4s.HttpRoutes
import io.circe.generic.auto._
import io.circe.syntax._
import org.http4s.circe._
import sttp.tapir.server.http4s.Http4sServerInterpreter._

class UserController[F[_]](userService: UserService[F]) {

//  def routes: HttpRoutes[F] =
//    toRoutes(UserEndpoint.listAllUsers) {
//      for (users <- userService.listAllUsers) yield users.asJson
//
//    }

  //def listAllUsers[F[_]](): F[Either[(StatusCode, String), Seq[User]]] = ???

}

object UserController {

  //def routes[F[_]](userService: UserService[F]): HttpRoutes[F] = new UserController(userService).routes

}
