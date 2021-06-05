package cz.matejcerny.manta.domain

case class User(
  email: Email,
  firstName: Option[String50],
  lastName: Option[String50]
)
