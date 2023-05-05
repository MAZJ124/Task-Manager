FROM openjdk:8
EXPOSE 8083
ADD target/spring-boot-task-manager.jar spring-boot-task-manager.jar
ENTRYPOINT ["java","-jar","/spring-boot-task-manager.jar"]