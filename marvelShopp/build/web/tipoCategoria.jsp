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
        <link rel="stylesheet" href="css/estilo.css" /> 
        <link rel="stylesheet" href="css/form.css" /> 
    </head>
    <body>
        <div id="interface">
            <%@ include file="header.jsp"%>
            <section id="corpo"> <!--divisão da pagina. Aqui se inicia o corpo da pagina (seção do meio)-->
                <form action="TipoCategoriaController" method="get" id="tipoCat">            
                    <h1>Tipo Categoria</h1>
                    <table>
                        <tr>
                            <td>Tipo Categoria: </td>
                            <td><input type="text" name="tCat" id="tCat"/></td>
                            <td><input type="submit" value="Enviar" id="bCat"/></td>
                        </tr>
                        
                    </table>
                    <br/>
                    <br/>
                    <table>
                        <tr>
                            <td>ID</td>
                            <td>Nome</td>
                        </tr>

                       <%
                           TipoCategoriaDao tcl = new TipoCategoriaDao();
                           List<TipoCategoria> tipoCategoria = tcl.list();
                           for (TipoCategoria tc : tipoCategoria){               
                       %>
                       <tr>
                           <td><%= tc.getId()%> </td>
                           <td><%= tc.getNome()%> </td>
                       </tr>
                       <% } %>
                    </table>
                </form>
            </section>
            <%@ include file="footer.jsp"%>
        </div>
    </body>
</html>
