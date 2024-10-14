FROM docker.io/eclipse-temurin:21

WORKDIR /app

COPY ../cofig-server/target/cofig-server-0.0.1-SNAPSHOT.jar /app/cofig-server-0.0.1-SNAPSHOT.jar

EXPOSE 8888/tcp

CMD ["java", "-XX:+UseG1GC", "-jar", "cofig-server-0.0.1-SNAPSHOT.jar"]