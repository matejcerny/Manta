package cz.matejcerny.manta.config

import cats.effect.{ IO, Resource }
import cats.syntax.all.*
import ciris.*
import cz.matejcerny.manta.config.AppConfig.*

case class HttpConfig(host: String, port: Int)

object HttpConfig:
  def load: ConfigValue[IO, HttpConfig] =
    (
      env("HTTP_HOST").as[String].default(Defaults.HttpHost),
      env("HTTP_PORT").as[Int].default(Defaults.HttpPort)
    ).parMapN(HttpConfig.apply)

