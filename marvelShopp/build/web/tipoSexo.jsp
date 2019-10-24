<%-- 
    Document   : tipoSexo
    Created on : 03/10/2019, 23:11:37
    Author     : Gleison
--%>

<%@page import="br.com.marvelShopp.model.TipoSexo"%>
<%@page import="java.util.List"%>
<%@page import="br.com.marvelShopp.dao.TipoSexoDao"%>
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
                <form action="TipoSexoController" method="get" id="tipoSexo">            
                    <h1>Tipo Sexo</h1>
                    
                    <table id="exibeSexoCad">
                        <tr>
                            <td>ID</td>
                            <td>Nome</td>
                            <td>Deletar</td>
                        </tr>

                       <%
                           TipoSexoDao tsl = new TipoSexoDao();
                           List<TipoSexo> tipoSexo = tsl.list();
                           for (TipoSexo ts : tipoSexo){               
                       %>
                       <tr>
                           <td><%= ts.getId()%> </td>
                           <td><%= ts.getNome()%> </td>
                           <td><a href="TipoSexoController"><img id="delete" src="imagens/delete.png"/></td>
                       </tr>
                       <% } %>
                    </table>
                    <table id="cadSexo">
                        <tr>
                            <td>Cadastrar novo: </td>
                            <td><input type="text" name="tSexo" id="tSexo"/></td>
                            <td><input type="submit" value="Cadastrar" id="bSexo"/></td>
                        </tr>
                    </table>
                </form>
            </section>
            <%@ include file="footer.jsp"%>
        </div>
    </body>
</html>
