# petservice
Steps to Setup
1. Clone the application

https://github.com/arnworld/petservice.git

2. Build and run the app using maven

mvn package
java -jar target/spring-boot-starter-parent-1.4.1.RELEASE.jar
Alternatively, you can run the app without packaging it using -

mvn spring-boot:run
The app will start running at http://localhost:8080.

Explore Rest APIs
The app defines following CRUD APIs.

GET /pets

POST /pets

GET /pets/{petId}

PUT /pets/{petId}

DELETE /pet/{petId}