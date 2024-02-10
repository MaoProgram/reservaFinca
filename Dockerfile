#
#FROM maven:3.6.3-openjdk-17-slim AS build
#LABEL authors="reserva fincas adm"
#
#WORKDIR /app
#
#COPY pom.xml .
#RUN mvn dependency:go-offline
#COPY src ./src
#RUN mvn clean package
#
#FROM openjdk:21-jre-alpine
#WORKDIR /app
#
#COPY --from=build /app/target/*.jar app.jar
#
#EXPOSE 8081
#ENTRYPOINT ["java", "-jar", "app.jar"]

# Build Stage
FROM eclipse-temurin:21-jdk-alpine as build

WORKDIR /app

# Install Maven
RUN apk add --no-cache curl tar bash \
    && mkdir -p /usr/local/maven \
    && curl -fsSL https://archive.apache.org/dist/maven/maven-3/3.9.6/binaries/apache-maven-3.9.6-bin.tar.gz | tar -xzC /usr/local/maven --strip-components=1 \
    && ln -s /usr/local/maven/bin/mvn /usr/bin/mvn

COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests

# Run Stage
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]