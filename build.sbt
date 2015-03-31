import JmhKeys._


name := "pbkdf2-scala-benchmark"

version := "0.1-SNAPSHOT"

scalaVersion := "2.11.6"


jmhSettings

outputTarget in Jmh := target.value / s"scala-${scalaBinaryVersion.value}"


libraryDependencies += "io.github.nremond" %% "pbkdf2-scala" % "0.4-SNAPSHOT"