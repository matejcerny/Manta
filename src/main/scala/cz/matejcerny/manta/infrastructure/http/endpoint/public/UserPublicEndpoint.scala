package cz.matejcerny.manta.infrastructure.http.endpoint.public

import cz.matejcerny.manta.codec.tapir.{ Codecs, Schemas }
import cz.matejcerny.manta.domain.user.UserId
import cz.matejcerny.manta.infrastructure.http.endpoint.MantaEndpoint
import sttp.tapir.*

object UserPublicEndpoint extends MantaEndpoint with Codecs with Schemas:

  private val userIdPath = path[UserId]("userId")

  val CheckAuth: Endpoint[String, UserId, EOUT, String, Any] =
    mantaPublicEndpoint(
      "GET users/:userId/check",
      "Check if user is authenticated"
    ).get
      .in("users" / userIdPath / "check")
      .out(stringBody)
