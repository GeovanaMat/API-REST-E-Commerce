

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
        decimal totalAmount "Valor Total"
    }
    ORDER_ITEM {
        string id PK "ID do Item do Pedido"
        string orderId FK "ID do Pedido"
        string productId FK "ID do Produto"
        integer quantity "Quantidade"
        decimal unitPrice "Preço Unitário"
    }

    CUSTOMER ||--o| PROFILE : has
    CATEGORY ||--o{ PRODUCT : contains
    PRODUCT ||--o{ ORDER_ITEM : "is part of"
    ORDER ||--o{ ORDER_ITEM : "contains"
    CUSTOMER ||--o{ ORDER : places
