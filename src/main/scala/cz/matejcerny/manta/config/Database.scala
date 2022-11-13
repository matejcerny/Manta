package cz.matejcerny.manta.config

import cats.effect.{ IO, Resource }
import cats.syntax.all.*
import ciris.*
import cz.matejcerny.manta.config.AppConfig.*

case class Database(
    user: String,
    password: Secret[String],
    url: String,
    driver: String,
    schema: String
)

object Database {
  def load: ConfigValue[IO, Database] =
    (
      env("DB_USER").as[String].default(Defaults.DatabaseUser),
      env("DB_PASSWORD").as[String].secret.default(Secret(Defaults.DatabasePassword)),
      env("DB_URL").as[String].default(Defaults.DatabaseUrl),
      ConfigValue.default(Defaults.DatabaseDriver),
      ConfigValue.default(Defaults.DatabaseSchema)
    ).parMapN(Database.apply)
}
