lazy val root = project
  .in(file("."))
  .settings(
    name := "Advent of Code",
    moduleName := "advent-of-code",
    description := "Collection of solutions to codewars problems",
    version := "2023.1.1",
    scalaVersion := "3.3.0",
    scalacOptions ++= Seq("-deprecation", "-feature"),
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.15" % Test
  )

addCommandAlias("check", ";scalafmtCheck;Test / scalafmtCheck")
