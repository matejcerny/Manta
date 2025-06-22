package cz.matejcerny.manta.codec.tapir

import cz.matejcerny.manta.domain.primitive.String50
import sttp.tapir.{ Schema, SchemaType }

trait CommonSchema:
  given Schema[String50] = Schema(SchemaType.SString())
