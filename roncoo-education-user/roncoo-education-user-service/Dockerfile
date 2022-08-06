FROM --platform=linux/amd64 openjdk:18-jdk-alpine
MAINTAINER roncoo
ARG JAVA_OPTS="-Xmx128M"
ENV JAVA_OPTS=$JAVA_OPTS
ARG RUN_ARGS="--spring.profiles.active=demo"
ENV RUN_ARGS=$RUN_ARGS
ADD target/user-service.jar /user-service.jar
ENTRYPOINT ["java", "-jar", "/user-service.jar", "$RUN_ARGS"]
