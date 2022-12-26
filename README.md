## Descrição
Projeto modelo em Java Spring. API para realizar CRUD em um quadro de usuários.  

## Diagrama de classe do model
<div align="center">
<img src="https://raw.githubusercontent.com/wlfoj/images/main/crudUsers/diagram_class1.svg?token=GHSAT0AAAAAAB4G5M7TLAW5OXZLNCWU7VHWY5KDJLA" width="440" height="440"/>
</div>

## Modelos de requisição

### Create Employee
``
{
"id": 1,
"name": "joao",
"birth": "2022-02-02",
"addres": "Rua ficticia",
"phone": "78 9239283",
"email": "kkkk@gmail.com",
"cpf": "999",
"department": "DEVELOPMENT_PRODUCT",
"salary": 999.0,
"type": "E"
}
``

### Create Customer

``
{
}
``

## Tarefas futuras
- [x] Incluir CORS
- [ ] Incluir autênticação com Token
- [x] Incluir documentação Swagger
- [ ] Incluir testes
- [ ] Arquitetura hexagonal
- [ ] Aplicar DTO pattern
- [ ] Inserir validações para criar outros Users do tipo Employee

## Referências
- Commit Conventional: https://www.conventionalcommits.org/pt-br/v1.0.0-beta.4/     https://ilegra.com/blog/tudo-o-que-voce-precisa-saber-sobre-commits-semanticos/
- Docs Swagger: https://medium.com/rapaduratech/adicionando-swagger-para-testar-sua-api-em-spring-boot-1eebeee70d0f
- Status HTTP: https://developer.mozilla.org/pt-BR/docs/Web/HTTP/Status

## Dicas
- Acesso ao UI Swagger em: http://localhost:8081/swagger-ui/

