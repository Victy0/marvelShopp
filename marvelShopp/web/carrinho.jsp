<%-- 
    Document   : carrinhoDeCompras
    Created on : 22/09/2019, 10:06:21
    Author     : Gleison
--%>

<%@page import="br.com.marvelShopp.model.Carrinho"%>
<%@page import="br.com.marvelShopp.model.Personagem"%>
<%@page import="java.util.List"%>
<%@page import="br.com.marvelShopp.dao.CarrinhoDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Marvel Shopp - Carrinho</title>
        <link rel="icon" type="imagem/png" href="imagens/deadpoolLogo.png" />
       <!-- <link rel = "shortcut icon" type = "imagem/x-icon" href = "imagens/favicon.ico"/> -->
        <link rel="stylesheet" href="css/style.css" /> 
        <script language="javascript" src="js/funcoes_1.js"></script>
    </head>
    
    <body>
        <% Usuario loginUser = (Usuario)request.getSession().getAttribute("user");%>
        <div id="interface">
            <%@ include file="header.jsp"%>
            <section id="carrinho"> <!--divisão da pagina. Aqui se inicia o corpo da pagina (seção do meio)-->
                <h1 id="titulo">Meu Carrinho</h1>
                </br>
                <%
                    CarrinhoDao carrinhoDao = new CarrinhoDao();
                    List<Carrinho> personagem = carrinhoDao.list();
                    for(Carrinho car : personagem){ 
                %>      
                        <div id="item">
                            <img src="imagens/<%= car.getImagemRef() %>" id="imgItem">
                            <h1><%= car.getIdentidade()%></h2>
                            <h3>(<%= car.getNomeReal()%>)</h3>
                            <div id="qtd">
                                <button  onClick="AumentaPerc()">+</button>
                                <input type='text' id="percentage" name="percentage" value="1" readonly="readonly"/>
                                <button onClick="DiminuiPerc()">-</button>
                            </div>
                            <br/>
                            <p>R$ <%= car.getPreco()%></p>
                        </div>
                <%        
                    }            
                %>
                </br>
                </br>
            </section>
            <%@ include file="footer.jsp"%>
        </div>
    </body>
</html>
