# Bonnie
A training application for newcomers.

## Architecture
This application implements the hexagonal architecture which is a modular application design pattern.

### Modules (a.k.a Plugins)    

### businessrules
The "center" of the hexagonal architecture, contains all the business logic, defines interfaces for data storage, and messaging. Every other module depend on this core module (it is not a plugin). 

### rest
RESTFUL API for the frontend, calls the core module. 

### h2-storage
A data storage plugin that uses Spring JDBC with embedded H2 database packaged into it. 

### messaging
Integration module with Kafka. The system gets and send asynchronous events through it.

### starter
It packs all the modules into a single spring boot application. It is a build with a specific set of plugins. The idea is that, we can have multiple starter modules, with other plugin configurations (with another database plugin for instance). You have to start this module, if you want to run the application

## Stack

### Spring
This project uses Spring Boot framework.
We use it for dependency injection and configuration management, but also because it has battle-tested integration packages with all of the major cloud native components.

### H2 database
For the time of writing the project has a H2 embedded database to store the data in. It has a nice off-the-shelf gui to manage the database.
To connect to it the project uses Spring JDBC connector.

### Kafka
The project uses Kafka as the message broker. You have to install, and configure it separately before starting the application. For more information how to do that read the corresponding document in the doc folder.

### Angular frontend
This application will have an angular frontend to manage the orderings.

# Building & Running the application
First, start the zookeeper, and kafka services that is described in the ```doc/runKafka.txt``` file.

Then, to build the application, issue the following command in the parent project folder
```bash
mvn clean install
```

After this, to run the project, issue the following command from the folder of starter module:
```bash
mvn spring-boot:run
```