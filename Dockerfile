FROM openjdk:8
WORKDIR /app
COPY . .
RUN chmod +x mvnw && ./mvnw clean install -U
ENTRYPOINT ["./mvnw", "spring-boot:run"]