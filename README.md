Sistema CRUD de Clientes — Java + PostgreSQL

Este projeto é um CRUD de clientes desenvolvido em Java, utilizando JDBC para conexão com banco de dados PostgreSQL.
A aplicação funciona via console e permite cadastrar, listar, alterar e deletar clientes, aplicando boas práticas de organização de código e separação de responsabilidades.

Funcionalidades

Cadastrar cliente (nome e email)
Listar todos os clientes
Alterar dados de um cliente
Deletar cliente pelo email
Prevenção contra SQL Injection com PreparedStatement
Menu interativo em loop

Tecnologias Utilizadas

Java 8
JDBC
PostgreSQL
IntelliJ IDEA
Git / GitHub

Estrutura do Projeto
src/
├── app/
│   └── Main.java           # Entry point e menu da aplicação
├── dao/
│   └── ClienteDAO.java     # Acesso ao banco de dados (CRUD)
├── model/
│   └── Cliente.java        # Entidade Cliente
└── util/
    └── Conexao.java        # Classe de conexão JDBC

Conceitos Aplicados

Programação Orientada a Objetos (POO)
Padrão DAO (Data Access Object)
Separação de responsabilidades
Uso de PreparedStatement
Tratamento de exceções com try-with-resources
Modularização do código
Boas práticas de organização

🗄️ Estrutura da Tabela no Banco
CREATE TABLE Cliente (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL
);

▶️ Como Executar o Projeto

Clone o repositório:

git clone https://github.com/seu-usuario/nome-do-repositorio.git


Configure o banco de dados PostgreSQL

Ajuste as credenciais na classe Conexao.java

Execute a classe Main

Use o menu no console para interagir com o sistema

 Autor

Elton Fernandes
Estudante de Desenvolvimento Backend
Focado em Java, Banco de Dados e boas práticas de programação.
