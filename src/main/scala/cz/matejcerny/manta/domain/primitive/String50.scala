package cz.matejcerny.manta.domain.primitive

import cats.data.Validated

opaque type String50 = String

object String50:
  extension (string50: String50) def value: String = string50

  def fromString(value: String): Validated[String, String50] =
    Validated.cond(
      value.length <= 50,
      value,
      s"'$value' is longer than 50 characters"
    )
