package cz.matejcerny.manta.domain.user

import cz.matejcerny.manta.domain.String50

case class User(
  email: Email,
  firstName: Option[String50],
  lastName: Option[String50]
)
