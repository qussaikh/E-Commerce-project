# Spring Boot Security with JWT Implementation
The Secure Movie Service is  web application developed in Java, leveraging the Spring Security framework to ensure a secure and authenticated experience for users. 
The project is designed to manage user authentication, authorization, and movie-related operations through a set of well-defined RESTful API endpoints.

Project implementation of security using Spring Boot 3.0 and JSON Web Tokens (JWT). It includes the following features:

## Features
* User registration and login with JWT authentication
* Password encryption using BCrypt
* Role-based authorization with Spring Security
* Customized access denied handling
* Logout mechanism
* Refresh token

## Technologies
* Spring Boot 3.0
* Spring Security
* JSON Web Tokens (JWT)
* BCrypt
* Mysql
* Maven
 
## Getting Started
To get started with this project, you will need to have the following installed on your local machine:

* JDK 17+
* Maven 3+


To build and run the project, follow these steps:

* Navigate to the project directory: cd spring-boot-qussai-security-jwt
* Add database "spring_security" to Mysql 
  * Add your     
                 username: 
                 password: 
* Run the project: mvn spring-boot:run 

-> The application will be available at http://localhost:8080

## Api controller

### Register Admin
Creates a new Admin and returns the new object.
* URL Params
POST http://localhost:8080/api/v1/auth/adminRegister
* Headers

Content-Type: application/json
* Data Params

_{
"firstname": "Qussai",
"lastname": "Khalil",
"email":  "qussai@mail.com",
"password": "password"
}_

### Register User
Creates a new User and returns the new object.
* URL Params
POST http://localhost:8080/api/v1/auth/userRegister
* Headers
Content-Type: application/json
* Data Params

{
"firstname": "Qussai",
"lastname": "Khalil",
"email":  "qussai@mail.com",
"password": "password"
}

### Change the password
* URL Params
PATCH http://localhost:8080/api/v1/users
* Headers
Content-Type: application/json
Authorization: Bearer {{auth-token}}
* Data Params

{
"currentPassword": "password",
"newPassword": "newPassword",
"confirmationPassword":  "newPassword"
}

### Login again and update the token
* URL Params
POST http://localhost:8080/api/v1/auth/authenticate
* Headers
Content-Type: application/json
* Data Params

{
"email":  "qussai@mail.com",
"password": "newPassword"
}

### Add product
* URL Params
  POST http://localhost:8080/addnewproducts
* Headers
  Content-Type: application/json
* Data Params

{
"productName": "Sample Product 4",
"price": 999.99,
"color": "red",
"dimension": "10x15x5",
"specification": "Sample specifications 3 ",
"manufacturer": "ABC Manufacturing",
"quantity": 99,
"category": "Byxor"
}

### Get all products
* URL Params
  GET http://localhost:8080/allproducts
* Headers
  Content-Type: application/json
* Data Params

### Get products by ID
* URL Params
  GET http://localhost:8080/product/1
* Headers
  Content-Type: application/json
* Data Params

### Update  product
* URL Params
  PUT http://localhost:8080/updateproducts
* Headers
  Content-Type: application/json
* Data Params

{
"productId": 102,
"productName": "Sample Product 2",
"price": 899.99,
"color": "Light red",
"dimension": "10x15x5",
"specification": "Sample specifications 2 ",
"manufacturer": "ABC Manufacturing",
"quantity": 90,
"category": "Byxor"
}

### Delete  product
* URL Params
  DELETE http://localhost:8080/deleteproduct/2
* Headers
  Content-Type: application/json
* Data Params


### Add Product to Cart
* URL Params
  POST http://localhost:8080/Cart/addtocart/{id}/{custId}
* Headers
  Content-Type: application/json
* Data Params

  {
  "cartItem": {
  "productId": 1
  },
  "customerlist": {
  "userId": 2
  }
  }

### Get All cart item Handler
* URL Params
  GET http://localhost:8080/Cart/cart/viewAllCart
* Headers
  Content-Type: application/json
* Data Params


### Clean cart
* URL Params
  DELETE http://localhost:8080/Cart/cart/clear
* Headers
  Content-Type: application/json
* Data Params




