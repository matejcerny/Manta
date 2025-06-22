package cz.matejcerny.manta.infrastructure.http.router

import cats.effect.IO
import cz.matejcerny.manta.infrastructure.http.endpoint.internal.HealthEndpoint
import sttp.model.StatusCode
import sttp.tapir.server.ServerEndpoint

object HealthRouter:
  val endpoints: List[ServerEndpoint[Any, IO]] = List(
    HealthEndpoint.GetHealth.serverLogicSuccess(_ => IO.pure(StatusCode.Ok))
  )
