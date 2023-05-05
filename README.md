# Task-Manager
Simple API end points for basic task manager  
Github link: https://github.com/MAZJ124/Task-Manager

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

8. In browser, authentication will be automatically prompted, when testing with postman, go to `authentication`, select `basic auth`, and key in the username and password

9. The list of APIs can be found here (basically same as the requirements in the given pdf but with a `/task-manager` prefix):
   
    | API | Request Type | Function |
    |----------|----------|-----------|
    | localhost:8083/task-manager/tasks    | GET | Lists all tasks in database      |
    | localhost:8083/task-manager/tasks/{id}   | GET | Displays task with given id     |
    | localhost:8083/task-manager/tasks    | POST | Creates new task      |
    | localhost:8083/task-manager/tasks/{id}   | PUT | Updates task with given id     |
    | localhost:8083/task-manager/tasks/{id}   | DELETE | Deletes task with given id     |

8. For the APIs to create new task and update task, the request body will be in the form of a Json payload with the following format:
```
{
    "title": "<title of task>",
    "description": "<description of task>",
    "completed": <true or false>
}
```

10. `8083` in the above APIs should be replaced by the server port defined in `application.properties`
11. For the sake of convenience, I assume both `USER` and `ADMIN` role are authorized to access all APIs, but all access will be denied without a log in
    (realistically speaking, a user using a task manager should be able to perform all CRUD operations to tasks, thus I assume it this way)

**PS**
I was unable to install Docker on my local machine, so I was not able to test the correctness of my Dockerfile:(