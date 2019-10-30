<%-- 
    Document   : listaprodutos
    Created on : 16/10/2019, 20:16:36
    Author     : victo
--%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.List"%>
<%@page import="br.com.marvelShopp.model.Personagem"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="br.com.marvelShopp.utilitarios.Conexao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Marvel Shopp</title>
        <link rel="icon" type="imagem/png" href="imagens/deadpoolLogo.png" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css" /> 
    </head>
    <body>
        <% Usuario loginUser = (Usuario) request.getSession().getAttribute("user");%>
        <div id="interface">
            <%@ include file="header.jsp"%>
            <hr>
            <h1 align="center">Lista de produtos</h1>

            <%
                String busca = (String) request.getAttribute("busca");
                List<Personagem> lista = (List<Personagem>) request.getAttribute("lista");
            %>
            <div class='container' style="width: 85%;">
                <div class='row'>
                    <%if(lista.isEmpty()){
                        out.print("<div align='center'><h1 style='color: red;'>NENHUM PERSONAGEM ENCONTRADO PARA A BUSCA!!!</h1></div>");
                    }else{
                        out.print("<div align='center'>");
                        for (Personagem perso : lista) {%>
                          
                    <div class='col-sm-4 listspace'>
                        <div class='card' style='width: 18rem;'>
                            <hr><img class='card-img-top' src='imagens/<%= perso.getImagemRef()%>' width=150px height=230px alt='Card image cap'>
                            <div class='card-body'>
                                <h5 class='card-title'> <%= perso.getIdentidade()%></h5>
                                <p class='card-text'> Rank:<%= perso.getRank()%> </p>
                                <%
                                    if (perso.getQtdEstoque() < 1) {%>
                                <p class='card-text' style='color: red;'>Personagem indisponível</p>
                                <p><a href='/marvelShopp/PagProdutoController?id=<%= perso.getId()%>' class='btn btn-primary' style="width:150px;">Visualizar</a>
                                <form action="/marvelShopp/CarrinhoController?funcao=create&idPersonagem=<%= perso.getId()%>&page=p" method="POST">
                                    <input type="submit" class="btn btn-primary" value="Comprar" style="width:150px;background: green;"  disabled>
                                </form></p>
                                <%} else {%>
                                <p class='card-text'>R$ <%= perso.getPreco()%> </p>
                                
                                <p><a href='/marvelShopp/PagProdutoController?id=<%= perso.getId()%>' class='btn btn-primary' style="width:150px;">Visualizar</a>
                                <form action="/marvelShopp/CarrinhoController?funcao=create&idPersonagem=<%= perso.getId()%>&page=p" method="POST">
                                    <input type="submit" class="btn btn-primary" value="Comprar" style="width:150px;background: green;">
                                </form></p>
                                    <% }%>
                                <%if (loginUser != null){ if (loginUser.getHasAdm()) {%>
                                <p><a href='/marvelShopp/editarProduto.jsp?idPersonagem=<%= perso.getId()%>' class='btn btn-primary spacebt'>Editar</a>
                                <a href='/marvelShopp/EditarPersonagemController?id=<%= perso.getId()%>' class='btn btn-danger' >Deletar</a></P>
                                <% }} %>
                            </div>
                        </div></div>

                        <%  }
                            out.print("</div>");
                         }%>

                </div>
            </div>
            <%
                Integer limit = (Integer) request.getAttribute("limit");
                Integer numPagina = (Integer) request.getAttribute("qtdBusca");
                int totalpaginas = ((numPagina / limit) + 1);
            %>

            <hr><nav aria-label='Page navigation example' align='center'><nav aria-label='Page navigation example'>
                    <ul class='pagination list'>
                        <%
                            for (int j = 1; j <= totalpaginas; j++) {
                                out.println("<li class='page-item'><a  class='page-link'href='BuscaController?busca=" + busca + "&numpagina=" + j + "'>" + j + "</a></li>");
                            }%>
                    </ul>
                </nav>
            </nav><hr>

            <%@ include  file="footer.jsp"%>      
        </div>

    </body>
</html>
