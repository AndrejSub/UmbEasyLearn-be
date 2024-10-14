FROM docker.io/eclipse-temurin:21

WORKDIR /app

COPY ../discovery/target/discovery-0.0.1-SNAPSHOT.jar /app/discovery-0.0.1-SNAPSHOT.jar

EXPOSE 8761/tcp

CMD ["java", "-XX:+UseG1GC", "-jar", "discovery-0.0.1-SNAPSHOT.jar"]