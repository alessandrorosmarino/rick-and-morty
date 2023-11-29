# Rick & Morty
Application to consume Rick & Morty API

## Table of Contents
* [Introduction](#introduction)
* [Getting Started](#getting-started)
* [Running Tests](#running-tests)
* [Technologies](#technologies)
* [Acknowledgments](#acknowledgments)
  * [Technology Choices](#technology-choices)
    * [Rick & Morty Java Client](#rick-&-morty-java-client)
    * [Layering](#layering)

## Introduction
This project is a simple application that has the goal
of providing APIs that consume the Rick & Morty API. 
It will be developed using Spring Boot in conjunction
with the Rick & Morty Java Client.

## Getting Started
1. Clone the repository

## Running Tests

## Technologies
* Java 17
* Spring Boot
* Maven
* JUnit
* Mockito
* Rick & Morty Java Client

## Acknowledgments
Not everything could be done in the time given.
The following is a list of things that could be done
to improve the application:
* Add more tests
* Document the Application further
* Add some Error Handling
* Check performance of the application and improve it

### Technology choices

#### Rick & Morty Java Client
The Rick & Morty Java Client is a client provided by the
team of the website https://rickandmortyapi.com.
It is a simple client that provides a simple way to consume
the API. It has been chosen because it is a simple and
lightweight client that provides all the functionalities
needed for this project.

#### Layering
The application is layered in 3 layers:
* Controller
* RMConsumerService
* RM***OtherName***Service

The Controller layer is the layer that exposes the APIs. 
It is the layer that receives the requests and returns the 
response with the structure of the RMCharacterData structure.

The RMConsumerService layer is the layer that builds the
RMCharacterData object by fetching the data from the various
RM***OtherName***Services.

The RM***OtherName***Services are the services that fetch the
data from the Rick & Morty API. They are separated by the
different types of data that can be fetched from the API.

