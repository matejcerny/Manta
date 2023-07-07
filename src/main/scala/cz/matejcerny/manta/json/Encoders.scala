package cz.matejcerny.manta.json

import cz.matejcerny.manta.domain.Primitives.String100
import io.circe.Encoder

object Encoders:
  given Encoder[String100] = Encoder[String].contramap(_.underlying)
