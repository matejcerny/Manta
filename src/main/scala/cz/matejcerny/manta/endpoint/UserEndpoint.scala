package cz.matejcerny.manta.endpoint

import cz.matejcerny.manta.domain.User
import io.circe.generic.auto._
import sttp.model.StatusCode
import sttp.tapir._
import sttp.tapir.generic.auto._
import sttp.tapir.json.circe._

object UserEndpoint {

  val listAllUsers: Endpoint[Unit, (StatusCode, String), Seq[User], Any] =
    endpoint.get
      .in("users")
      .description("Returns all users")
      .out(jsonBody[Seq[User]])
      .errorOut(statusCode)
      .errorOut(stringBody)

}
