#
# Build stage
#
FROM maven:3.6.0-jdk-8-slim AS build
COPY backend /home/app/src
RUN mvn -f /home/app/src/pom.xml clean install -DskipTests

#
# Package stage
#


FROM openjdk:8-jdk-alpine
COPY --from=build /home/app/target/app-2.6.3.war /usr/local/lib/app-2.6.3.war
EXPOSE 8080
CMD ["java", "-jar", "app-2.6.3.war"]