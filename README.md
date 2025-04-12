
# E-Commerce Microservices API

This project is developed using Spring Boot and is an example of an API developed with a microservices architecture for e-commerce platforms. The project consists of the following services:

- **InventoryService**: Manages product inventory.
- **OrderService**: Manages orders.
- **NotificationService**: Sends notifications to users.
- **ProductService**: Manages products.
- **Discovery**: Provides Eureka service discovery.
- **API Gateway**: Provides a central access point to all services.

## Spring Eureka Overview

![Spring Eureka](Screenshot_Eureka.png)

## Service Descriptions

### InventoryService

Used to manage product inventory.

#### Features

- Checks stock availability.

#### Example API Call

```http
GET /api/inventory
```

### OrderService
Manages order processing.

#### Features

- Creates orders.

#### Example API Call
```http request
POST /api/order
```

### ProductService
Manages product information.

#### Features

- Adds products.
- Displays product details.

```http request
GET /api/product
```

### Discovery
Provides service discovery using Eureka. It allows all microservices to find and communicate with each other.

#### Features

- Service registration and discovery.
- Dynamic load balancing.

### API Gateway
Provides a central access point to all services. It routes requests to the appropriate microservices.

#### Features

- Centralized authentication.
- Load balancing.
- API routing.

### Installation
#### Requirements

- JDK 17
- Docker

### Installation Steps
1. Clone the project:
``` http request
git clone https://github.com/your-username/ecommerce-microservices-api.git
cd ecommerce-microservices-api
```
2. Start the services with Docker Compose:

```http request
docker-compose -f docker-compose.yml up -d
```
3. Access the Eureka Dashboard:
```http request
http://localhost:8761
```

4. Access the services through the API Gateway:
```http request
http://localhost:8080
```

### Contributing
#### To contribute to this project, please open a pull request or create an issue.
