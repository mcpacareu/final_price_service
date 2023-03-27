# Description
Welcome to Final Prices Service, a RESTful API built with Java, Maven, and Spring Boot. This API let you to get the final product's price for a specific brand in a date given. Using a H2 in memory database connection that populates with the required data. This guide will walk you through the steps necessary to get up and running with the project. 

# Requirements
Java 11 or higher

Maven 3.9.1 or higher

# Getting Started
1. Clone the project repository using the following command:
	`git clone https://github.com/mcpacareu/final_price_service.git`
2. Navigate to the project directory using the following command:
	`cd final_price_service`
3. Build the project using Maven:
	`mvn clean install`
4. Start the application using the following command:
	`java -jar target/final-price-service-0.0.1-SNAPSHOT.jar`
	This will start the application on port 8080 by default.
5. To test the application, you can send a GET request to the following URL using a tool like cURL or Postman:
	`http://localhost:8080/final-price?date=2020-06-14-15.00.00&product-id=35455&brand-id=1`

# Running Unit Tests
This project includes unit tests that can be run using Maven:
`mvn test`


### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.0.4/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.0.4/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.0.4/reference/htmlsingle/#web)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.0.4/reference/htmlsingle/#data.sql.jpa-and-spring-data)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.0.4/reference/htmlsingle/#using.devtools)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

