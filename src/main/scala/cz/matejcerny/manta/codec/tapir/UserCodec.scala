package cz.matejcerny.manta.codec.tapir

import cz.matejcerny.manta.domain.user.{ Email, EmailAddress, UserId }
import sttp.tapir.{ Codec, CodecFormat, DecodeResult, Schema, SchemaType }

trait UserCodec:
  given Codec[String, UserId, CodecFormat.TextPlain] =
    Codec.string.mapEither(UserId.fromString(_).toEither)(_.value.toString)

  given Codec[String, EmailAddress, CodecFormat.TextPlain] =
    Codec.string.mapEither(EmailAddress.fromString(_).toEither)(_.value)
