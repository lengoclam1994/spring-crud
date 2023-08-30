FROM maven:3.8.5 AS build
WORKDIR /app
COPY pom.xml /app
RUN mvn dependency:resolve
COPY . /app
RUN mvn clean
RUN mvn package -DskipTests

FROM openjdk:14-jdk-alpine
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8090
CMD ["java", "-jar", "app.jar"]