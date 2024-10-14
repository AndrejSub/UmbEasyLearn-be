FROM docker.io/eclipse-temurin:21

WORKDIR /app

COPY ../apigateway/target/apigateway-0.0.1-SNAPSHOT.jar /app/apigateway-0.0.1-SNAPSHOT.jar

EXPOSE 8222/tcp

CMD ["java", "-XX:+UseG1GC", "-jar", "apigateway-0.0.1-SNAPSHOT.jar"]