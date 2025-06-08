# Prevent+ – Aplicativo de Prevenção e Educação para Desastres Naturais

Prevent+ é uma solução desenvolvida em Java com Spring Boot para prevenção, educação e alerta sobre desastres naturais como enchentes, deslizamentos e incêndios.

Este repositório contém a API RESTful conectada a um banco de dados Oracle, com endpoints para gerenciamento de usuários, alertas, dicas, checklists, regiões e muito mais.

---

## 🚀 Tecnologias Utilizadas

- Java 21 
- Spring Boot  
- Spring Data JPA  
- Oracle Database  
- Maven  
- Lombok  
- Swagger/OpenAPI  
- Postman  

---

## 🗂 Estrutura do Projeto

src/
└── main/
├── java/
│ └── com.prevent.preventplus/
│ ├── model/ # Entidades JPA
│ ├── dto/ # Data Transfer Objects
│ ├── repository/ # Interfaces de acesso a dados
│ ├── service/ # Regras de negócio
│ └── controller/ # Endpoints REST
└── resources/
├── application.properties
└── data.sql (opcional para carga inicial)

---

## 📌 Funcionalidades

- Cadastro e consulta de usuários  
- Registro de alertas de desastres  
- Exibição de dicas por tipo de desastre  
- Checklists de preparação personalizáveis  
- Kits de emergência por usuário  
- Gerenciamento de locais seguros  
- Notificações manuais e automáticas  
- Histórico de riscos por região  
- Integração futura com modelo de Machine Learning  

---

## ⚙️ Como Rodar o Projeto

1. Clone o repositório:
```bash
git clone https://github.com/cahAmaral/gsJava.git
cd gsJava
2. Configure o banco de dados Oracle em application.properties:
spring.datasource.url=jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL
spring.datasource.username=rm558012
spring.datasource.password= 200106
spring.datasource.driver-class-name=oracle.jdbc.OracleDriver

3. Compile e execute o projeto:
./gradlew bootRun

4. Acesse a documentação da API:
http://localhost:8081/swagger-ui/index.html
