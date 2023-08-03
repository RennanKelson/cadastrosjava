# App de Academia - Backend e Frontend com Docker
## EM DESENVOLVIMENTO

Este é um projeto de exemplo de uma aplicação de academia, onde os usuários poderão cadastrar seus treinos de musculação. O projeto é composto por um backend em Java com Spring e banco de dados PostgreSQL, que possui classes com relacionamentos OneToOne e OneToMany, e um frontend desenvolvido em Angular CLI versão 15.1.6. Além disso, a aplicação foi dockerizada para facilitar a execução em diferentes ambientes.

## Tecnologias utilizadas

### Backend:
- Java 17 LTS
- Spring Framework 3.1.1
- PostgreSQL

### Frontend:
- Angular CLI 15.1.6

## Configuração

Antes de executar a aplicação, certifique-se de ter instalado as seguintes ferramentas:

- JDK 17: [Download JDK](https://www.oracle.com/java/technologies/downloads/)
- Spring Framework 3.1.1: [Spring Framework Documentation](https://docs.spring.io/spring-framework/docs/3.1.1.RELEASE/spring-framework-reference/)
- PostgreSQL: [Download PostgreSQL](https://www.postgresql.org/download/)
- Angular CLI 15.1.6: Instale usando o gerenciador de pacotes npm.

## Instalação

Siga estas etapas para executar o projeto em sua máquina local:

1. Clone este repositório: [https://github.com/RennanKelson/cadastrosjava.git](https://github.com/RennanKelson/cadastrosjava.git)

2. Importe o projeto backend em sua IDE Java preferida (por exemplo, IntelliJ, Eclipse).

3. Certifique-se de que as dependências do projeto sejam resolvidas corretamente.

4. Configure as informações de conexão com o banco de dados no arquivo `application.properties` ou `application.yml`.

5. No diretório do frontend, instale as dependências do Angular com o seguinte comando:
npm install

6. Execute o backend e o frontend. Acesse a classe principal do backend e execute o método `main()`. No frontend, execute o comando:
ng serve


7. A aplicação backend será iniciada e estará disponível em [http://localhost:8080](http://localhost:8080) e o frontend em [http://localhost:4200](http://localhost:4200).

## Uso

- Acesse [http://localhost:4200](http://localhost:4200) em seu navegador.
- A partir daí, você poderá cadastrar, visualizar, editar e excluir treinos de musculação.

Esse projeto é uma demonstração do uso de tecnologias backend e frontend juntas, além do uso de Docker para facilitar o processo de execução da aplicação. Sinta-se à vontade para utilizá-lo como base para seus estudos e projetos!




