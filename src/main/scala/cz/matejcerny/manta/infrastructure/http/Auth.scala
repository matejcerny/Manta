package cz.matejcerny.manta.infrastructure.http

import cats.effect.{ IO, Sync }
import cz.matejcerny.manta.config.AuthConfig

import java.time.Instant

class Auth(authConfig: AuthConfig):
  def authenticate(token: String): IO[String] =
    for
      _ <- nowFn[IO]
      str <- IO.pure("Authenticated")
    yield str

  private def nowFn[F[_]: Sync]: F[Instant] = Sync[F].delay(Instant.now())
