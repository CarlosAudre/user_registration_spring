# User CRUD - Backend

API REST para gerenciamento de usuários, desenvolvida com Java e Spring Boot.

## Tecnologias

- Java
- Spring Boot
- Spring Security
- JWT
- JPA / Hibernate
- PostgreSQL
- Maven

## Funcionalidades

- Cadastro de usuários
- Autenticação de usuários
- Consulta de usuários
- Consulta de usuário por ID
- Atualização de usuários
- Exclusão de usuários

## Como executar

Clone o repositório:

~~~bash
git clone https://github.com/CarlosAudre/user_registration_spring/tree/master
~~~

Acesse a pasta do projeto:

~~~bash
cd user_registration_react
~~~

Configure as variáveis de ambiente necessárias:

~~~env
DB_HOST=localhost:5432
DB_USER=seu_usuario
DB_PASSWORD=sua_senha
JWT_SECRET=sua_chave_secreta
~~~

As variáveis são utilizadas pelo `application.properties`:

~~~properties
spring.application.name=user_crud.demo
spring.datasource.url=jdbc:postgresql://${DB_HOST}/user_crud
spring.datasource.username=${DB_USER}
spring.datasource.password=${DB_PASSWORD}
spring.datasource.driver-class-name=org.postgresql.Driver
hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
server.port=8081
server.address=0.0.0.0

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.format-sql=true
api.security.token.secret=${JWT_SECRET:my-secret-key}
~~~

Certifique-se de que o banco de dados `user_crud` esteja criado no PostgreSQL.

Execute o projeto:

~~~bash
./mvnw spring-boot:run
~~~

A API será executada em:

http://localhost:8081

## Endpoints

### Autenticação

~~~http
POST /auth/register
POST /auth/login
~~~

### Usuários

~~~http
GET /users
GET /users/{id}
PUT /users/{id}
DELETE /users/{id}
~~~
