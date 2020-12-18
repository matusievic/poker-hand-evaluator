FROM ubuntu:latest

COPY . /poker-hand-evaluator
WORKDIR /poker-hand-evaluator
RUN ./prepare.sh

ENV JAVA_HOME /root/.sdkman/candidates/java/current
ENV SBT_HOME /root/.sdkman/candidates/sbt/current
ENV PATH $PATH:$JAVA_HOME/bin:$SBT_HOME/bin

RUN sbt --error 'set showSuccess := false' assembly

ENTRYPOINT ["java",  "-jar", "/poker-hand-evaluator/poker-evaluator.jar"]

