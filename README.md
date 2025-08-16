# 📘 Avaliação Técnica - Back-end Tinnova

Este repositório contém a resolução dos desafios propostos no Teste Back-end da Tinnova.
O projeto foi desenvolvido em Java 17 (Spring Boot) e utiliza Maven para gerenciamento de dependências.

## 📂 Estrutura do Projeto

Atividade 1 → Cálculo de percentual de votos válidos, brancos e nulos em relação ao total.

Atividade 2 → Algoritmo de ordenação Bubble Sort.

Atividade 3 → Cálculo de fatorial.

Atividade 4 → Soma de multiplos de 3 ou 5.

Atividade 5 → API REST de veículos.

## ⚙️ Tecnologias Utilizadas

Java 17

Spring Boot 3

Spring Data JPA

Spring Web

MySQL

Maven

Docker

Docker-Compose

## 📦 Como Rodar o Projeto
1. Clonar o repositório
```
git clone https://github.com/mateushlsilva/tinnova-avaliacao.git
cd tinnova-avaliacao
```

### Atividade 1
Cálculo de percentual de votos válidos, brancos e nulos em relação ao total.

Para rodar o projeto use:

```
make ativ1
```

### Atividade 2
Algoritmo de ordenação Bubble Sort.

Para rodar o projeto use:
```
make ativ2
```

### Atividade 3
Cálculo de fatorial.

Para rodar o projeto use:
```
make ativ3
```

### Atividade 4
Soma de multiplos de 3 ou 5.

Para rodar o projeto use:
```
make ativ4
```

### Atividade 5 com Docker
API REST de veículos.

Para rodar o projeto use:

```
make ativ5-docker
```

### Atividade 5 sem Docker
API REST de veículos.

1. Configurar o banco de dados

    No arquivo ativ5/src/main/resources/application.properties, configure sua conexão MySQL:
    ```
    spring.datasource.url = jdbc:mysql://localhost:3306/SEUBANCO?useTimezone=true&serverTimezone=UTC
    spring.datasource.username = USERNAME
    spring.datasource.password = PASSWORD
    ```
    No DDL.sql ativ5/docker/mysql-init/DDL.sql configure seu banco MySQL:
    ```
    use SEUBANCO;
    ```

    No Makefile:
    ```
    MYSQL_USER = USERNAME
    MYSQL_PASSWORD = PASSWORD
    MYSQL_DB = SEUBANCO
    ```


Para rodar o projeto use:
```
make ativ5-run
```
### API

<b>A API estará disponível em: http://localhost:8080

Documentação Swagger:
http://localhost:8080/swagger-ui/index.html

</b>

### ✅ Regras de Negócio

O campo created é preenchido automaticamente ao criar um veículo.

O campo updated é atualizado automaticamente ao modificar um veículo.

Retorna erro 404 caso o veículo não seja encontrado.

## 👨‍💻 Autor

Desenvolvido por <b>Mateus Silva</b> para o processo seletivo da <b>Tinnova</b>.