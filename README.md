# Stock Management System (Spring Boot)

Projeto simples de gerenciamento de estoque desenvolvido com Spring Boot.
Criado com foco em aprendizado, organização de código e aplicações locais.

## 🚀 Tecnologias
- Java 17+
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Thymeleaf
- Maven

## 📌 Funcionalidades
- Cadastro de produtos
- Listagem de estoque
- Edição de produtos
- Exclusão de produtos
- Proteção por senha simples (uso local)

## ⚙ Arquitetura
O projeto segue uma arquitetura em camadas:
- Controller
- Service
- Repository
- Entity

## 🖥️ Frontend
Interface simples utilizando Thymeleaf, pensada para usuários leigos
(como pequenos comerciantes ou uso local).

## ⚠️ Observações Importantes
- A autenticação utiliza uma senha simples, sem criptografia.
- Não há controle de usuários.
- Projeto voltado para fins educacionais e aplicações locais.

## ⚡ Melhorias Futuras
- Implementação de usuários
- Criptografia de senha
- Tratamento global de exceções
- Validações com Bean Validation
- Spring Security

## ▶️ Como executar
1. Antes de executar o projeto, é necessário criar um file:

`src/main/resources/application-local.properties`

Com o seguinte conteúdo:

`spring.datasource.url=jdbc:postgresql://localhost:5432/crud_stock`  
`spring.datasource.username=SEU_USUARIO`  
`spring.datasource.password=SUA_SENHA`  

2. O arquivo `application-example.properties` serve como referência.
3. Execute a aplicação:
```bash
mvn spring-boot:run
