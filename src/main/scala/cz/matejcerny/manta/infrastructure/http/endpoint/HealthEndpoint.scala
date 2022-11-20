package cz.matejcerny.manta.infrastructure.http.endpoint

import sttp.model.StatusCode
import sttp.tapir.*
import sttp.tapir.generic.auto.*
import sttp.tapir.json.circe.*

object HealthEndpoint {

  val GetHealth: PublicEndpoint[Unit, StatusCode, StatusCode, Any] =
    endpoint.get
      .in("health")
      .description("Health check endpoint")
      .out(statusCode)
      .errorOut(statusCode)

}
