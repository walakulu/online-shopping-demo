# online-shopping-demo
This demo app was created to demonstrate the process of migrating an on-prem REST API to the AWS cloud during online webinar.

## 🛠️ Build and Run

### Prerequisites
- Java 17 or later
- Maven 3.6+

### Build the Application
This command will compile the source code and package the application into a JAR file under the target/ directory.
```bash

mvn clean package
```

### Run the Application
Option 1. Using the JAR File 
```bash

java -jar target/online-shopping-0.0.1.jar --server.port=8081
```
Option 2. Using Maven
```bash
mvn spring-boot:run -Dspring-boot.run.arguments="--server.port=8081"
```
### How to Call API ?
Call the REST endpoint using API client (browser or Postman)
```
http://localhost:8080/api/products
```
Response:
```json
{
  "productData": [
    {
      "id": 1,
      "name": "Smartphone X",
      "description": "A high-end smartphone",
      "price": 799.99
    },
    {
      "id": 2,
      "name": "Laptop Y",
      "description": "A powerful gaming laptop",
      "price": 1299.99
    },
    {
      "id": 3,
      "name": "Smartwatch Z",
      "description": "A smartwatch with health tracking",
      "price": 199.99
    }
  ],
  "instanceDetails": "Instance IP: 192.168.0.10, Port: 8080"
}
```