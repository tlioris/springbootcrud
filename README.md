# springbootcrud

I don't know how liquibase should be configured, in order to run the tests I have added. I tried to use h2 database to make tests, but I did not try to change liquibase configuration.

I understand that by making separate projects (domain - repository - application) is a better design, because the whole project is decoupled. 

I have installed openAPI 3 (and swagger2) to cover the documentation requirement. Documentation can be found at: http://localhost:8080/v3/api-docs/, and http://localhost:8080/swagger-ui/index.html .

I don't know vue, but as far as I have seen I managed to configure it.

Generally, in order to deploy a multi-module project, according to the literature, one must create a jar file on the parent project. In the given project, however, I could not make a jar file, maybe due to the old JAVA version. 

To execute a jar file from prompt: java -jar final_file.jar
