# ---- Build stage ----
FROM eclipse-temurin:17-jdk AS build
WORKDIR /app

# Copy the project files to the build container
COPY . .

# Give execute permission to mvnw and then build the Spring Boot application using Maven Wrapper
RUN chmod +x ./mvnw && ./mvnw clean package -DskipTests

# ---- Run stage ----
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Copy only the built JAR file from the previous stage
COPY --from=build /app/target/*.jar app.jar

# Expose port 8080 (default Spring Boot port)
EXPOSE 8080

# Start the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
