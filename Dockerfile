FROM openjdk:8-jdk-alpine
COPY . /target/magneto-0.0.1-SNAPSHOT.jar ./
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","./magneto-0.0.1-SNAPSHOT.jar"]