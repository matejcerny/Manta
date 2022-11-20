import Dependencies._

ThisBuild / organization := "cz.matejcerny"
ThisBuild / scalaVersion := "3.2.2"
ThisBuild / assemblyJarName := s"${name.value}.jar"

lazy val manta = project
  .in(file("."))
  .settings(
    libraryDependencies ++=
      Cats ++
        Circe ++
        Config ++
        Doobie ++
        Http4s ++
        Logging ++
        Tapir ++
        Testing
  )
