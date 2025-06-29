import Dependencies._

ThisBuild / organization := "cz.matejcerny"
ThisBuild / scalaVersion := "3.7.1"
ThisBuild / assemblyJarName := s"${name.value}.jar"

lazy val manta = project
  .in(file("."))
  .settings(
    libraryDependencies ++=
      Cats ++
        Circe ++
        Config ++
        Doobie ++
        Flyway ++
        Http4s ++
        Http4sJwt ++
        Jwt ++
        Logging ++
        Tapir ++
        Testing
  )
