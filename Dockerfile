FROM openjdk:8-jdk-alpine
WORKDIR /demo
COPY ./JarFolder/ConfigMapDemo.jar ./demo/configdemo.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","./demo/configdemo.jar"]
