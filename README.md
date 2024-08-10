# Projeto de Gerenciamento de Cliente e Pedidos

Este projeto tem como objetivo demonstrar meus principais conhecimentos sobre Java, Maven, Spring Boot (Spring JPA, Spring Web) e pesistencia dos dados com PostgreSQL. Neste projeto desenvolvi uma API RESTful para o gerenciamento de clientes e seus respectivos pedidos em uma única base de dados. Apliquei ORM para gerar tabelas e os relacionamentos entre as entidades do banco de dados e configurei todos os endpoints.

## Tecnologias

![Java](https://img.icons8.com/?size=30&id=13679&format=png&color=000000)
![Spring Framework](https://img.icons8.com/?size=30&id=90519&format=png&color=000000)
![PostgresSQL](https://img.icons8.com/?size=30&id=38561&format=png&color=000000)
![Maven](https://img.icons8.com/?size=30&id=t5FJr3NzrPSm&format=png&color=FFFFFF)

## Diagrama da API


```mermaid
erDiagram
    CUSTOMER {
        string id PK "ID do Cliente"
        string name "Nome"
        string email "Email"
    }
    PROFILE {
        string id PK "ID do Perfil"
        string customerId FK "ID do Cliente"
        string address "Endereço"
        string phone "Telefone"
    }
    CATEGORY {
        string id PK "ID da Categoria"
        string name "Nome"
    }
    PRODUCT {
        string id PK "ID do Produto"
        string name "Nome"
        string description "Descrição"
        decimal price "Preço"
        string categoryId FK "ID da Categoria"
    }
    ORDER {
        string id PK "ID do Pedido"
        string customerId FK "ID do Cliente"
        date orderDate "Data do Pedido"
        decimal totalAmount "Valor Total" "total de quantity*PRODUCT.price de todos os order_item"
    }
    ORDER_ITEM {
        string id PK "ID do Item do Pedido"
        string orderId FK "ID do Pedido"
        string productId FK "ID do Produto"
        integer quantity "Quantidade"
    }

    CUSTOMER ||--o| PROFILE : has
    CATEGORY ||--o{ PRODUCT : contains
    PRODUCT ||--o{ ORDER_ITEM : "is part of"
    ORDER ||--o{ ORDER_ITEM : "contains"
    CUSTOMER ||--o{ ORDER : places
```

## Instalação

Antes de começar, certifique-se de que você possui as seguintes ferramentas instaladas em sua máquina:

- JDK (Java Development Kit): Versão 17 ou superior.
- Maven: Versão 3.6 ou superior.
- Git (opcional): Para clonar o repositório do projeto.
- IDE (opcional): IntelliJ IDEA, Eclipse, ou qualquer outra de sua preferência.
- PostgreSQL: Versão 8.7 ou superior.
- Postman(Opcional): Para teste da API.

Usando git poderá criar um clone do repositório:

```
git clone https://github.com/GeovanaMat/API-REST-Gerenciamento-Cliente-e-Pedidos
```

vá até o diretorio do projeto clonado usando:
````
cd API-REST-Gerenciamento-Cliente-e-Pedidos
````

## Configurando o Ambiente

### Instalar Dependências
O Maven cuidará das dependências do projeto. Para instalar todas as dependências necessárias, execute:

````
mvn clean install
````

Este comando limpará quaisquer arquivos antigos, baixará e instalará todas as dependências especificadas no arquivo pom.xml, e construirá o projeto.


### Configurar Variáveis de Ambiente 
O  projeto requer variáveis de ambiente específicas, execute esse código para definir as variávies de ambiente:

````
set DB_HOST=localhost
set DB_USER=seu-usuario
set DB_PASSWORD=sua-senha
set DB_NAME=nome-database
````

### Executar o Projeto
- Executar projeto com Maven:
  
```
mvn spring-boot:run
````

**A aplicação estará disponível no endereço padrão, como http://localhost:8080.**

Acesse `http://localhost:8080` no navegador.

## Teste de endpoints

No navegador você poderá acessar os seguinte URL para acessar Swagger UI para conhecer todos os endpoints:
#### `/swagger-ui.html`

