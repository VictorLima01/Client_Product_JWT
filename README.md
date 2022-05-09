# Desafio-LuizaLabs
Api em Spring boot para desafio Luiza labs


Api´s de criação de clientes e produtos e vinculando lista de produtos aos clientes. Api´s de CRUD e vincular produto ao cliente pelo id do cliente e id do produto.
A aplicação foi criada com o banco H2 utiizando a liguagem SQL, a escolha foi feita por motivos de mais facilidade e performance do código. Para startar a aplicação basta 
dar o comando "mvn spring-boot:run". Foi criado uma collection do Postman para as API´s, segue o link do drive para baixar a collection: https://drive.google.com/drive/folders/1nDOvBUZbEahmDUUE6lJVWW-Qb4ot4-9C

----------------------------------------------------------------------------------------------------------------------------------------------------------------

As funcionalidade dos código: Para o funcionamento e o entendimento dos processos, foi criado uma api de criação de clientes e de produtos. Para a criação de produtos
é necessário a adição do id, e é possível a edição total de um CRUD para os CLientes e os Produtos. Para acessar o banco h2 http://localhost:8080/h2-console/ e para consultar basta colocar essa valro jdbc:h2:mem:testdb no campo JDBC URL: e clicar em connect. 
