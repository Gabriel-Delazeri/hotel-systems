
# Hotel Challenge

Sistema de rede hoteleira com funcionalidades de busca, filtragem, comparação e reserva.











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

