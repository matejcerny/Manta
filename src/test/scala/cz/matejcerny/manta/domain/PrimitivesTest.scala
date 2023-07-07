package cz.matejcerny.manta.domain

import cats.data.Validated
import cats.implicits.catsSyntaxValidatedId
import cz.matejcerny.manta.domain.Primitives.String100
import org.scalatest.*
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class PrimitivesTest extends AnyFlatSpec with should.Matchers:

  "String100" should "be valid/invalid" in {
    val string = "a" * 100
    val long = s"${string}a"

    assert(String100(string) == string.valid)
    assert(String100(long) == MantaError(s"'$long' is longer than 100 characters").invalid)
  }
