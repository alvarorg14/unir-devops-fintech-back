FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY target/fintech-api.jar app.jar

COPY wait-for-it.sh wait-for-it.sh
RUN chmod +x wait-for-it.sh

EXPOSE 8080

ENTRYPOINT ["./wait-for-it.sh", "mysql-db:3306", "--", "java", "-jar", "app.jar"]
