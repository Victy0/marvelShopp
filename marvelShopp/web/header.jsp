<%-- 
    Document   : header
    Created on : 15/09/2019, 21:13:24
    Author     : Victor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <header id="cabecalho">                
        <a href="index.jsp"><img id="logo" src="imagens/logo.PNG"/></a>             
        <nav id="menu">
            <ul type="disk">
                <li><a href="index.jsp">Home</a></li>
                <li><a href="top10.jsp">Top 10</a></li>
                <li><a href="promocao.jsp">Promoção</a></li>
                <li><a href="faleConosco.jsp">Fale Conosco</a></li>
                <li><a href="login.jsp">Login</a></li>
            </ul>
        </nav>
        <nav id="carrinho">
            <form action = "CarrinhoController" id="carrinho">
                <input type="image" src="imagens/carrinhoDeCompras.png" id="carrinho"/>
            </form> 
        </nav>                    
        <form action=" " method="post" id= "busca">			
            <input type="search" id="busca" name="q">
            <button type="submit">Buscar</button>
        </form>
    </header>     
</html>
