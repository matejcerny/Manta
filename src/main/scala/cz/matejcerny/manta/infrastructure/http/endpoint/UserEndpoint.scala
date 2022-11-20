package cz.matejcerny.manta.infrastructure.http.endpoint

import cz.matejcerny.manta.domain.user.User
import io.circe.generic.auto.*
import sttp.model.StatusCode
import sttp.tapir.*
import sttp.tapir.generic.auto.*
import sttp.tapir.json.circe.*

object UserEndpoint {

  // TODO: change public endpoint to secured
  val ListAllUsers: PublicEndpoint[Unit, (StatusCode, String), Seq[User], Any] =
    endpoint.get
      .in("users")
      .description("Returns all users")
      .out(jsonBody[Seq[User]])
      .errorOut(statusCode)
      .errorOut(stringBody)

}
