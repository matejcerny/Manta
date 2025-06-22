package cz.matejcerny.manta.infrastructure.http.router

import cats.effect.IO
import cats.syntax.either.*
import cz.matejcerny.manta.domain.Problem
import org.http4s.HttpRoutes
import sttp.model.StatusCode

case class Routes(underlying: HttpRoutes[IO])

object Routes:
  extension [T](io: IO[T])
    def handleErrors: IO[Either[(StatusCode, String), T]] =
      io.map(_.asRight)
        .recover:
          case Problem(reason) => (StatusCode.BadRequest, reason).asLeft
