# Hotel System

Hotel network system with functionalities for search, filtering, comparison, and reserve.

## Installation

### Prerequisites

- Docker installed on your machine
- Java 17 or superior.

### Setup

1. Clone the repository:
   ```bash
   git clone https://github.com/Gabriel-Delazeri/hotel-system
   cd hotel-system
    ```
    
2. Start postgresql, elasticsearch and rabbitmq containers:
   ```bash
    docker-compose up --build -d
    
     ```
3. Start the api gateway (port 8080):
   ```bash
   cd api-gateway
   ./mvnw spring-boot:run  
    ```

4. Start the hotel service (port 8081):
   ```bash
   cd hotel-service
   ./mvnw spring-boot:run  
    ```

5. Start the reserve service (port 8082):
   ```bash
   cd reserve-service  
    ```

    Go to env.properties and setup NOTIFICATION_EMAIL_FROM

    ```bash
    ./mvnw spring-boot:run  
    ```
6. Start the email-microservice (port 8083):
   ```bash
   cd email-microservice
   ./mvnw spring-boot:run  
    ```

    Go to env.properties and setup MAIL_HOST,MAIL_PORT,MAIL_USERNAME,MAIL_PASSWORD

    ```bash
   ./mvnw spring-boot:run  
    ```
