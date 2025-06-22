package cz.matejcerny.manta.codec.json

import cz.matejcerny.manta.domain.String50
import io.circe.{ Decoder, Encoder }

object CommonCodec:
  given Encoder[String50] = Encoder.encodeString.contramap[String50](_.value)
  given Decoder[String50] = Decoder.decodeString.emap(String50.fromString(_).toEither)
