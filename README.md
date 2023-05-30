# Spring Boot Project

This is a sample Spring Boot project that showcases parent and child transactions.

## Prerequisites

Before you begin, ensure you have met the following requirements:
* You have installed Java 11 or later
* You have installed Maven
* You have a basic understanding of Spring Boot and JPA

## Running the project

To run the project, follow these steps:

1. Clone the repository:


2. Navigate to the project directory:

    ```
    cd spring-boot-project
    ```

3. Use Maven to build the project:

    ```
    mvn clean install
    ```

4. Run the Spring Boot application:

    ```
    mvn spring-boot:run
    ```

## API Endpoints

* Get all parent transactions:

    ```
    GET /parents?page=0&size=2
    ```

* Get all child transactions for a given parent ID:

    ```
    GET /children/{parentId}
    ```

## Tests

To run tests, use the following Maven command:



    mvn test
