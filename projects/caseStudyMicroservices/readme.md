# Spring-boot Microservices implementation.

This project uses 3 microservices and client side discovery using **Eureka-naming-server** 
Uses Mongodb as the persistance database.


# Files
*Example considered: Hotel reservation.*  
- booking-service: Microservice that provide details regarding. Rest endpoints to facilate customer bookings, get aggregate results regarding earnings.  
- hotel-service: Microservice that provide details regarding rooms available. Rest end points for getting rooms, add or disable rooms etc.  
- demo-app-service: Microservice that call the above two microservices. Uses **feign clients** . Driver Application.  **also pushes the transactions messages to confluent cloud**
- Eureka-naming-server: For client side discovery.  
## Docker file and Docker-compose

In POM.xml add the final name to your spring-boot application.
```
<build>
	<finalName>demo-app-service</finalName>
</build
```
1. Package the project. **./mvnw package**
2. docker-file
```
FROM openjdk:11.0-slim
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
```
3. docker build -t sourabhhbar/[image-name] .

Or Build-packs
> ./mvnw spring-boot:build-image   

Check docker images.
### Docker-compose
So after individual images are created. Docker-compose is used to run the individual containers.  
```
version: '3.8'

services:
  database:
    container_name: mongodb
    image: mongo
    command: mongod
    ports:
    - 27018:27017
    restart: always
    volumes:
    - mongodata:/data/db

  eureka-naming-server:
    image: eureka-naming-server:0.0.1-SNAPSHOT
    container_name: eureka-naming-server
    restart: always
    ports:
    - 8761:8761
    depends_on:
      - database

  booking-service:
    image: booking-service:0.0.1-SNAPSHOT
    container_name: booking-service
    restart: always
    environment:
      - eureka.client.serviceUrl.defaultZone=http://eureka-naming-server:8761/eureka
      - spring.data.mongodb.host=database
      - spring.data.mongodb.port=27017
      - spring.data.mongodb.database=casestudy
    ports:
    - 8082:8082
    depends_on:
      - eureka-naming-server
    links:
      - eureka-naming-server
      - database

  hotel-service:
    image: hotel-service:0.0.1-SNAPSHOT
    container_name: hotel-service
    restart: always
    environment:
      - eureka.client.serviceUrl.defaultZone=http://eureka-naming-server:8761/eureka
      - spring.data.mongodb.host=database
      - spring.data.mongodb.port=27017
      - spring.data.mongodb.database=casestudy
    ports:
    - 8081:8081
    depends_on:
      - eureka-naming-server
    links:
      - eureka-naming-server
      - database
  demo-app-service:
    image: demo-app-service:0.0.1-SNAPSHOT
    container_name: demo-app-service
    restart: always
    environment:
      - eureka.client.serviceUrl.defaultZone=http://eureka-naming-server:8761/eureka
      - spring.data.mongodb.host=database
      - spring.data.mongodb.port=27017
      - spring.data.mongodb.database=casestudy
    ports:
    - 8083:8083
    depends_on:
      - eureka-naming-server
    links:
      - eureka-naming-server
      - database

networks:
  default:
    external:
      name: micro-net
volumes:
  mongodata:
    driver: local
    

```
(a yaml file is also in the eureka-naming-service directory)


## Todo:
Sonarqube, jenkins
