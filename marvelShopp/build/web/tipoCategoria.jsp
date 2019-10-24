<%-- 
    Document   : tiipoCategoria
    Created on : 03/10/2019, 23:44:01
    Author     : Gleison
--%>

<%@page import="br.com.marvelShopp.model.TipoCategoria"%>
<%@page import="java.util.List"%>
<%@page import="br.com.marvelShopp.dao.TipoCategoriaDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Marvel Shopp - Top 10</title>
        <link rel="icon" type="imagem/png" href="imagens/deadpoolLogo.png" />
       <!-- <link rel = "shortcut icon" type = "imagem/x-icon" href = "imagens/favicon.ico"/> -->
        <link rel="stylesheet" href="css/style.css" /> 
        <link rel="stylesheet" href="css/form.css" /> 
    </head>
    <body>
        <% Usuario loginUser = (Usuario)request.getSession().getAttribute("user");%>
        <div id="interface">
            <%@ include file="header.jsp"%>
            <section id="corpo"> <!--divisão da pagina. Aqui se inicia o corpo da pagina (seção do meio)-->
                <form action="TipoCategoriaController" method="get" id="tipoCat">            
                    <h1>Tipo Categoria</h1>
                    <table id="exibeCatCad">
                        <tr>
                            <td>ID</td>
                            <td>Nome</td>
                            <td>Deletar</td>
                        </tr>

                       <%
                           TipoCategoriaDao tcl = new TipoCategoriaDao();
                           List<TipoCategoria> tipoCategoria = tcl.list();
                           for (TipoCategoria tc : tipoCategoria){               
                       %>
                       <tr>
                           <td><%= tc.getId()%> </td>
                           <td><%= tc.getNome()%> </td>
                           <td><a href="TipoCategoriaController"><img id="delete" src="imagens/delete.png"/></td>
                       </tr>
                       <% } %>
                    </table>
                    <table id="cadCat">
                        <tr>
                            <td>Cadastrar Novo: </td>
                            <td><input type="text" name="tCat" id="tCat"/></td>
                            <td><input type="submit" value="Cadastrar" id="bCat"/></td>
                        </tr>
                    </table>
                </form>
            </section>
            <%@ include file="footer.jsp"%>
        </div>
    </body>
</html>
