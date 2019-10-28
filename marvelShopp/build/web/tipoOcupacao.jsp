<%-- 
    Document   : tipoOcupacao
    Created on : 03/10/2019, 23:33:58
    Author     : Gleison
--%>

<%@page import="br.com.marvelShopp.model.TipoOcupacao"%>
<%@page import="java.util.List"%>
<%@page import="br.com.marvelShopp.dao.TipoOcupacaoDao"%>
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
                <form action="TipoOcupacaoController" method="POST" id="tipoOcup">            
                    <h1>Tipo Ocupação</h1>
                    
                    <table id="exibeOcupCad">
                        <tr>
                            <td>ID</td>
                            <td>Nome</td>
                            <td>Deletar</td>
                        </tr>

                       <%
                           TipoOcupacaoDao tol = new TipoOcupacaoDao();
                           List<TipoOcupacao> tipoOcupacao = tol.list();
                           for (TipoOcupacao to : tipoOcupacao){               
                       %>
                       <tr>
                           <td><%= to.getId()%> </td>
                           <td><%= to.getNome()%> </td>
                           <td><a href="TipoOcupacaoController?idTOcup=<%= to.getId()%>"><img id="delete" src="imagens/delete.png"/></td>
                       </tr>
                       <% } %>
                    </table>
                    <table id="cadOcup">
                        <tr>
                            <td>Cadastrar Novo: </td>
                            <td><input type="text" name="tOcup" id="tOcup"/></td>
                            <td style="padding-left:20px; "><input type="submit" class=" btn btn-primary"  value="Cadastrar" id="bOcup"/></td>
                        </tr>
                    </table>
                </form>
            </section>
            <%@ include file="footer.jsp"%>
        </div>
    </body>
</html>
