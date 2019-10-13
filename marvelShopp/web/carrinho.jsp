<%-- 
    Document   : carrinhoDeCompras
    Created on : 22/09/2019, 10:06:21
    Author     : Gleison
--%>

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
        <link rel="stylesheet" href="css/estilo.css" /> 
        <script language="javascript" src="js/funcoes.js"></script>
    </head>
    
    <body>
        <div id="interface">
            <%@ include file="header.jsp"%>
            <section id="carrinho"> <!--divisão da pagina. Aqui se inicia o corpo da pagina (seção do meio)-->
                <h1 id="titulo">Meu Carrinho</h1>
                </br>
                <%
                    CarrinhoDao carrinho = new CarrinhoDao();
                    List<Personagem> personagem = carrinho.list();
                    for(Personagem pers : personagem){ 
                %>      
                        <div id="item">
                            <img src="<%= pers.getImagemRef()%>" id="imgItem">
                            <h1><%= pers.getIdentidade()%></h2>
                            <h3>(<%= pers.getNomeReal()%>)</h3>
                            <form id="qtd">
                                <button  onClick="AumentaPerc()">+</button>
                                <input type='text' id="percentual" name="percentual" value="1" readonly="readonly"/>
                                <button onClick="DiminuiPerc()">-</button>
                            </form>
                            <br/>
                            <p>R$ <%= pers.getPreco()%></p>
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
