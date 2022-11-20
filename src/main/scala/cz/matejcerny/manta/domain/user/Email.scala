package cz.matejcerny.manta.domain.user

import cz.matejcerny.manta.domain.user.{ Email, EmailAddress }

enum Email(emailAddress: EmailAddress):
  case UnverifiedEmail(emailAddress: EmailAddress) extends Email(emailAddress)
  case VerifiedEmail(emailAddress: EmailAddress) extends Email(emailAddress)
