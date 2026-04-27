# Calculadora de Materiais para Obra Residencial

## Descrição

Aplicação desenvolvida em Java com Spring Boot para cálculo de materiais utilizados em obras residenciais. Feito como projeto para a disciplina de Desenvolvimento de Sistemas. 

O sistema calcula:

* Volume de concreto para vigas baldrame
* Quantidade de tijolos para paredes

## Tecnologias Utilizadas

* Java 17
* Spring Boot
* Spring Web
* Spring Validation
* Swagger (OpenAPI)
* Maven

## Como executar

1. Clonar o repositório
2. Abrir o projeto
3. Rodar a classe principal (`CalculadoraObraApplication`)
4. Acessar o Swagger:
   http://localhost:8080/swagger-ui/index.html


## Arquitetura

O projeto foi organizado em camadas:

- Controller: responsável pelos endpoints da API
- Service: responsável pelas regras de negócio
- DTO: responsável pela comunicação de dados


## Endpoints

### 🔹 Concreto

POST /api/materiais/concreto

Exemplo:

```json
{
  "altura": 0.3,
  "arestas": [
    { "largura": 0.2, "comprimento": 10 },
    { "largura": 0.2, "comprimento": 8 }
  ]
}
```

Resposta:

```json
{
  "resultado": 1.08
}
```

---

### 🔹 Tijolos

POST /api/materiais/tijolos

Exemplo:

```json
{
  "alturaTijolo": 0.2,
  "larguraTijolo": 0.1,
  "comprimentoTijolo": 0.3,
  "arestas": [
    { "largura": 3, "comprimento": 10 },
    { "largura": 3, "comprimento": 8 }
  ]
}
```

Resposta:

```json
{
  "resultado": 900.0
}
```

## Validações

* Valores devem ser positivos;
* Lista de arestas não pode ser vazia.

