package cz.matejcerny.manta.infrastructure.http.endpoint.internal

import cz.matejcerny.manta.codec.json.given
import cz.matejcerny.manta.codec.tapir.{ Codecs, Schemas }
import cz.matejcerny.manta.domain.user.Email.VerifiedEmail
import cz.matejcerny.manta.domain.user.{ User, UserId }
import sttp.model.StatusCode
import sttp.tapir.*
import sttp.tapir.generic.auto.*
import sttp.tapir.json.circe.*

object UserEndpoint extends Codecs with Schemas:

  private val userIdPath = path[UserId]("userId")

  val ListAllUsers: PublicEndpoint[Unit, (StatusCode, String), Seq[User], Any] =
    endpoint.get
      .name("users")
      .in("users")
      .description("Returns all the users")
      .out(jsonBody[Seq[User]])
      .errorOut(statusCode)
      .errorOut(stringBody)

  val CheckAuth: Endpoint[String, UserId, (StatusCode, String), String, Any] =
    endpoint.get
      .name("users/:userId/check")
      .securityIn(auth.bearer[String]())
      .in("users" / userIdPath / "check")
      .description("Check if user is authenticated")
      .out(stringBody)
      .errorOut(statusCode)
      .errorOut(stringBody)
