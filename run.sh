#!/bin/bash
sbt --error 'set showSuccess := false' assembly > /dev/null
java -jar poker-evaluator.jar
