import sbt._

object Dependencies {

  private object Versions {
    val CatsCore = "2.6.1"
    val Circe = "0.14.1"
    val Config = "0.6.1"
    val Http4s = "0.21.24"
    val Logback = "1.2.3"
    val ScalaLogging = "3.9.3"
    val ScalaTest = "3.2.9"
    val SLF4J = "1.7.30"
    val Tapir = "0.18.0-M15"
  }

  private object Modules {
    val Cats = "org.typelevel"
    val Circe = "io.circe"
    val Config = "com.github.kxbmap"
    val Http4s = "org.http4s"
    val Logback = "ch.qos.logback"
    val ScalaLogging = "com.typesafe.scala-logging"
    val ScalaTest = "org.scalatest"
    val SLF4J = "org.slf4j"
    val Tapir = "com.softwaremill.sttp.tapir"
  }

  val Cats = Seq(Modules.Cats %% "cats-core" % Versions.CatsCore)
  val Config = Seq(Modules.Config %% "configs" % Versions.Config)

  val Json = Seq(
    Modules.Circe %% "circe-generic" % Versions.Circe,
    Modules.Tapir %% "tapir-json-circe" % Versions.Tapir
  )

  val Http = Seq(
    Modules.Http4s %% "http4s-blaze-server" % Versions.Http4s,
    Modules.Http4s %% "http4s-circe" % Versions.Http4s,
    Modules.Tapir %% "tapir-core" % Versions.Tapir,
    Modules.Tapir %% "tapir-http4s-server" % Versions.Tapir
  )

  val Logging = Seq(
    Modules.Logback % "logback-classic" % Versions.Logback,
    Modules.ScalaLogging %% "scala-logging" % Versions.ScalaLogging,
    Modules.SLF4J % "slf4j-api" % Versions.SLF4J
  )

  val Testing = Seq(Modules.ScalaTest %% "scalatest" % Versions.ScalaTest % Test)

}
