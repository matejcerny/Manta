package cz.matejcerny.manta.domain

case class MantaError(reason: String) extends Throwable
