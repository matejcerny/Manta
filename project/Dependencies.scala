import sbt._

object Dependencies {

  private object Versions {
    val CatsCore = "2.9.0"
    val CatsEffect = "3.4.8"
    val Circe = "0.14.5"
    val Ciris = "3.1.0"
    val Doobie = "1.0.0-RC1"
    val Flyway = "9.16.0"
    val Http4s = "0.23.18"
    val Logback = "1.4.6"
    val Log4Cats = "2.5.0"
    val ScalaTest = "3.2.15"
    val Tapir = "1.2.10"
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
    Modules.Circe %% "circe-generic" % Versions.Circe
  )

  val Config: Seq[ModuleID] = Seq(
    Modules.Config %% "ciris" % Versions.Ciris
  )

  val Doobie: Seq[ModuleID] = Seq(
    Modules.Doobie %% "doobie-core" % Versions.Doobie,
    Modules.Doobie %% "doobie-postgres" % Versions.Doobie,
    Modules.Doobie %% "doobie-hikari" % Versions.Doobie,
    Modules.Flyway % "flyway-core" % Versions.Flyway,
  )

  val Http4s: Seq[ModuleID] = Seq(
    Modules.Http4s %% "http4s-ember-server" % Versions.Http4s,
    Modules.Http4s %% "http4s-circe" % Versions.Http4s
  )

  val Logging: Seq[ModuleID] = Seq(
    Modules.Logback % "logback-classic" % Versions.Logback,
    Modules.Cats %% "log4cats-slf4j" % Versions.Log4Cats
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
