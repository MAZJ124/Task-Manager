# Task-Manager
Simple API end points for basic task manager 

## Pre-requisites and dependencies
* Java 8
* Spring Boot 2.6.14
* Maven 3.9.1
* MySql 8.0

## How to start the app
1. Ensure all the dependencies are installed 
2. Clone the repository to a local machine 
3. Since the app uses a local database, the user will need to create their own database using MySql. Simply run the command `create database <name of your database>`
4. Update the `application.properties` file with the following details: 
```
server.port = 8083 // any available port on the local machine will do
spring.datasource.url=jdbc:mysql://localhost:<MySql server port>/<database name>
spring.datasource.username= <MySql username>
spring.datasource.password= <MySql password>
spring.jpa.hibernate.ddl-auto=update
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.show-sql: true
```
5. Run the Spring Boot application 
6. Authenticate for Spring Security when required using the following accounts:

| Username | Password | User role |
|----------|----------|-----------|
| user1    | password | USER      |
| admin1   | password | ADMIN     |

7. The list of APIs can be found here (basically same as the requirements in the given pdf but with a `/task-manager` prefix):
   
| API | Request Type | Function |
|----------|----------|-----------|
| localhost:8083/task-manager/tasks    | GET | Lists all tasks in database      |
| localhost:8083/task-manager/tasks/{id}   | GET | Displays task with given id     |
| localhost:8083/task-manager/tasks    | POST | Creates new task      |
| localhost:8083/task-manager/tasks/{id}   | PUT | Updates task with given id     |
| localhost:8083/task-manager/tasks/{id}   | DELETE | Deletes task with given id     |

8. `8083` in the above APIs should be replaced by the server port defined in `application.properties`
9. For the sake of convenience, both `USER` and `ADMIN` role are authorized to access all APIs, but all access will be denied without a log in 

**PS**
I was unable to install Docker on my local machine, so I was not able to test the correctness of my Dockerfile:(