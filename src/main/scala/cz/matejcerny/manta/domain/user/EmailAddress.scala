package cz.matejcerny.manta.domain.user

import cats.data.{ Validated, ValidatedNel }

opaque type EmailAddress = String

object EmailAddress:
  extension (emailAddress: EmailAddress) def value: String = emailAddress

  def fromString(value: String): Validated[String, EmailAddress] =
    val emailRegex = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,}$".r

    Validated.cond(
      emailRegex.matches(value),
      value,
      s"'$value' is not a valid email address"
    )

  def unsafe(value: String): EmailAddress = value
