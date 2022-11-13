import sbt._

object Dependencies {

  private object Versions {
    val CatsCore = "2.8.0"
    val CatsEffect = "3.3.14"
    val Circe = "0.14.3"
    val Config = "3.0.0"
    val Http4s = "0.23.12"
    val Logback = "1.4.4"
    val ScalaLogging = "3.9.5"
    val ScalaTest = "3.2.14"
    val SLF4J = "2.0.3"
    val Tapir = "1.2.0"
  }

  private object Modules {
    val Cats = "org.typelevel"
    val Circe = "io.circe"
    val Config = "is.cir"
    val Http4s = "org.http4s"
    val Logback = "ch.qos.logback"
    val ScalaLogging = "com.typesafe.scala-logging"
    val ScalaTest = "org.scalatest"
    val SLF4J = "org.slf4j"
    val Tapir = "com.softwaremill.sttp.tapir"
  }

  val Cats: Seq[ModuleID] = Seq(
    Modules.Cats %% "cats-core" % Versions.CatsCore,
    Modules.Cats %% "cats-effect" % Versions.CatsEffect
  )

  val Circe: Seq[ModuleID] = Seq(
    Modules.Circe %% "circe-generic" % Versions.Circe
  )

  val Config: Seq[ModuleID] = Seq(
    Modules.Config %% "ciris" % Versions.Config
  )

  val Http4s: Seq[ModuleID] = Seq(
    Modules.Http4s %% "http4s-ember-server" % Versions.Http4s,
    Modules.Http4s %% "http4s-circe" % Versions.Http4s
  )

  val Logging: Seq[ModuleID] = Seq(
    Modules.Logback % "logback-classic" % Versions.Logback,
    Modules.ScalaLogging %% "scala-logging" % Versions.ScalaLogging,
    Modules.SLF4J % "slf4j-api" % Versions.SLF4J
  )

  val Tapir: Seq[ModuleID] = Seq(
    Modules.Tapir %% "tapir-core" % Versions.Tapir,
    Modules.Tapir %% "tapir-http4s-server" % Versions.Tapir,
    Modules.Tapir %% "tapir-json-circe" % Versions.Tapir
  )

  val Testing: Seq[ModuleID] = Seq(
    Modules.ScalaTest %% "scalatest" % Versions.ScalaTest % Test
  )

}
