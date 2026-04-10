# Projeto BackEnd Frameworks

Este é um **projeto universitário do professor: Daniel Marques** desenvolvido pelos alunos **Isaque Ferreira** e **Mauricio Alves**.

## Sobre o projeto
O sistema foi criado em **Java** com o objetivo de praticar a integração entre aplicação e banco de dados, utilizando o cadastro de carros como exemplo.

A proposta do projeto é mostrar, de forma simples, como um sistema backend pode:
- conectar com o banco de dados;
- cadastrar informações;
- listar registros salvos;
- atualizar dados existentes;
- remover registros.

## Estrutura do projeto
O projeto está dividido em partes principais:

- **model/Carro.java**  
  Representa a entidade do sistema. Cada carro possui id, nome, valor e ano.

- **database/Conexao.java**  
  Responsável por abrir, testar e fechar a conexão com o banco de dados.

- **database/CarroDAO.java**  
  Classe que executa as operações no banco de dados. Nela estão os métodos de inserir, listar, atualizar e deletar carros.

- **database/Main.java**  
  Classe principal usada para testar o funcionamento do sistema.

- **sql/sql-carro.sql**  
  Arquivo com a estrutura da tabela e comandos SQL usados no projeto.

- **test/**  
  Pasta reservada para testes da aplicação.

## Funcionalidades
O projeto realiza as quatro operações básicas de um sistema com banco de dados:

- **Create**: adiciona um carro no banco;
- **Read**: lista os carros cadastrados;
- **Update**: atualiza os dados de um carro;
- **Delete**: remove um carro do banco.

## Objetivo acadêmico
Este projeto foi desenvolvido com fins educacionais para reforçar conteúdos de:
- programação orientada a objetos;
- conexão com banco de dados;
- comandos SQL;
- organização em camadas básicas de um sistema backend.

## Observação
O projeto tem caráter didático e foi construído como prática universitária para demonstrar o funcionamento de um CRUD em Java.
