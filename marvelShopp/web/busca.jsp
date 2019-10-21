<%-- 
    Document   : busca
    Created on : 10/10/2019, 20:03:52
    Author     : chris
--%>

<%@page import="java.util.List"%>
<%@page import="br.com.marvelShopp.model.Personagem"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Marvel Shopp - Login</title>
        <link rel="icon" type="imagem/png" href="imagens/deadpoolLogo.png" />
        <link rel="stylesheet" href="css/style.css" />
        <link rel="stylesheet" href="css/form.css" />
    </head>
    <body>
        <% Usuario loginUser = (Usuario)request.getSession().getAttribute("user");%>
        <div id="interface">
            <%@ include file="header.jsp"%>
            
            <section id="corpo"> <!--divisão da pagina. Aqui se inicia o corpo da pagina (seção do meio)-->
                
                <%  List<Personagem> lista = (List<Personagem>)request.getAttribute("lista");
                    for (Personagem personagem: lista){
                %>
                    
                    <div id='personagem'>
                        <a href='/marvelShopp/PagProdutoController?id=<%= personagem.getId() %>'>
                            <img id='imgProduto' src="imagens/<%= personagem.getImagemRef() %>" height="150" width="100"/> <br>
                            <%= personagem.getNomeReal()%> <br>
                            <%= personagem.getIdentidade()%> <br>
                        </a>
                    </div>
                
                <% } %>
                
            </section>
            
            <%@ include file="footer.jsp"%>
        </div>
    </body>
</html>
