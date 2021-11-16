# Getting Started

### How to run
```
mvnw spring-boot:run
```
This will start a server on port 8080<br/>
To consume a sample message from /var/log (say, messages) browse via:
http://localhost:8080/api/varlog?filename=messages&numEvents=2&filter=1
