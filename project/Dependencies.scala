import sbt.*

object Dependencies {

  private object Versions {
    val CatsCore = "2.9.0"
    val CatsEffect = "3.5.1"
    val Circe = "0.14.5"
    val Ciris = "3.2.0"
    val Doobie = "1.0.0-RC4"
    val Flyway = "9.16.0"
    val Http4s = "0.23.21"
    val Logback = "1.4.7"
    val Log4Cats = "2.6.0"
    val ScalaTest = "3.2.16"
    val Tapir = "1.6.0"
  }

  private object Modules {
    val Cats = "org.typelevel"
    val Circe = "io.circe"
    val Ciris = "is.cir"
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

  val Config: Seq[ModuleID] = Seq(Modules.Ciris %% "ciris" % Versions.Ciris)

  val Database: Seq[ModuleID] = Seq(
    Modules.Doobie %% "doobie-core" % Versions.Doobie,
    Modules.Doobie %% "doobie-postgres" % Versions.Doobie,
    Modules.Doobie %% "doobie-hikari" % Versions.Doobie,
    Modules.Flyway % "flyway-core" % Versions.Flyway
  )

  val Json: Seq[ModuleID] = Seq(
    Modules.Circe %% "circe-core" % Versions.Circe,
    Modules.Circe %% "circe-generic" % Versions.Circe,
    Modules.Circe %% "circe-parser" % Versions.Circe
  )

  val Http: Seq[ModuleID] = Seq(
    Modules.Http4s %% "http4s-ember-server" % Versions.Http4s,
    Modules.Http4s %% "http4s-circe" % Versions.Http4s,
    Modules.Tapir %% "tapir-core" % Versions.Tapir,
    Modules.Tapir %% "tapir-http4s-server" % Versions.Tapir,
    Modules.Tapir %% "tapir-json-circe" % Versions.Tapir
  )

  val Logging: Seq[ModuleID] = Seq(
    Modules.Logback % "logback-classic" % Versions.Logback,
    Modules.Cats %% "log4cats-slf4j" % Versions.Log4Cats
  )

  val Testing: Seq[ModuleID] = Seq(
    Modules.ScalaTest %% "scalatest" % Versions.ScalaTest % Test
  )

}
