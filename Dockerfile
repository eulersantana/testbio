FROM openjdk:8-jre-slim
COPY ./target/Bionexo-Teste-0.0.1-SNAPSHOT.jar /usr/src/bionexoteste/
WORKDIR /usr/src/bionexoteste/
EXPOSE 8080
CMD ["java", "-jar", "Bionexo-Teste-0.0.1-SNAPSHOT.jar"]