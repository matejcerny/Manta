package cz.matejcerny.manta.domain

import cats.data.Validated
import cats.kernel.Semigroup
import cats.syntax.either.*

case class Problem(reason: String) extends Throwable

object Problem:
  given semigroup: Semigroup[Problem] = (x: Problem, y: Problem) => Problem(s"${x.reason} + ${y.reason}")

  extension [T](validated: Validated[String, T])
    def toProblem: Either[Problem, T] = validated.toEither.leftMap(Problem(_))
