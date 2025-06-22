package cz.matejcerny.manta.domain.user

import cz.matejcerny.manta.domain.primitive.String50
import cz.matejcerny.manta.domain.user.Email

case class User(
    email: Email,
    firstName: Option[String50],
    lastName: Option[String50]
)
