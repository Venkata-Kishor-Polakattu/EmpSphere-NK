FROM eclipse-temurin:17-jre

WORKDIR /app

COPY target/empsphere-nk-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 1677

ENTRYPOINT ["java", "-jar", "app.jar"]