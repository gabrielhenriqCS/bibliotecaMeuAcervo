# Meu Acervo Biblioteca API

Uma API RESTful para gerenciamento de uma biblioteca de livros, incluindo alunos, colaboradores, empréstimos e livros.

## Tecnologias

- Java 21
- Spring Boot 3.5
- Maven
- MySQL
- Docker & Docker Compose
- Lombok

## Funcionalidades

- CRUD de **Alunos**
- CRUD de **Colaboradores**
- CRUD de **Livros**
- CRUD de **Empréstimos**
- Relacionamento entre alunos, colaboradores e livros

## Estrutura da API

### Endpoints principais:

#### Alunos
- `GET /api/v1/alunos` — listar todos os alunos
- `GET /api/v1/alunos/{ra}` — obter aluno por RA
- `POST /api/v1/alunos` — criar novo aluno
- `PUT /api/v1/alunos/{ra}` — atualizar aluno
- `DELETE /api/v1/alunos/{ra}` — deletar aluno

#### Colaboradores
- `GET /api/v1/colaboradores` — listar todos
- `GET /api/v1/colaboradores/{cpf}` — buscar por CPF
- `GET /api/v1/colaboradores/{nome}` — buscar por nome
- `POST /api/v1/colaboradores` — criar colaborador
- `PUT /api/v1/colaboradores/{cpf}` — atualizar colaborador
- `DELETE /api/v1/colaboradores/{cpf}` — deletar colaborador

#### Livros
- `GET /api/v1/livros` — listar todos os livros
- `GET /api/v1/livros/{isbn}` — buscar livro por ISBN
- `POST /api/v1/livros` — criar livro
- `PUT /api/v1/livros/{isbn}` — atualizar livro
- `DELETE /api/v1/livros/{isbn}` — deletar livro

#### Empréstimos
- `GET /api/emprestimos` — listar todos os empréstimos
- `GET /api/emprestimos/{id}` — buscar empréstimo por ID
- `POST /api/emprestimos` — registrar novo empréstimo
- `PUT /api/emprestimos/{id}` — atualizar devolução
- `DELETE /api/emprestimos/{id}` — deletar empréstimo

## Rodando o projeto

### 1. Com Docker Compose

Certifique-se de ter Docker e Docker Compose instalados.  
Inicie o banco de dados MySQL:

```bash
docker-compose up -d
