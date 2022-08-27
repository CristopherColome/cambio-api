FROM maven:3.8.6-openjdk-11-slim AS build

WORKDIR /app

COPY . /app

RUN mvn -f /app/pom.xml clean package -DskipTests


FROM openjdk:11-jre-slim

WORKDIR /app

COPY --from=build /app/target/cambio-0.0.1-SNAPSHOT.jar /app/target/cambio-0.0.1-SNAPSHOT.jar

EXPOSE 8082

CMD ["java","-jar","/app/target/cambio-0.0.1-SNAPSHOT.jar"]