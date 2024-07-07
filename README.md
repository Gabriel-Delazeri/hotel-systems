
# Hotel Challenge

Sistema de rede hoteleira com funcionalidades de busca, filtragem, comparação e reserva.











## Arquitetura

1.  ### API Gateway
O API Gateway atua como ponto de entrada para os clientes acessarem as funcionalidades da api. Ele roteia as requisições para os microsserviços apropriados e fornece uma interface unificada.
 - Java
 - Spring Boot

2. ### Serviço de Hotéis
O Serviço de Hotéis é dedicado às funcionalidades de busca de hotéis. Decidi utilizar Elasticsearch para capacidades avançadas de busca, possibilitando a recuperação eficiente e rápida de informações sobre hotéis com base em vários critérios.
- Java
- Spring Boot
- Elasticsearch

3. ### Serviço de Reservas
O Serviço de Reservas gerencia a funcionalidade de reserva de quartos de hotel. Decidi usar o PostgreSQL para armazenamento persistente de dados e comunico com microsserviço de notificações para enviar e-mails de confirmação durante o processo de reserva.
- Java
- Spring Boot
- Postgresql (compartilhado com Serviço de Notificações)

4. ### Serviço de Notificações
O Serviço de Notificações é responsável por enviar notificações aos usuários. Ele produz e consume eventos em uma fila gerenciada por RabbitMQ, além disso, persiste entidades de e-mail em banco de dados PostgreSQL.
- Java
- Spring Boot
- RabbitMQ
- Postgresql (compartilhado com Serviço de Reservas)
## Funcionalidades Implementadas

- Pesquisar hotéis com filtros por quartos e capacidade usando Elasticsearch para consultas otimizadas.
- Comparar dois ou mais hotéis, com cobertura de teste para validar o resultado.
- Pesquisar hotéis individualmente por ID.
- Reservar um quarto de hotel para uma data específica e armazenar no banco de dados PostgreSQL com foco na consistência aliada à performance.
- Envio de e-mails utilizando RabbitMQ para gerenciamento de filas, informando o sucesso da reserva.

## Funcionalidades a serem implementadas

- Validação de parâmetros API.
- Logs para cobertura de aplicativos.
- Pesquise hotéis por geolocalização.
- Containerização completa da aplicação.
## Instalação

### Pré-requisitos

- Docker
- Docker compose
- Java 17 ou superior.

### Setup

1. Clone o repositório:
   ```bash
   git clone https://github.com/Gabriel-Delazeri/hotel-system
   cd hotel-system
    ```
    
2. Inicie postgres, elasticsearch e o rabbitmq:
   ```bash
    docker-compose up --build -d
    
     ```
3. Inicie o api gateway (port 8080):
   ```bash
   cd api-gateway
   ./mvnw spring-boot:run  
    ```

4. Inicie o hotel service (port 8081):
   ```bash
   cd hotel-service
   ./mvnw spring-boot:run  
    ```

5. Inicie o reserve service (port 8082):
   ```bash
   cd reserve-service  
    ```

    Vá até env.properties e edite o setup:
    - NOTIFICATION_EMAIL_FROM

    ```bash
    ./mvnw spring-boot:run  
    ```
6. Inicie o email-microservice (port 8083):
   ```bash
   cd email-microservice
   ./mvnw spring-boot:run  
    ```

    Vá até env.properties e edite o setup:
    - MAIL_HOST
    - MAIL_PORT
    - MAIL_USERNAME
    - MAIL_PASSWORD
## Documentação da API

#### Retorna todos os hotéis

```http
  GET /api/hotels
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `rooms` | `number` | Número minímo de quartos |
| `capacity` | `number` | Capacidade mínima |

#### Retorna o hotel pelo ID

```http
  GET /api/{id}
```

#### Compara e retorna o melhor hotel

```http
  POST /api/hotels/compare
```

```json
{
  "hotelIds": [
    "string"
  ],
  "criteria": [
    "PRICE", "RATING", "AMENITIES"
  ],
  "amenities": [
    "string"
  ]
}
```


#### Criar reserva

```http
  POST /api/reserves
```

```json
{
  "hotelId": "string",
  "date": "date",
  "guest": {
      "document": "string",
      "name": "string",
      "email": "string"
   },
   "guest": {
      "amount": "number",
      "type": "CARD|MONEY"
  },
}
```
