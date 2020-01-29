# eureka-zuul-tutorial
Spring Boot Micro-Services with Eureka and Zuul proxy with Feign Client.

---

This project shows a basic implementation of Spring Boot Micro-Services with Eureka and Zuul proxy with Feign Client.

# Project Structure 

* **eureka-server** : Eureka server or service registry
* **gateway-service** : zuul proxy for routing end user requests
* **resource-service** : communicates with the user-service
* **user-service**  : micro-service that engages with the database
* **database** : MySQL

clone the project

navigate to the **eureka-server** folder, run the discovery server application 
    
    mvn spring-boot:run
    
eureka server runs on port 8661 

navigate to the **user-service** folder, run the java client application
  
    mvn spring-boot:run
   
navigate to the **resource-service** folder, run the java client application
  
    mvn spring-boot:run
    
navigate to the **gateway-service** folder, run the java client application
  
    mvn spring-boot:run
    
Open [http://localhost:8661/](http://localhost:8661/) on your local machine to see if the various services have been registered on your Eureka Discovery Server (**eureka-server**).

Now test the endpoints in postman
    
    post         : http://localhost:8662/resource/api/saveUpdate
    
    request body :      {
	                        "id":"",
	                        "name":"Mark",
	                        "age":25
                         }
    
    get  : http://localhost:8662/resource/api/getByName/{name}
