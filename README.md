<p align="center">
    <img src="https://spring.io/images/spring-logo-9146a4d3298760c2e7e49595184e1975.svg" alt="Teste Deliver IT - Spring Boot" width="200" height="165">
</p>

<h3 align="center">Teste - Desenvolvimento: Deliver IT</h3>

<p align="center">
  Contas a Pagar
</p>

## Tecnologias utilizadas

Algumas das tecnologias utilizadas: 

<a href="https://oracle.com/java">Java 8</a><br />
<a href="https://junit.org">JUNIT</a><br />
<a href="https://maven.apache.org">Maven</a><br />
<a href="https://spring.io/projects/spring-boot">Spring Boot</a><br />
<a href="https://swagger.io">Swagger</a><br />
<a href="https://docker.io">Docker</a><br /><br /><br />

## Testes Unitários/Integração

Disponibilizei apenas para demonstração bastante simples na aplicação a realização de um teste de integração com o JUNIT porém o deixei comentado pois o banco de dados esta no container e se o container não estiver rodando e tentar rodar a aplicação pela IDE vai ocorrer falha na conexão durante o teste.

## Documentação da api com o swagger

Após a execução dos containers a documentação fica disponível.<br /><br />
Url para acesso a documentação da api:<br />
<a href="http://localhost:8090/swagger-ui/index.html">Documentação</a>
<br /><br />

## Execução da api

Após realizar o download da aplicação no git, realize sua extração, acesse a pasta raiz da api onde se encontra o arquivo: docker-compose.yml pelo terminal/prompt/shell e execute o seguinte comando:<br /><br /> docker-compose up --build --always-recreate-deps

<br /><br />
É importante lembrar que o docker deve está ativo na máquina em que o comando será executado
<br /><br />

## Agradecimento

Desde já gostaria de agradecer imensamente a oportunidade. Muito obrigado!<br /><br />
Atenciosamente:<br />
Renato Xavier

