FROM maven:3.6-jdk-8-slim as builder
RUN mkdir -p /build
WORKDIR /build
COPY pom.xml .
COPY src ./src
RUN mvn package

FROM openjdk:8-slim
EXPOSE 1234
ENV APP_HOME /app
RUN mkdir $APP_HOME
WORKDIR $APP_HOME
COPY --from=builder /build/target/app.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
