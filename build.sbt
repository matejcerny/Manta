import Dependencies._

ThisBuild / name := "Manta"
ThisBuild / organization := "cz.matejcerny"
ThisBuild / scalaVersion := "2.13.6"
ThisBuild / assemblyJarName := s"${name.value}.jar"

lazy val manta = project
  .in(file("."))
  .settings(libraryDependencies ++= Cats ++ Json ++ Config ++ Http ++ Logging ++ Testing)

ThisBuild / scalacOptions ++= Seq(
  "-deprecation", // Emit warning and location for usages of deprecated APIs.
  "-encoding",
  "utf8", // Specify character encoding used by source files.
  "-feature", // Emit warning and location for usages of features that should be imported explicitly.
  "-language:existentials", // Existential types (besides wildcard types) can be written and inferred.
  "-language:higherKinds", // Allow higher-kinded types.
  "-language:implicitConversions", // Allow definition of implicit functions called views.
  "-language:postfixOps", // Allow postfix operator notation, such as 1 to 10 toList (not recommended).
  "-unchecked", // Enable additional warnings where generated code depends on assumptions.
  "-Xcheckinit", // Wrap field accessors to throw an exception on uninitialized access.
  "-Ywarn-unused:imports", // Warn if an import selector is not referenced.
)
