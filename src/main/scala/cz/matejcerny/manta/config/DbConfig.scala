package cz.matejcerny.manta.config

case class DbConfig(
  user: String,
  password: String,
  url: String,
  driver: String,
  maxConnections: Int,
  schema: String
)
