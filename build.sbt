lazy val root = (project in file("."))
  .settings(name := "Advent of Code")
  .settings(moduleName := "advent-of-code")
  .settings(version := "0.1")
  .settings(scalaVersion := "2.13.3")

lazy val dependencies = Seq("org.scalatest" %% "scalatest"   % "3.2.0"  % "test")

scalacOptions ++= Seq("-deprecation", "-feature")
