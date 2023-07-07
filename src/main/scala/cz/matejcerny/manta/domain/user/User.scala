package cz.matejcerny.manta.domain.user

import cz.matejcerny.manta.domain.Primitives.String100
import cz.matejcerny.manta.domain.user.Email

case class User(
    email: Email,
    firstName: Option[String100],
    lastName: Option[String100]
)
