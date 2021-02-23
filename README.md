# Pet Visits Service

This repository contains a very simple application 
that provides a REST interface.
It lets pet owners submit and list visits and vets accept and reject visits.
All visitEntity information are stored in a (in-memory) database.

We use this project as a starting point 
to create and refactor to a Clean-/Onion-style Architecture.

## How to build and run the pet visits service 

### Required technologies
To run the application, the following should be installed:
* [git](https://git-scm.com/downloads)
* JDK (e.g., [AdoptOpenJDK](https://adoptopenjdk.net/))
* Optionally, [Apache Maven](https://maven.apache.org/install.html)

### Run from source
In the command line, run the following:

```shell
git clone https://github.com/fortiss-cce/pet-visits-service.git
cd pet-visits-service
./mvnw spring-boot:run
```

## API documentation
To see and try out the API, go to 
[http://localhost:8080/swagger-ui/](http://localhost:8080/swagger-ui/)

## Database documentation
To have a look into the database, go to 
[http://localhost:8080/h2-console/](http://localhost:8080/h2-console/)

Login using the following config:
  
| Field       | Value                     |
|-------------|---------------------------|
| `JDBC URL`  | `jdbc:h2:mem:petvisitsdb` |
| `User name` | `sa`                      |
| `Password`  | can be left empty         |

The config and initial data can be edited in 
`application.yml` and `data.sql` 
inside `src/main/resources/`.


## Task - create a clean architecture

### Background story
Currently, our application supports
one SQL repository and one REST controller
to provide both actors (pet owners, vets) the respective two use cases.

Soon, we plan to maybe add or switch
to a MongoDB repository for storage and a GraphQL controller
to provide the use cases.

### Description and aim
The task is
to add and change the classes and interfaces and
to shape the dependencies
in order to ease future developers these planned technology additions.

### Procedure
1. Create a fork of this repository
2. Refactor/extend the code to achieve a clean architecture
  * keep the SOLID principles in mind
  * keep the clean architecture principles in mind
    * high cohesion inside a package
    * low coupling between packages
  * Javadoc and extensive error handling can be disregarded for the purpose of this exercise
  
3. Create a pull request to submit you proposals