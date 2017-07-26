organization := "com.phasmid"

name := "PepperedMoth"

version := "1.0.0-SNAPSHOT"

scalaVersion := "2.11.8"

val scalaTestVersion = "2.2.4"

libraryDependencies ++= Seq(
  "com.phasmid" %% "darwin" % "1.0.0-SNAPSHOT",
  "com.typesafe.scala-logging" %% "scala-logging-slf4j" % "2.1.2",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.4.0",
  "ch.qos.logback" %  "logback-classic" % "1.1.7" % "runtime",
  "org.scalatest" %% "scalatest" % scalaTestVersion % "test"
)

