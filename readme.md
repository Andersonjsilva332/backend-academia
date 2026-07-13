# Backend Academia

API REST desenvolvida em Java com Spring Boot para gerenciamento de alunos de uma academia.

Nesta primeira versão, o projeto não utiliza banco de dados. Todos os dados são armazenados em memória durante a execução da aplicação.

---

## Objetivo do Projeto

O sistema tem como objetivo permitir o gerenciamento básico de alunos de uma academia, contemplando as seguintes operações:

- Cadastrar aluno
- Consultar aluno por ID
- Listar todos os alunos
- Atualizar aluno
- Deletar aluno

---

## Tecnologias Utilizadas

- Java 21
- Spring Boot
- Spring Web MVC
- Maven
- Swagger / OpenAPI
- Armazenamento em memória com `ConcurrentHashMap`

---

## Estrutura Principal do Projeto

```text
src/main/java/br/com/e2etreinamento/backend_academia
│
├── controller
│   └── AlunoController.java
│
├── dto
│   ├── AlunoRequest.java
│   └── AlunoResponse.java
│
├── exception
│   ├── BusinessException.java
│   └── GlobalExceptionHandler.java
│
├── model
│   └── Aluno.java
│
├── repository
│   └── AlunoRepository.java
│
├── service
│   └── AlunoService.java
│
└── BackendAcademiaApplication.java

Funcionalidades
Cadastrar Aluno

Permite cadastrar um novo aluno na aplicação.

Campos obrigatórios:

Nome
Email
Idade
Whatsapp

Regra de negócio:

Não é permitido cadastrar dois alunos com o mesmo email.
Consultar Aluno

Permite consultar um aluno cadastrado pelo seu ID.

Caso o aluno não exista, a API retorna uma mensagem de erro informando que o aluno não foi encontrado.

Listar Alunos

Permite listar todos os alunos cadastrados em memória.

Atualizar Aluno

Permite atualizar os dados de um aluno existente.

Campos atualizáveis:

Nome
Email
Idade
Whatsapp

Regra de negócio:

Não é permitido atualizar um aluno usando um email já cadastrado para outro aluno.
Deletar Aluno

Permite remover um aluno cadastrado pelo ID.

Caso o aluno não exista, a API retorna uma mensagem de erro informando que o aluno não foi encontrado.

Armazenamento em Memória

Nesta versão, os alunos são armazenados em memória utilizando:

ConcurrentHashMap<Long, Aluno>

O ID dos alunos é gerado automaticamente utilizando:

AtomicLong

Importante:

Como os dados estão em memória, todos os alunos cadastrados serão perdidos quando a aplicação for finalizada ou reiniciada.

Endpoints da API
Cadastrar aluno
POST /alunos

Exemplo de request:

{
  "nome": "João da Silva",
  "email": "joao@email.com",
  "idade": 25,
  "whatsapp": "81999999999"
}

Exemplo de response:

{
  "id": 1,
  "nome": "João da Silva",
  "email": "joao@email.com",
  "idade": 25,
  "whatsapp": "81999999999"
}
Listar todos os alunos
GET /alunos

Exemplo de response:

[
  {
    "id": 1,
    "nome": "João da Silva",
    "email": "joao@email.com",
    "idade": 25,
    "whatsapp": "81999999999"
  }
]
Consultar aluno por ID
GET /alunos/{id}

Exemplo:

GET /alunos/1
Atualizar aluno
PUT /alunos/{id}

Exemplo:

PUT /alunos/1

Exemplo de request:

{
  "nome": "João Atualizado",
  "email": "joao.atualizado@email.com",
  "idade": 26,
  "whatsapp": "81988888888"
}
Deletar aluno
DELETE /alunos/{id}

Exemplo:

DELETE /alunos/1

Resposta esperada:
204 No Content

Documentação Swagger

Após iniciar a aplicação, a documentação da API pode ser acessada pelo navegador:

http://localhost:8080/swagger-ui.html

ou:

http://localhost:8080/swagger-ui/index.html

A especificação OpenAPI em formato JSON pode ser acessada em:

http://localhost:8080/v3/api-docs
Como Executar o Projeto
Pré-requisitos

Antes de executar o projeto, é necessário ter instalado:

Java 21
Maven
Eclipse, IntelliJ ou VS Code
Executar pelo terminal

Na raiz do projeto, onde está o arquivo pom.xml, execute:

mvn clean install

Depois execute:

mvn spring-boot:run
Executar pelo Eclipse
Abra o projeto no Eclipse.
Localize a classe:
BackendAcademiaApplication.java
Clique com o botão direito na classe.
Selecione:
Run As > Java Application
Exemplo de Teste Manual
Cadastro de aluno

URL:

http://localhost:8080/alunos

Método:

POST

Body:

{
  "nome": "Maria Souza",
  "email": "maria@email.com",
  "idade": 30,
  "whatsapp": "81977777777"
}

Resultado esperado:

Status 201 Created
Regras de Negócio
O aluno deve possuir nome.
O aluno deve possuir email.
O aluno deve possuir idade.
O aluno deve possuir whatsapp.
O email não pode estar duplicado.
O aluno precisa existir para ser consultado, atualizado ou deletado.
Observação Técnica

Atualmente, o projeto utiliza armazenamento em memória. Em versões futuras, pode ser implementada persistência com banco de dados, utilizando:

Spring Data JPA
Hibernate
PostgreSQL, MySQL ou H2
Autor

Projeto desenvolvido para estudo e prática de backend com Java e Spring Boot.