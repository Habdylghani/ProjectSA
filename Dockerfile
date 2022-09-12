FROM openjdk:17-oracle
COPY target/mini-project.jar mini-project.jar
ENTRYPOINT ["java","-jar","/mini-project.jar"]