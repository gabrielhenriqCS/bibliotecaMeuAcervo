# Meu Acervo Biblioteca API

Uma API REST sobre uma biblioteca chamada Meu Acervo, onde é possível fazer cadastro dos livros, alunos e colaboradores. Além de registrar empréstimos. 

## Tecnologias

- Java 21
- Spring Boot 3.5
- Maven
- MySQL
- Docker & Docker Compose
- Lombok

## O que foi feito?

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
`{
   "ra": 202401,
   "nome": "Maria Santos",
   "email": "maria@aluno.edu",
   "telefone": 11999887766,
   "emprestimoId": null
}`
- `PUT /api/v1/alunos/{ra}` — atualizar aluno
- `DELETE /api/v1/alunos/{ra}` — deletar aluno

#### Colaboradores
- `GET /api/v1/colaboradores` — listar todos
- `GET /api/v1/colaboradores/{cpf}` — buscar por CPF
- `GET /api/v1/colaboradores/{nome}` — buscar por nome
- `POST /api/v1/colaboradores` — criar colaborador
`{
   "cpf": 12345678,
   "nome": "João Silva",
   "email": "joao@email.com",
   "cargo": "Bibliotecário"
}`
- `PUT /api/v1/colaboradores/{cpf}` — atualizar colaborador
- `DELETE /api/v1/colaboradores/{cpf}` — deletar colaborador

#### Livros
- `GET /api/v1/livros` — listar todos os livros
- `GET /api/v1/livros/{isbn}` — buscar livro por ISBN
- `POST /api/v1/livros` — criar livro
`{
   "isbn": "158-3-16-584391-6",
   "nome": "Harry Potter",
   "autor": "J. K. Rowling",
   "paginas": 250
}`
- `PUT /api/v1/livros/{isbn}` — atualizar livro
- `DELETE /api/v1/livros/{isbn}` — deletar livro

#### Empréstimos
- `GET /api/emprestimos` — listar todos os empréstimos
- `GET /api/emprestimos/{id}` — buscar empréstimo por ID
- `POST /api/emprestimos` — registrar novo empréstimo
`{
    "id": null,
    "dataEmprestimo": "2024-10-03T10:00:00",
    "dataDevolucao": "2024-10-17T10:00:00",
    "livro": {
        "isbn": "978-3-16-148410-0",
        "nome": "Clean Code",
        "autor": "Robert Martin",
        "paginas": 464,
        "creationTimestamp": null,
        "updateTimestamp": null
    },
    "colaborador": {
        "cpf": 12345678,
        "nome": "João Silva",
        "email": "joao@biblioteca.com",
        "cargo": "Bibliotecário",
        "creationTimestamp": null,
        "updateTimestamp": null
    }
}`
- `PUT /api/emprestimos/{id}` — atualizar devolução
- `DELETE /api/emprestimos/{id}` — deletar empréstimo

## Rodando o projeto

### 1. Com Docker Compose

Certifique-se de ter Docker e Docker Compose instalados.  
Inicie o banco de dados MySQL:

```bash
docker-compose up -d
