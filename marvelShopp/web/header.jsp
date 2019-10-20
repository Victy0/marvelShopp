<%-- 
    Document   : header
    Created on : 15/09/2019, 21:13:24
    Author     : Victor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <link rel="stylesheet" href="css/style.css" />
    <link rel="stylesheet" href="css/css_bootstrap/bootstrap.min.css" />
    <header id="cabecalho">                
        <a href="index.jsp"><img id="logo" src="imagens/logo.PNG"/></a> 
        <nav id="menu">
            <ul >
                <li><a href="index.jsp">Home</a></li>
                <li><a href="top10.jsp">Top 10</a></li>
                <li><a href="promocao.jsp">Promoção</a></li>
                <li><a href="login.jsp">Login</a></li>
            </ul>
            <form  action="BuscaController" method="GET" id= "busca">
                <div class="form-group row">
                    <div class="col-sm-10">
                        <input class="form-control" type="search" id="busca" name="busca">
                    </div>
                    <button type="submit" class="btn btn-primary" style="background: #000">Buscar</button>
                </div>
            </form>
            <a href='/marvelShopp/CarrinhoController'>
                <img id='carrinho' class="carrinho-img" src="imagens/carrinhoDeCompras.png" title="Carrinho" width="10%"/>
            </a> 
        </nav>
                           
        
    </header>     
</html>
