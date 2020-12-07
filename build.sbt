lazy val root = (project in file("."))
  .settings(name := "Advent of Code")
  .settings(moduleName := "advent-of-code")
  .settings(version := "0.1")
  .settings(scalaVersion := "2.13.3")

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.3"

scalacOptions ++= Seq("-deprecation", "-feature")
