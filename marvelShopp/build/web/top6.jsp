<%-- 
    Document   : top10
    Created on : 22/09/2019, 10:07:50
    Author     : Gleison
--%>

<%@page import="br.com.marvelShopp.dao.PersonagemDao"%>
<%@page import="java.util.List"%>
<%@page import="br.com.marvelShopp.model.Personagem"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Marvel Shopp</title>
        <link rel="icon" type="imagem/png" href="imagens/deadpoolLogo.png" />
        <link rel="stylesheet" href="css/style.css" /> 
    </head>
    <body>
        <div id="interface">
            <%@ include file="header.jsp"%>
            
            <section id="corpo"> <!--divisão da pagina. Aqui se inicia o corpo da pagina (seção do meio)-->
                <h1 align="center">Top 6</h1>
                <%
                Usuario loginUser = (Usuario) request.getSession().getAttribute("user");
                PersonagemDao personagemDao = new PersonagemDao();
                List<Personagem> lista = personagemDao.getTop6();
                %>
                <div class='container'>
                    <div class='row'>
                        <%    for (Personagem perso : lista) {%>
                        <div class='col-sm-4 listspace'>
                            <div class='card' style='width: 18rem;'>
                                <hr><img class='card-img-top' src='imagens/<%= perso.getImagemRef()%>' width=150px height=230px alt='Card image cap'>
                                <div class='card-body'>
                                    <h5 class='card-title'> <%= perso.getIdentidade()%></h5>
                                    <p class='card-text'> Rank:<%= perso.getRank()%> </p>
                                    <%
                                        if (perso.getQtdEstoque() < 1) {%>
                                    <p class='card-text' style='color: red;'>Personagem indisponível</p>
                                    <%} else {%>
                                    <p class='card-text'>R$ <%= perso.getPreco()%> </p>
                                    <% }%>
                                    <a href='/marvelShopp/PagProdutoController?id=<%= perso.getId()%>' class='btn btn-primary'>Visualizar</a>
                                    <%if (loginUser != null){ if (loginUser.getHasAdm()) {%>
                                    <a href='/marvelShopp/editarProduto.jsp?idPersonagem=<%= perso.getId()%>' class='btn btn-primary spacebt'>Editar</a>
                                    <a href='/marvelShopp/EditarPersonagemController?id=<%= perso.getId()%>' class='btn btn-danger' >Deletar</a>
                                    <% }} %>
                                </div>
                            </div>
                        </div>

                        <% }
                         if(lista.isEmpty()){%>
                            <div align="center"><h1 style="color: red;">ESTAMOS TRABALHANDO NESSA FUNCIONALIDADE!!!</h1></div>
                         <%}%>

                    </div>
                </div>
            </section>
                        <br><br>
            <%@ include file="footer.jsp"%>
        </div>
    </body>
</html>
