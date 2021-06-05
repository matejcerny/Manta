package cz.matejcerny.manta.domain

case class EmailAddress(value: String) {
  require(
    value.matches("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,}"),
    s"$value is not a valid email address"
  )
}
