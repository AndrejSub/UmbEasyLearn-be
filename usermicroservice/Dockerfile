FROM docker.io/eclipse-temurin:21

WORKDIR /app

COPY ../usermicroservice/target/usermicroservice-0.0.1-SNAPSHOT.jar /app/usermicroservice-0.0.1-SNAPSHOT.jar

EXPOSE 8989/tcp

CMD ["java", "-XX:+UseG1GC", "-jar", "usermicroservice-0.0.1-SNAPSHOT.jar"]