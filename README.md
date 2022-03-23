# springbootcrud

I don't know how liquibase should be configured, in order to run the tests I have added. I tried to use h2 database to make tests, but I did not try to change liquibase configuration.

I understand that by making separate projects (domain - repository - application) is a better design, because the whole project is decoupled. 

I have installed openAPI 3 (and swagger2) to cover the documentation requirement. Documentation can be found at: http://localhost:8080/v3/api-docs/, and http://localhost:8080/swagger-ui/index.html .

I don't know vue, but as far as I have seen I managed to configure it.

To deploy the backend server:

1. insert /<packaging/>jar/</packaging/> at every pom.xml of every module 
2. execute a maven clean package run for springbootcrud-domain project. This will produce a new jar file, located at spring-boot-crud project in the end folder of folder sequence springbootcrud-domain/target ...
3. this new jar file should be included as a dependency in the springbootcrud-service project. Since you are using some UI (Eclipse, Netbeans, IntelliJ) this should be a trivial task. 
4. execute a maven clean package run for springbootcrud-service project. This should create a new jar file, located at spring-boot-crud project (as of step 2).
5. The new jar file holds all the dependencies of the final webapp. Therefore it should be added to the webapp dependencies.
6. finally make the last jar!

To execute the backend server: java -jar final_file.jar
