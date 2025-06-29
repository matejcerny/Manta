package cz.matejcerny.manta.config

import cats.effect.IO
import ciris.*

// TODO: key should not be a String, but some kind of Secret
case class AuthConfig(key: String)

object AuthConfig:
  def load: ConfigValue[IO, AuthConfig] =
    env("JWT_KEY").as[String].map(AuthConfig.apply)
