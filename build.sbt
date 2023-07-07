import Dependencies.*

ThisBuild / organization := "cz.matejcerny"
ThisBuild / scalaVersion := "3.3.0"
ThisBuild / assemblyJarName := s"${name.value}.jar"
ThisBuild / scalacOptions := Options.scalacOptions

lazy val manta = project
  .in(file("."))
  .settings(
    libraryDependencies ++=
      Cats ++
        Config ++
        Database ++
        Json ++
        Http ++
        Logging ++
        Testing
  )
