lazy val root = (project in file("."))
  .settings(name := "Advent of Code")
  .settings(moduleName := "advent-of-code")
  .settings(version := "0.1")
  .settings(scalaVersion := "3.1.0")


resolvers += "Artima Maven Repository" at "https://repo.artima.com/releases"


libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.14"

scalacOptions ++= Seq("-deprecation", "-feature")
