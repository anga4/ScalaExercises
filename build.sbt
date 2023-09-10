import Dependencies._

ThisBuild / scalaVersion     := "2.13.11"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

val scalatestVersion = "3.2.16"

lazy val root = (project in file("."))
  .settings(
    name := "Scala Exercises",
    libraryDependencies += "org.scalatest" %% "scalatest" % scalatestVersion % "test"
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
