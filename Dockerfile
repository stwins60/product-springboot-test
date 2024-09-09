# Use an official OpenJDK runtime as a parent image
FROM openjdk:21-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the built jar file into the container
COPY pom.xml /app
COPY src /app/src

RUN apt update && apt install -y maven && mvn -f /app/pom.xml clean package -DskipTests

# Expose the application port (adjust according to your application)
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "/app/target/product-0.0.1-SNAPSHOT.jar"]
