package cz.matejcerny.manta.domain

import cats.kernel.Semigroup

case class MantaError(reason: String) extends Throwable

object MantaError:
  given semigroup: Semigroup[MantaError] = (x: MantaError, y: MantaError) =>
    MantaError(s"${x.reason} + ${y.reason}")
