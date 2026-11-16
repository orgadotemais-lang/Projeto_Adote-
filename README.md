# Adote+

Sistema de gerenciamento de adoção e resgate de animais.

## Objetivo

O Adote+ facilita o processo de adoção de animais, permitindo o cadastro de animais, adotantes, organizações, solicitações de adoção e resgates.

## Tecnologias

- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate
- Spring Security
- MySQL
- Maven
- Bean Validation

## Arquitetura

O projeto utiliza as seguintes camadas:

- entidades
- repositorios
- servicos
- controladores
- config
- excecoes

## Entidades

- Usuario
- Adotante
- Organizacao
- Animal
- Encontrador
- Solicitacao
- Resgate
- Etapa
- Foto

## Banco de dados

O sistema utiliza MySQL. As configurações estão em:

`ecommerce/src/main/resources/application.properties`

Configure o endereço, nome do banco, usuário e senha conforme seu ambiente.

## Como executar

Entre na pasta do backend:

`cd ecommerce`

Execute os testes:

`./mvnw clean test`

Inicie a aplicação:

`./mvnw spring-boot:run`

A API utiliza a porta 8080.

## Endpoints

- `/usuarios`
- `/adotantes`
- `/organizacoes`
- `/animais`
- `/encontradores`
- `/solicitacoes`
- `/resgates`
- `/etapas`
- `/fotos`

Os recursos possuem operações de consulta, cadastro, atualização e exclusão.

## Consultas específicas

- `/animais/status/{status}`
- `/solicitacoes/status/{status}`

## Segurança

A API utiliza autenticação HTTP Basic.

Usuários de demonstração:

- Administrador: `admin` / `admin123`
- Usuário comum: `usuario` / `usuario123`

As consultas exigem autenticação. Cadastro, atualização e exclusão são restritos ao administrador.

## Tratamento de erros

- HTTP 400: dados inválidos.
- HTTP 401: usuário não autenticado.
- HTTP 403: usuário sem permissão.
- HTTP 404: recurso não encontrado.
- HTTP 409: conflito com regra de negócio.

## Autor

## Integrantes

- Guilherme Gabriel Marques Rodrigues — RA: 273337
- Diego Domiciano de Andrade Luzio — RA: 272330
- Felipe Santos Siqueira — RA: 273209
- Guilherme Gonçalves Vieira — RA: 273546
- Kauã Henrique Nogari Sabia — RA: 273554
