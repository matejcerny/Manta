package cz.matejcerny.manta.domain

sealed trait MantaError extends Throwable { def reason: String }

object MantaError {
  case class CannotParseConfig(reason: String) extends MantaError
}
