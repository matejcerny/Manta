package cz.matejcerny.manta.repository

import cats.effect.IO
import cz.matejcerny.manta.domain.user.User

trait UserRepository:
  def listAllUsers: IO[Seq[User]]
