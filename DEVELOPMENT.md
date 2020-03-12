# Development

To build this project you need:

* Java Development Kit (JDK) 1.8+
* Maven
* NPM / node (will be downloaded by maven plugin)

## Backend

Run Quarkus

    mvn quarkus:dev


## Frontend

Run NPM

    npm serve
    
# Release

Run Maven `package` / `install` it will build the runtime jar

    mvn install

This will also download Node and NPM and all node_modules and build the frontend.

