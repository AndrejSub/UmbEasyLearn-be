FROM docker.io/eclipse-temurin:21

WORKDIR /app

COPY ../subjectsms/target/subjectsms-0.0.1-SNAPSHOT.jar /app/subjectsms-0.0.1-SNAPSHOT.jar

EXPOSE 8090/tcp

CMD ["java", "-XX:+UseG1GC", "-jar", "subjectsms-0.0.1-SNAPSHOT.jar"]