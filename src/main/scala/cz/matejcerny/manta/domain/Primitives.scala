package cz.matejcerny.manta.domain

import cats.data.Validated
import cats.implicits.catsSyntaxValidatedId

object Primitives:
  opaque type String100 = String
  def String100(s: String): Validated[MantaError, String100] =
    if s.length <= 100 then s.valid
    else MantaError(s"'$s' is longer than 100 characters").invalid

  extension(s: String100)
    def underlying: String = s

