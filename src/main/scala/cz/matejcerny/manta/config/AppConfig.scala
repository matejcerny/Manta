package cz.matejcerny.manta.config

import cats.effect.{ IO, Resource }
import cats.syntax.all.*
import ciris.*

case class AppConfig(
    http: HttpConfig,
    db: DbConfig,
    auth: AuthConfig
)

object AppConfig:
  object Defaults:
    val HttpHost = "localhost"
    val HttpPort = 8080
    val DatabaseUser = "postgres"
    val DatabasePassword = "postgres"
    val DatabaseUrl = "jdbc:postgresql://localhost:5432/postgres"
    val DatabaseDriver = "org.postgresql.Driver"
    val DatabaseSchema = "manta"
    val DatabaseThreadPoolSize = 2

  def resource: Resource[IO, AppConfig] =
    Resource.eval(
      (
        HttpConfig.load,
        DbConfig.load,
        AuthConfig.load
      )
        .parMapN(AppConfig.apply)
        .load[IO]
    )
