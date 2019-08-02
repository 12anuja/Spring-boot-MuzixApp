Spring Boot task to create a muzix app and use Poatman for database CRUD operations.

MuzixApplication

http://localhost:8080/api/v1/get....


Tasks to be Done Post Demo
1. Complete all the endpoints for CRUD operations on Muzix
2. Use h2-console to view in-memory data
3. Add an endpoint to search trackByName. Understand @Query and parameter passing to
@Query
4. Generate API documentation using Swagger 2
5. Create custom exceptions TrackNotFoundException, TrackAlreadyExistsException in a
com.stack....exceptions package. Perform appropriate exception handling and propagation
Back.
6. Running Logic on Startup in Spring. Create seed data to pre-fill the database with track
information whenever the application starts. Use both approaches:
Approach 1: ApplicationListener<ContextRefreshedEvent>
Approach 2: CommandLineRunner (Find out how it differs from ApplicationRunner)
7.Global exception using Controller advice
8.Remove all hard coded data from the application code to application.properties
a)by using @Value.
b)by using @PropertySource
c)by using Environment
(https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/core/env/
Environment.html)
9) Add @Lombok
(https://drive.google.com/file/d/1QQpEQZbDD9pmW2qrhYsx5N9XYQ5bJ5dM/view)
10) Music app using mongoDB database to perform all CRUD operations 
11)Music app to access info of Last.fm database and fetch tracks info with 
  http://localhost:8080/api/v1/music 
  along with test cases
