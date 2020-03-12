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

    cd src/main/webapp
    npm run serve
    
# Release

Run Maven `package` / `install` it will build the runtime jar

    mvn install

This will also download Node and NPM and all node_modules and build the frontend.

* The frontend build will **replace** all the files in `src/main/resources/META-INF/resources` with different generated names to improve caching.
* Make sure to **commit the changes** in `src/main/resources/META-INF/resources` to Git, it is the production version of the frontend!
* The frontend files have to be generated in `src/main/resources/META-INF/resources` because it is (at least for now) the only place where Quarkus will pick them up.
