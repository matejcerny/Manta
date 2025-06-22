package cz.matejcerny.manta.service

import cats.effect.IO
import cz.matejcerny.manta.domain.user.*
import cz.matejcerny.manta.repository.UserRepository

class UserService(userRepository: UserRepository):
  def listAllUsers: IO[Seq[User]] = userRepository.listAllUsers
