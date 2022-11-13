import Dependencies._

ThisBuild / name := "Manta"
ThisBuild / organization := "cz.matejcerny"
ThisBuild / scalaVersion := "3.2.1"
ThisBuild / assemblyJarName := s"${name.value}.jar"

lazy val manta = project
  .in(file("."))
  .settings(libraryDependencies ++= Cats ++ Circe ++ Config ++ Http4s ++ Logging ++ Testing)
