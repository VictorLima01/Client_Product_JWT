# App Spring boot com implementação de token
App Spring boot com implementação de token


Api´s de criação de clientes e produtos e vinculando lista de produtos aos clientes. Api´s de CRUD e vincular produto ao cliente pelo id do cliente e id do produto.
A aplicação foi criada com o banco H2 utiizando a liguagem SQL, a escolha foi feita por motivos de mais facilidade de teste feito por terceiros por ser um banco que vai subir local e performance do código. Para startar a aplicação basta 
dar o comando "mvn spring-boot:run". Foi criado uma collection do Postman para as API´s, segue o link do drive para baixar a collection: https://drive.google.com/drive/folders/12iZQblcDBuEzK4xsZc1DkacL6g4mjnZS

----------------------------------------------------------------------------------------------------------------------------------------------------------------

As funcionalidade dos código: Para o funcionamento e o entendimento dos processos, foi criado uma api de criação de clientes e de produtos. Para a criação de produtos
é necessário a adição do id, e é possível a edição total de um CRUD para os CLientes e os Produtos. Para acessar o banco h2 http://localhost:8080/h2-console/ e para consultar basta colocar essa valro jdbc:h2:mem:testdb no campo JDBC URL: e clicar em connect. 


Para a validação do Token funcionar corretamente é necessário seguir alguns passos, como por exemplo: 

# 1 - http://localhost:8080/auth/register
- Api que cadastra usuário para posteriormente fazer o login. No body de cadatsro passamos a role do usuário, que se for ADMIN poderá fazer todas as request e se for USER ou qualquer outra não consiguirá.

#2 - http://localhost:8080/auth/login
- Api que retorna o token com os dados de login e senha do usuário cadastrado.

#3 - O restante das requests
- Adicionar o Bearer Autentication no header das requests.
