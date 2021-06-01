package cz.matejcerny.manta.config

case class Database(
  user: String,
  password: String,
  url: String,
  driver: String,
  schema: String
)
