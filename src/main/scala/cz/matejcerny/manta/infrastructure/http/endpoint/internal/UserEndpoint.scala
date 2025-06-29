package cz.matejcerny.manta.infrastructure.http.endpoint.internal

import cz.matejcerny.manta.codec.json.given
import cz.matejcerny.manta.codec.tapir.{ Codecs, Schemas }
import cz.matejcerny.manta.domain.user.Email.VerifiedEmail
import cz.matejcerny.manta.domain.user.User
import cz.matejcerny.manta.infrastructure.http.endpoint.MantaEndpoint
import sttp.tapir.*
import sttp.tapir.generic.auto.*
import sttp.tapir.json.circe.*

object UserEndpoint extends MantaEndpoint with Codecs with Schemas:

  val ListAllUsers: PublicEndpoint[Unit, EOUT, Seq[User], Any] =
    mantaEndpoint(
      "GET users",
      "Returns all the users"
    ).get
      .in("internal" / "users")
      .out(jsonBody[Seq[User]])
