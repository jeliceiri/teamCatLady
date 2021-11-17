# The Team Enterprise Java Project

This repository is the team project for the final Java course at Madison College in the Fall 2021. The team members are: Jenn Mann, Jill Eliceiri, and Kristin Racchini. The project simulates a real world application where all team members contribute to a web service built using Java.
## Problem Statement
An important piece of our country's history are the individuals who have served as the US President. Many types of audiences both in general public and in education settings routinely look for information about the presidents. Examples include a student looking up biography information on a president for history class term paper or someone checking a presidential fact as they play a trivia game.  Currently, information regarding the US Presidents can be found on various personal and official government websites each with varying degrees of information . This service provides a unified way to access complete information about US Presidents in a single web portal.  

The service provides the following:

* Get a president given a president id
* Get all presidents 
* Get a list of presidents given a party
* Get a list of presidents who are living
* Get a list of presidents who are deceased
* Add a president
* Update a president, given a president id 

The service supports the following formats: 

* Plain text
* JSON
* XML

## The service uses the following technologies:
* Language: Java  
* Integrated Development Environment (IDE): IntelliJ IDEA  
* Dependency Management: Maven  
* RESTful Web Services Framework: JAX-RS API with Jersey    
* Swagger for API Documentation    
* Database: MYSQL v 8.0.26  
* Unit Testing: JUnit 5 with 80%+ code coverage  
* ORM Framework: Hibernate    
* Hosting: Amazon Weg Services (AWS)  

## Resources
**Presidents**

| Property  | Description   |  Type/Format |
|---|---|---|
| id   | unique identifier that represents the number of the president | number  | 
| name  | President name, for example: "George Washington"  | string  |
| birthYear  | President birth year, for example: "1942"  | int  |
| deathYear  | President death year, for example: "1919"  | int  |
| tookOffice  | Date president took office, for example: "1909-03-04"  | string  |
| leftOffice  | Date president left office, for example: "1913-03-04"  | string  |
| party  | President party, for example: "Democratic", "Federalist", "Republican", "Whig", or "No Party"  | string  |

## Service Calls

* GET /presidents/
* GET /presidents/:responseType
* GET /presidents/id/:id/:responseType
* GET /presidents/party/:party/:responseType
* GET /presidents/living/:aliveOrDeadBoolean/:responseType
* PUT /presidents/id/:id
* POST /presidents/

## Team Docs, Time Log, and Design Docs
* [Team Resume](docs/TeamResume.md)
* [Team Charter](docs/TeamCharter.md)
* [Project Plan](docs/ProjectPlan.md)
* [Time Log](docs/TimeLog.md)
* [Presentation Slides](docs/PresidentsAPI-Presentation.pdf)