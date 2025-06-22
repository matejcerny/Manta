package cz.matejcerny.manta.codec.json

import cz.matejcerny.manta.codec.json.CommonCodec.given
import cz.matejcerny.manta.domain.user.{ Email, EmailAddress, User }
import io.circe.Decoder.decodeString
import io.circe.Encoder.encodeString
import io.circe.{ Decoder, Encoder }

object UserCodec:
  given Encoder[EmailAddress] = encodeString.contramap[EmailAddress](_.value)
  given Decoder[EmailAddress] = decodeString.emap(EmailAddress.fromString(_).toEither)

  given Encoder[Email] = Encoder.derived
  given Decoder[Email] = Decoder.derived
  given Encoder[Email.VerifiedEmail] = Encoder.derived
  given Decoder[Email.VerifiedEmail] = Decoder.derived

  given Encoder[User] = Encoder.derived
  given Decoder[User] = Decoder.derived
