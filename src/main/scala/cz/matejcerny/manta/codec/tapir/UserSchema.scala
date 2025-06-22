package cz.matejcerny.manta.codec.tapir

import cz.matejcerny.manta.domain.user.{ Email, EmailAddress }
import sttp.tapir.{ Schema, SchemaType }

trait UserSchema:
  given Schema[EmailAddress] = Schema(SchemaType.SString())
