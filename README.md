# 📚 Meu Acervo - API de Gestão Bibliotecária

[![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk)](https://www.oracle.com/java/)
[![Spring](https://img.shields.io/badge/Spring_Boot-3.5-6DB33F?style=for-the-badge&logo=spring)](https://spring.io/)
[![Docker](https://img.shields.io/badge/Docker-Enabled-2496ED?style=for-the-badge&logo=docker)](https://www.docker.com/)
[![MySQL](https://img.shields.io/badge/MySQL-Persistência-4479A1?style=for-the-badge&logo=mysql)](https://www.mysql.com/)

API REST robusta para o gerenciamento completo de bibliotecas, permitindo o controle de acervo, usuários (alunos/colaboradores) e o fluxo crítico de empréstimos.

## 🚀 Diferenciais de Engenharia

Diferente de CRUDs simples, este projeto foi construído com foco em **Clean Code** e **Resiliência**:

* **Global Exception Handling:** Tratamento centralizado de erros com `@RestControllerAdvice`, garantindo que a API nunca retorne um erro genérico (500), mas sim mensagens claras com status HTTP apropriados.
* **Service Layer Pattern:** Lógica de negócio 100% isolada dos Controllers, facilitando a manutenção e futuros testes unitários.
* **Data Integrity:** Implementação de DTOs (Data Transfer Objects) para proteger a integridade das entidades do banco de dados.
* **Contêinerização Profissional:** Ambiente de desenvolvimento isolado com Docker Compose, garantindo que o banco de dados MySQL suba com as configurações corretas automaticamente.

## 🛠️ Tecnologias

* **Linguagem:** Java 21
* **Framework:** Spring Boot 3.5 (Web, Data JPA, Validation)
* **Gerenciador de Dependências:** Maven
* **Banco de Dados:** MySQL
* **Infra:** Docker & Docker Compose
* **Utilitários:** Lombok & MapStruct (DTO Mapping)

---

## 📡 Estrutura da API (Endpoints)

### 👥 Alunos & Colaboradores
| Método | Endpoint | Descrição |
| :--- | :--- | :--- |
| `GET` | `/api/v1/alunos` | Lista todos os alunos cadastrados |
| `POST` | `/api/v1/alunos` | Cria um novo aluno (RA único) |
| `GET` | `/api/v1/colaboradores/{cpf}` | Busca colaborador por CPF |
| `DELETE` | `/api/v1/colaboradores/{cpf}` | Remove um colaborador do sistema |

### 📖 Livros & Empréstimos
| Método | Endpoint | Descrição |
| :--- | :--- | :--- |
| `POST` | `/api/v1/livros` | Registra novo título no acervo (ISBN) |
| `GET` | `/api/v1/livros/{isbn}` | Detalhes de um livro específico |
| `POST` | `/api/emprestimos` | Registra a saída de um livro |
| `PUT` | `/api/emprestimos/{id}` | Atualiza status/data de devolução |

---

## 📦 Exemplo de Uso (Payload)

### Criar Novo Empréstimo
`POST /api/emprestimos`
```json
{
    "dataEmprestimo": "2026-03-02T10:00:00",
    "dataDevolucao": "2026-03-16T10:00:00",
    "isbnLivro": "978-3-16-148410-0",
    "cpfColaborador": 12345678,
    "raAluno": 202401
}
