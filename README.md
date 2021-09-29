

<h3 align="center">Credit Application</h3>

  <p align="center">
    Credit Application project with Spring Boot
    <br />

</p>
<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
        <li><a href="#technologies">Technologies</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <ul></ul>
        <li><a href="#installation">Installation</a></li>
</ul>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

# Ödev Son Teslim Tarihi : 29 Eylül - Saat: 23:00



![odevpart1](https://user-images.githubusercontent.com/45206582/133460137-dbd5583e-1ac9-426f-a6f0-abf5983f6fd6.PNG)


![odevpart2](https://user-images.githubusercontent.com/45206582/133460164-f0b61470-f3e9-49cb-8b0e-8ae9afb45e2e.PNG)


![odevpart3](https://user-images.githubusercontent.com/45206582/133460177-2e2e561e-e1ac-4c42-96a7-5bce51eb8228.PNG)
* According to project rules above, within the Controller/Service/Repository logic a project created. CRUD operations such as save, update, delete added the project. According to last digit of identity number, customer get credit score and this score is used for the calculate its credit result and limit. If customer request a credit, his/her result send to his phone number. All transactions that user do, save to database. CRUD operations implemented with Swagger UI. H2 database is used for database connection.


### Technologies
- Java 8
- Spring Boot
- Spring Web
- Lombok
- Maven
- JPA / Hibernate
- H2 Database
- MapStruct
- Swagger UI



### Built With

You should have JDK 1.8 to  built the project.
* [JDK 1.8](https://www.oracle.com/java/technologies/downloads/#java8)


<!-- GETTING STARTED -->
## Getting Started



### Installation

##### How to run the project:

-----------------------
Firstly, you can clone repo.

``` 
git clone https://github.com/113-GittiGidiyor-Java-Spring-Bootcamp/gittigidiyor-graduation-project-Nevzatcs.git 
```

Then, change your directory to root.

``` 
cd gittigidiyor-graduation-project-Nevzatcs/CreditApplication 
```

On a separate terminal and since this is a maven project you just need to go to the root of the project and perform the command:
```
mvn clean install
```
or if you don't have installed maven on your OS

```
mvnw clan install
```


This will run the unit tests of the project and create the jar file.

After having the jar file you can simply run:

```
java -jar target/wallet-service.jar
```

Since this is a Spring Boot project, you can also run the project with below command;
```
mvn spring-boot:run
```

or if you don't have installed maven on your OS
```
mvnw spring-boot:run
```

The project will run on port 8080 (configured as default).



<!-- USAGE EXAMPLES -->
## Usage
After run the project:
1. You should  open this URL : http://localhost:8080/swagger-ui.html#/ to see and make the operations that can be done.
2. You can get informations about operations that you've done in Swagger by reaching H2 database :  http://localhost:8080/h2-console by clicking URL you can go to H2 console.(There is no password for your access, you can change password in application.properties file.)

### Swagger UI
You can use Swagger, as I show in screenshots.

* Step 1

![swaq01](https://user-images.githubusercontent.com/80898514/135250405-3a5fa845-5190-4e2c-aa7d-250e24c0e038.jpg)


* Step 2

![swaq02](https://user-images.githubusercontent.com/80898514/135250415-4415467d-1055-432e-b41c-fab1ee331b2f.jpg)


* Step 3

![swaq03](https://user-images.githubusercontent.com/80898514/135250430-f6d57022-d7ae-4219-acf4-8f9b373b9d2f.jpg)


### H2 Database
* After opening the URL, you will get this page. 

![h201](https://user-images.githubusercontent.com/80898514/135250459-2322c95a-e6b0-4b8b-90c8-bb533b063737.jpg)


* After clicking connect, you can see the tables and you can monitor the table and its informations according to your SQL query.

![h202](https://user-images.githubusercontent.com/80898514/135250469-94e56a55-0cd4-4b00-94be-30bf183c84f7.jpg)


* Here is the examples of informations from database.

![h204](https://user-images.githubusercontent.com/80898514/135250659-66a330f3-5f7f-4e8f-a241-c826f42fbd11.jpg)


![h203](https://user-images.githubusercontent.com/80898514/135250664-76a6feef-a940-4386-a75d-7151dfe4ccfe.jpg)







<!-- CONTRIBUTING -->
## Contributing

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request



<!-- LICENSE -->
## License

Distributed under the MIT License. See [LICENSE](https://github.com/113-GittiGidiyor-Java-Spring-Bootcamp/gittigidiyor-graduation-project-Nevzatcs/blob/main/LICENSE) for more information.



<!-- CONTACT -->
## Contact

Nevzat Can Samur - [@linkedin](https://www.linkedin.com/in/nevzatcansamur/) 
