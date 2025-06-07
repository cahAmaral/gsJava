# PreventPlus API

API RESTful para prevenção e mitigação dos impactos de eventos extremos, construída com Spring Boot.

## Descrição

Este projeto tem como objetivo concentrar dados e regras de negócio para ajudar na prevenção de desastres naturais e auxiliar a população e órgãos responsáveis. Ele inclui:

- CRUD completo para entidades como Usuário, Região, Tipo de Desastre, Alerta, entre outras.
- Persistência com Spring Data JPA e banco H2 (em memória) para desenvolvimento.
- Validação de dados com Bean Validation.
- Paginação, ordenação e filtros nas consultas.
- Documentação da API via Swagger.
- Autenticação com JWT (planejada/implementação futura).
- Projeto preparado para deploy em nuvem (Azure, AWS, etc).

## Tecnologias usadas

- Java 17
- Spring Boot 3.x
- Spring Data JPA
- Bean Validation (Jakarta Validation)
- Oracle Database
- Swagger/OpenAPI
- JWT (JSON Web Tokens) - para autenticação
- Maven

## Como rodar localmente

1. Clone o repositório:

   ```bash
   git clone https://github.com/cahAmaral/gsJava.git
   cd gsJava
