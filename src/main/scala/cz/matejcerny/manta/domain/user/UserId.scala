package cz.matejcerny.manta.domain.user

import cats.data.Validated
import cats.implicits.catsSyntaxTry

import java.util.UUID
import scala.util.Try

opaque type UserId = UUID

object UserId:
  extension (userId: UserId) def value: UUID = userId

  def fromString(value: String): Validated[String, UserId] =
    Try(UUID.fromString(value)).toValidated.leftMap(_ => s"'$value' is not a valid UUID")

  def unsafe(value: String): UserId = UUID.fromString(value)
