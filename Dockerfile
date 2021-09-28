FROM openjdk:8
WORKDIR /app
ADD /target/CreditApplication-0.0.1-SNAPSHOT.jar CreditApplication-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "CreditApplication-0.0.1-SNAPSHOT.jar"]
