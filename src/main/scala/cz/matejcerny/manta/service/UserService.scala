package cz.matejcerny.manta.service

import cats.effect.IO
import cz.matejcerny.manta.domain.user.User

class UserService:
  def listAllUsers[F[_]]: F[Seq[User]] = ???

