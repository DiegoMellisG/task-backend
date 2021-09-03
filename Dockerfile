
FROM maven:3.5.2-jdk-8-alpine AS build-stage

COPY pom.xml /build/
COPY src /build/src/
WORKDIR /build/
RUN mvn package -Dmaven.test.skip=true


FROM openjdk:8-jre-alpine as production-stage
WORKDIR /app
COPY --from=build-stage /build/target/backend-0.0.1-SNAPSHOT.jar /app/
ENTRYPOINT ["java", "-jar", "backend-0.0.1-SNAPSHOT.jar"]