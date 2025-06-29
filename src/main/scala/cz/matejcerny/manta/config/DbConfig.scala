package cz.matejcerny.manta.config

import cats.effect.IO
import cats.syntax.all.*
import ciris.*
import cz.matejcerny.manta.config.AppConfig.*

case class DbConfig(
    user: String,
    password: Secret[String],
    url: String,
    driver: String,
    schema: String,
    threadPoolSize: Int
)

object DbConfig:
  def load: ConfigValue[IO, DbConfig] =
    (
      env("POSTGRES_USER").as[String].default(Defaults.DatabaseUser),
      env("POSTGRES_PASSWORD").as[String].secret.default(Secret(Defaults.DatabasePassword)),
      env("POSTGRES_URL").as[String].default(Defaults.DatabaseUrl),
      ConfigValue.default(Defaults.DatabaseDriver),
      ConfigValue.default(Defaults.DatabaseSchema),
      ConfigValue.default(Defaults.DatabaseThreadPoolSize)
    ).parMapN(DbConfig.apply)
