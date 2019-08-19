# dewes-spring-boot-interview
      Roteiro Entrevista Spring Boot
      
    • Cadastrar cidade 
        ◦ endpoint: [POST] http://localhost:8080/cidades/
        ◦ request headers: Content-Type: application/json; utf-8
        ◦ request body: {"nome":"Carlos Barbosa","estado":"RS"}
        ◦ response: [201] http://localhost:8080/cidades/3
    • Cadastrar cliente 
        ◦ endpoint: [POST] http://localhost:8080/clientes/
        ◦ request headers: Content-Type: application/json; utf-8
        ◦ request body: {"nome":"Ana Maria","sexo":"F","dataNascimento":"01/01/1990","cidade":{"id":"0"}}
        ◦ response: [201]  http://localhost:8080/clientes/3
    • Consultar cidade pelo nome 
        ◦ endpoint: [GET] http://localhost:8080/cidades/byNome/{nome} (http://localhost:8080/cidades/byNome/Blumenau)
        ◦ response: [200] {"id":"2","nome":"Blumenau","estado":"SC"}
    • Consultar cidade pelo estado 
        ◦ endpoint: [GET] http://localhost:8080/cidades/byEstado/{estado} (http://localhost:8080/cidades/byEstado/SC)
        ◦ response: [200] [{"id":"0","nome":"Florianópolis","estado":"SC"},{"id":"2","nome":"Blumenau","estado":"SC"}]
    • Consultar cliente pelo nome 
        ◦ endpoint: [GET] http://localhost:8080/clientes/byNome/{nome} (http://localhost:8080/clientes/byNome/Maria%20dos%20Santos)
        ◦ response: {"id":"1","nome":"Maria dos Santos","sexo":"F","dataNascimento":"1995-08-20","idade":23,"cidade":{"id":"1","nome":"Porto Alegre","estado":"RS"}}
    • Consultar cliente pelo Id 
        ◦ endpoint: [GET] http://localhost:8080/clientes/{id} (http://localhost:8080/clientes/2)
        ◦ response: {"id":"2","nome":"Ana dos Santos","sexo":"F","dataNascimento":"2000-01-15","idade":19,"cidade":{"id":"1","nome":"Porto Alegre","estado":"RS"}}
    • Remover cliente 
        ◦ endpoint: [DELETE] http://localhost:8080/clientes/{id} (http://localhost:8080/clientes/3)
        ◦ response: [204]
    • Alterar o nome do cliente
        ◦ endpoint: [PUT] http://localhost:8080/clientes/
        ◦ request headers: Content-Type: application/json; utf-8
        ◦ request body: {"id":"0","nome":"Joao dos Santos"}
        ◦ response: [200] {"id":"0","nome":"Joao dos Santos","sexo":"M","dataNascimento":"1982-01-12","idade":37,"cidade":{"id":"0","nome":"Florianópolis","estado":"SC"}}
