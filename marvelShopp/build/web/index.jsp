<%-- 
    Document   : index
    Created on : 15/09/2019, 16:05:19
    Author     : Victor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
    
<!DOCTYPE html>

<html>
    <head>
        <title>Marvel Shopp</title>
        <link rel="icon" type="imagem/png" href="imagens/deadpoolLogo.png" />
       <!-- <link rel = "shortcut icon" type = "imagem/x-icon" href = "imagens/favicon.ico"/> -->
        <link rel="stylesheet" href="css/estilo.css" /> 
    </head>
    <body>
        <div id="interface">
            <%@ include file="header.jsp"%>
            
            <section id="corpo"> <!--divisão da pagina. Aqui se inicia o corpo da pagina (seção do meio)-->
                <header id="propaganda">
                    <h2><p>TOP 10</p></h2>		
                    <h2><p>Promoções</p></h2>		
                    <h2><p>+ vendidos</p></h2>				
                </header>
            </section>
            
            <%@ include file="footer.jsp"%>
        </div>
    </body>
</html>
