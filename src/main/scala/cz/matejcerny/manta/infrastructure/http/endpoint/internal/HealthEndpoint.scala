package cz.matejcerny.manta.infrastructure.http.endpoint.internal

import sttp.model.StatusCode
import sttp.tapir.*

object HealthEndpoint:

  val GetHealth: PublicEndpoint[Unit, StatusCode, StatusCode, Any] =
    endpoint.get
      .name("health")
      .in("health")
      .description("Health check endpoint")
      .out(statusCode)
      .errorOut(statusCode)
