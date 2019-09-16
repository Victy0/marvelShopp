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
                <li><a href="top10.html">Top 10</a></li>
                <li><a href="promocao.html">Promoção</a></li>
                <li><a href="faleConosco.html">Fale Conosco</a></li>
                <li><a href="login.html">Login</a></li>
            </ul>
        </nav>
        <nav id="carrinho">
            <ul type="disk">
                <li><a href="carrinhoDeCompras.html"><img id="carrinho" src="imagens/carrinhoDeCompras.png"/></a></li>
            </ul>                    
        </nav>    
                
        <form action=" " method="post" id= "busca">			
            <input type="search" id="busca" name="q">
            <button type="submit">Buscar</button>
        </form>
    </header>     
</html>
