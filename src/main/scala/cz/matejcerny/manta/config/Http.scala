package cz.matejcerny.manta.config

import cats.effect.{ IO, Resource }
import cats.syntax.all.*
import ciris.*
import cz.matejcerny.manta.config.AppConfig.*

case class Http(host: String, port: Int)

object Http {
  def load: ConfigValue[IO, Http] =
    (
      env("HTTP_HOST").as[String].default(Defaults.HttpHost),
      env("HTTP_PORT").as[Int].default(Defaults.HttpPort)
    ).parMapN(Http.apply)
}
