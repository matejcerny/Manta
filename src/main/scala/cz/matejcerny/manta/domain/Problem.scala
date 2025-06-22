package cz.matejcerny.manta.domain

import cats.kernel.Semigroup

case class Problem(reason: String) extends Throwable

object Problem:
  given semigroup: Semigroup[Problem] = (x: Problem, y: Problem) =>
    Problem(s"${x.reason} + ${y.reason}")
