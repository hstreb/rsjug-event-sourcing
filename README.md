# Exemplo de utilização de event-sourcing

O projeto possui 2 exemplos, uma aplicação monolitica `seguros-monolito` e a versão com micro-serviços `seguros-event-sourcing`.

Os projetos utilizam spring boot, e podem ser importados para qualquer IDE.

### seguros-monolito
O projeto `seguros-monolito` ainda não possui um docker-compose para rodar o projeto, portanto basta rodar a classe `App.java`, este projeto não possui dependências externas, roda um H2 em memória.


### seguros-event-sourcing
O `seguros-event-sourcing` é dividido em 2 micro-serviços, para rodar é preciso rodar `docker-compose up` para subir o kafka, depois é rodar as classes `Application.java` de cada projeto.
