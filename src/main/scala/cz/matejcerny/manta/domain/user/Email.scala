package cz.matejcerny.manta.domain.user

sealed trait Email

object Email {
  case class UnverifiedEmail(emailAddress: EmailAddress) extends Email
  case class VerifiedEmail(emailAddress: EmailAddress) extends Email
}
