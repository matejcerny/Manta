package cz.matejcerny.manta.service

import cats.data.Validated
import cats.effect.IO
import cats.implicits.{ catsSyntaxTuple3Semigroupal, catsSyntaxValidatedId }
import cats.{ Applicative, Functor }
import cz.matejcerny.manta.domain.MantaError.semigroup
import cz.matejcerny.manta.domain.Primitives.*
import cz.matejcerny.manta.domain.user.*

class UserService:
  def listAllUsers[F[_]]: IO[Seq[User]] =
    IO.pure(
      (
        Email.UnverifiedEmail(EmailAddress("aaa@bbb.com")).valid,
        String100("first").map(Some.apply),
        String100("last").map(Some.apply)
      ).mapN(User.apply)
        .map(user => List(user))
        .getOrElse(List.empty)
    )
