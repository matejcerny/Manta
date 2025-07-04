package cz.matejcerny.manta.infrastructure.db.repository

import cats.effect.IO
import cats.implicits.catsSyntaxTuple3Semigroupal
import cats.syntax.option.*
import cz.matejcerny.manta.domain.Problem.toIO
import cz.matejcerny.manta.domain.primitive.String50
import cz.matejcerny.manta.domain.user.*
import cz.matejcerny.manta.repository.UserRepository

class PostgresUserRepository extends UserRepository:
  override def listAllUsers: IO[Seq[User]] =
    // TODO: get from database
    (
      EmailAddress.fromString("aaa@bbb.com").map(Email.UnverifiedEmail(_)),
      String50.fromString("first").map(_.some),
      String50.fromString("last").map(_.some)
    ).mapN(User.apply)
      .map(user => List(user))
      .toIO
