FROM docker.io/eclipse-temurin:21

WORKDIR /app

COPY ../identityService/target/identityservice-0.0.1-SNAPSHOT.jar /app/identityservice-0.0.1-SNAPSHOT.jar

EXPOSE 8889/tcp

CMD ["java", "-XX:+UseG1GC", "-jar", "identityservice-0.0.1-SNAPSHOT.jar"]