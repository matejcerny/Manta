import sbt._

object Dependencies {

  private object Versions {
    val CatsCore = "2.13.0"
    val CatsEffect = "3.6.1"
    val Circe = "0.14.14"
    val Ciris = "3.9.0"
    val Doobie = "1.0.0-RC9"
    val Flyway = "11.9.2"
    val Http4s = "0.23.30"
    val Logback = "1.5.18"
    val Log4Cats = "2.7.1"
    val ScalaTest = "3.2.19"
    val Tapir = "1.11.34"
  }

  private object Modules {
    val Cats = "org.typelevel"
    val Circe = "io.circe"
    val Config = "is.cir"
    val Doobie = "org.tpolecat"
    val Flyway = "org.flywaydb"
    val Http4s = "org.http4s"
    val Logback = "ch.qos.logback"
    val ScalaTest = "org.scalatest"
    val Tapir = "com.softwaremill.sttp.tapir"
  }

  val Cats: Seq[ModuleID] = Seq(
    Modules.Cats %% "cats-core" % Versions.CatsCore,
    Modules.Cats %% "cats-effect" % Versions.CatsEffect
  )

  val Circe: Seq[ModuleID] = Seq(
    Modules.Circe %% "circe-core",
    Modules.Circe %% "circe-generic",
    Modules.Circe %% "circe-parser"
  ).map(_ % Versions.Circe)

  val Config: Seq[ModuleID] = Seq(
    Modules.Config %% "ciris" % Versions.Ciris
  )

  val Doobie: Seq[ModuleID] = Seq(
    Modules.Doobie %% "doobie-core",
    Modules.Doobie %% "doobie-postgres",
    Modules.Doobie %% "doobie-hikari"
  ).map(_ % Versions.Doobie)

  val Flyway: Seq[ModuleID] = Seq(
    Modules.Flyway % "flyway-core" % Versions.Flyway,
    Modules.Flyway % "flyway-database-postgresql" % Versions.Flyway
  )

  val Http4s: Seq[ModuleID] = Seq(
    Modules.Http4s %% "http4s-ember-server",
    Modules.Http4s %% "http4s-circe"
  ).map(_ % Versions.Http4s)

  val Logging: Seq[ModuleID] = Seq(
    Modules.Logback % "logback-classic" % Versions.Logback,
    Modules.Cats %% "log4cats-slf4j" % Versions.Log4Cats
  )

  val Tapir: Seq[ModuleID] = Seq(
    Modules.Tapir %% "tapir-core",
    Modules.Tapir %% "tapir-http4s-server",
    Modules.Tapir %% "tapir-json-circe"
  ).map(_ % Versions.Tapir)

  val Testing: Seq[ModuleID] = Seq(
    Modules.ScalaTest %% "scalatest" % Versions.ScalaTest % Test
  )

}
