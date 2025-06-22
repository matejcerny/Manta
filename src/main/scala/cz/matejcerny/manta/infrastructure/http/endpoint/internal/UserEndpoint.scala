package cz.matejcerny.manta.infrastructure.http.endpoint.internal

import cz.matejcerny.manta.codec.json.given
import cz.matejcerny.manta.codec.tapir.Schemas
import cz.matejcerny.manta.domain.user.Email.VerifiedEmail
import cz.matejcerny.manta.domain.user.User
import sttp.model.StatusCode
import sttp.tapir.*
import sttp.tapir.generic.auto.*
import sttp.tapir.json.circe.*

object UserEndpoint extends Schemas:

  val ListAllUsers: PublicEndpoint[Unit, (StatusCode, String), Seq[User], Any] =
    endpoint.get
      .name("users")
      .in("users")
      .description("Returns all the users")
      .out(jsonBody[Seq[User]])
      .errorOut(statusCode)
      .errorOut(stringBody)
