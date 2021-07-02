package cz.matejcerny.manta.infrastructure.interpreter

import cats.effect.Bracket
import cz.matejcerny.manta.domain.user.{User, UserAlgebra}
import doobie.Transactor

class DoobieUserInterpreter[F[_]: Bracket[*[_], Throwable]](xa: Transactor[F]) extends UserAlgebra[F] {
  def create(user: User): F[User] = ??? // INSERT INTO user ...
}

object DoobieUserInterpreter {
  def apply[F[_]: Bracket[*[_], Throwable]](xa: Transactor[F]): DoobieUserInterpreter[F] =
    new DoobieUserInterpreter(xa)
}
