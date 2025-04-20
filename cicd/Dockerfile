# Use a Maven image to build the app
FROM maven:3.9.6-eclipse-temurin-21 AS build

# Set working directory inside container
WORKDIR /app

# Copy pom.xml and download dependencies
COPY ../pom.xml .
RUN mvn dependency:go-offline

# Copy the source code
COPY ../src ./src

# Package the app
RUN mvn clean package -D skipTests

# Now use a smaller runtime image
FROM eclipse-temurin:21-jre

# Set working directory for running the app
WORKDIR /app

# Copy the jar file from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose port (optional if you know the port)
EXPOSE 8080

# Command to run the app
ENTRYPOINT ["java", "-jar", "app.jar"]