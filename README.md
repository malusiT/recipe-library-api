# recipe-api

A RESTful Recipe Library API built with Spring Boot, Spring Data JPA, and Spring HATEOAS.
This project allows clients to create, retrieve, update, and delete recipes using standard HTTP methods.

The project is based on the official Spring Building REST services tutorial, but the domain, structure, and implementation were customized and extended to model a real-world recipe API.

The application uses an embedded database via JPA for persistence (configured automatically by Spring Boot)

## API Base URL
```
http://localhost:8080/recipes
```

## API Docs
This application uses OpenAPI/Swagger to produce documentation.
```
http://localhost:8080/recipes/swagger-ui/index.html
```

## Features
- RESTful CRUD API for managing recipes
- Uses Spring Boot for rapid application setup
- Spring Data JPA for database persistence
- Spring HATEOAS for hypermedia-driven responses
- Preloaded sample recipe data at application startup 
- Centralized exception handling with proper HTTP status codes
- Deployed and publicly accessible via Railway

## Tech Stack
-  Java
- Maven
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- Railway (deployment)

## Data Model
### Recipe Entity

A recipe consists of:
- id – Unique identifier
- name – Recipe name
- description – Short description
- recipeList – List of ingredients
- instructions – Step-by-step cooking instructions

## API Endpoints
#### Get all recipes

```
Get /recipes
```
#### Response
- returns a collection of recipes
- Includes HATEOAS links

### Get a single recipe by ID
```
GET /recipes/{id}
```
*Example*
```
GET /recipes/1
```
#### Create a new recipe
```
POST /recipes
```
**Request Body (JSON example)**
```
{
  "name": "Pancakes",
  "description": "Simple homemade pancakes",
  "recipeList": [
    "1 cup flour",
    "1 egg",
    "1 cup milk"
  ],
  "instructions": [
    "Mix ingredients",
    "Heat pan",
    "Cook until golden"
  ]
}
```
#### Update an existing recipe
```
PUT /recipes/{id}
```

#### Delete a recipe
```
DELETE /recipes/{id}
```

### Error Handling
- If recipe is not found, the API returns:
  - HTTP 404 - Not Found
  - A meaningful error message via a global exception handler
 
## Running Locally
1. Clone the repository
2. Ensure Java and Maven are installed
  *To check*
   ```
   java -version
   
   mvn -version
   ```
3. Run the application
```
  mvn spring-boot:run
```
5. Access the API at:
```
  http://localhost:8080/recipes
```

## Deployment
The applications is deployed using Railway
- Live API:
```
  https://recipe-library-api-production.up.railway.app/
```


