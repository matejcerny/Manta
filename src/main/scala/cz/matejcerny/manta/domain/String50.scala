package cz.matejcerny.manta.domain

case class String50(value: String) {
  require(value.length <= 50, s"$value is longer than 50 characters")
}
