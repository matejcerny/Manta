//package cz.matejcerny.manta.codec.tapir
//
//import cz.matejcerny.manta.domain.user.{ Email, EmailAddress }
//import sttp.tapir.{ Codec, CodecFormat, DecodeResult, Schema, SchemaType }
//
//object UserCodec:
//  given Codec[String, EmailAddress, CodecFormat.TextPlain] =
//    Codec.string.mapEither(EmailAddress.fromString(_).toEither)(_.value)
