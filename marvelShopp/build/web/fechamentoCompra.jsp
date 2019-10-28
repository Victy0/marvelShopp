<%-- 
    Document   : fechamentoCompra
    Created on : 27/10/2019, 11:47:42
    Author     : Gleison
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css" />
        <title>Marvel Shopp</title>
        <link rel="icon" type="imagem/png" href="imagens/deadpoolLogo.png" />
    </head>
    <body>
        <div id="interface">
            <%@ include file="header.jsp"%>
            <section id="corpo"> <!--divisão da pagina. Aqui se inicia o corpo da pagina (seção do meio)-->
                <hr>
                <h1 style="text-align: center; font-size: 50pt"  >Parabéns, compra realizada com sucesso</h1> 
                <img id="deadPoolFinal" class="img-rounded" alt="Responsive image" src="imagens/deadPoolFinal.png" width="90%"/>
                <hr>
            </section>
            <%@ include file="footer.jsp"%>
        </div>
    </body>
</html>
