name := "play-scala"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

// https://mvnrepository.com/artifact/org.apache.httpcomponents/httpclient
libraryDependencies += "org.apache.httpcomponents" % "httpclient" % "4.5.2"
// https://mvnrepository.com/artifact/org.jsoup/jsoup
libraryDependencies += "org.jsoup" % "jsoup" % "1.9.2"
libraryDependencies += "com.fasterxml.jackson.core" % "jackson-databind" % "2.8.1"
libraryDependencies += "com.fasterxml.jackson.module" % "jackson-module-scala_2.10" % "2.8.0.rc2"

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"
