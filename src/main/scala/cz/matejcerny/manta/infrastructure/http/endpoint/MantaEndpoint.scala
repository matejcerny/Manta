package cz.matejcerny.manta.infrastructure.http.endpoint

import sttp.model.StatusCode
import sttp.tapir.{ Endpoint, auth, endpoint, statusCode, stringBody }

trait MantaEndpoint:
  type EOUT = (StatusCode, String)

  def mantaEndpoint(name: String, description: String): Endpoint[Unit, Unit, EOUT, Unit, Any] =
    endpoint
      .name(name)
      .description(description)
      .errorOut(statusCode)
      .errorOut(stringBody)

  def mantaPublicEndpoint(name: String, description: String): Endpoint[String, Unit, EOUT, Unit, Any] =
    mantaEndpoint(name, description)
      .securityIn(auth.bearer[String]())