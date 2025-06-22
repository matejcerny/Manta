package cz.matejcerny.manta.domain

import cats.data.Validated
import cats.implicits.catsSyntaxValidatedId
import cats.syntax.either.*
import cz.matejcerny.manta.domain.Problem.*
import cz.matejcerny.manta.domain.primitive.String50
import org.scalatest.*
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class PrimitiveTest extends AnyFlatSpec with Matchers:

  "String100" should "be valid/invalid" in:
    val string = "a" * 50
    val long = s"${string}a"

    assert(String50.fromString(string) == string.valid)
    assert(String50.fromString(long).toProblem == Problem(s"'$long' is longer than 50 characters").asLeft)
