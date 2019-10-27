<%-- 
    Document   : listaFavorito
    Created on : 26/10/2019, 21:47:26
    Author     : Victor
--%>

<%@page import="br.com.marvelShopp.model.Personagem"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Marvel Shopp</title>
        <link rel="icon" type="imagem/png" href="imagens/deadpoolLogo.png" />
    </head>
    <body>
        <% Usuario loginUser = (Usuario)request.getSession().getAttribute("user");
           int i =1;%>
        <div id="interface">
            <%@ include file="header.jsp"%>
            <section id="corpo">
                 <h1 id="titulo" align="center">Favoritos</h1>
                    <% if (loginUser.getFavoritos().isEmpty()){%>
                    <div align="center"><h1 style="color: red;">NENHUM FAVORITO CADASTRADO!!!</h1></div><br><br>
                    <%}else{%>
                    <table class="table">
                        <thead class="thead-dark">
                          <tr>
                            <th scope="col">#</th>
                            <th scope="col">identidade</th>
                            <th scope="col">Nome</th>
                            <th scope="col">Ocupação</th>
                            <th scope="col">Categoria</th>
                            <th scope="col">Sexo</th>
                            <th scope="col">Preço</th>
                            <th scope="col">+ Detalhes</th>
                          </tr>
                        </thead>
                        <tbody>
                          <% for(Personagem persona : loginUser.getFavoritos()){ %>  
                          <tr>
                            <th scope="row" ><%=i++%></th>
                            <td><%=persona.getIdentidade()%></td>
                            <td><%=persona.getNomeReal()%></td>
                            <td><%=persona.getOcupacao().getNome()%></td>
                            <td><%=persona.getCategoria().getNome()%></td>
                            <td><%=persona.getSexo().getNome()%></td>
                            <td><%=persona.getPreco()%></td>
                            <td><a href="PagProdutoController?id=<%=persona.getId()%>"  data-toggle="tooltip" data-placement="bottom" title="<img src='imagens/<%=persona.getImagemRef()%>'/>">DETALHES</a></td>
                          </tr>
                          <%}%>
                        </tbody>
                    </table>
                        <br><br>
                    <%}%>
            </section>
            <%@ include file="footer.jsp"%>
        </div>
    </body>
</html>
