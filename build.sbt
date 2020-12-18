name := "poker-hand-evaluator"

version := "0.1"

scalaVersion := "2.13.3"

assemblyOutputPath in assembly := new File("./poker-evaluator.jar")
mainClass in assembly := Some("com.evolutiongaming.bootcamp.assignment.poker.Main")