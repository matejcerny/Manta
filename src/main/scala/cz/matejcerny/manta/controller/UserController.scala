package cz.matejcerny.manta.controller

import cz.matejcerny.manta.domain.User
import sttp.model.StatusCode

object UserController {

  def listAllUsers[F[_]](): F[Either[(StatusCode, String), Seq[User]]] = ???

}
