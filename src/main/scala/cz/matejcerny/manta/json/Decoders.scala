package cz.matejcerny.manta.json

import cz.matejcerny.manta.domain.Primitives.String100
import io.circe.Decoder

object Decoders:
  given Decoder[String100] = Decoder.decodeString.emap[String100](String100(_).leftMap(_.reason).toEither)
