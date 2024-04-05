## Sobre o Projeto 

Ele divide-se em dois repositórios diferentes, um contendo o Backend, que é o principal e que também é o repositório em questão; e o outro, contendo o frontend.

### Link para o repositório do Frontend

    https://github.com/prompty001/frontend-desafio

## Repositório 1 - Backend

- Foi utilizada a linguagem Java, como requisitado. O framework spring boot foi também utilizado para o CRUD.
- O BD utilizado foi o H2.
- Os padrões de design DAO e DTO também foram utilizados.

## Testando o CRUD

Ao inicializar o projeto para testá-lo, é necessário antes setar o IP da sua máquina. Para isso, basta deletar as linhas 11 e 12 do arquivo `application.properties`.
Se não quiser utilizar O Postman, por exemplo, pode fazer as requisições utilizando o bom e velho Curl.

### Criando um cliente

    curl -X POST localhost:8080/costumers -H "Content-Type: application/json" -d '{"name":"Zed", "cpf":"12345678911", "birthday":"2000-01-01"}'

### Exibindo todos os clientes cadastrados

    curl localhost:8080/costumers

### Alterando os dados de um determinado cliente

    curl -X PUT localhost:8080/costumers/<id_costumer> -H "Content-Type: application/json" -d '{"name":"ZedAlterado", "cpf":"12345678911", "birthday":"2000-01-01"}'

### Deletando um cliente

    curl -X DELETE localhost:8080/costumers/<id_costumer>
