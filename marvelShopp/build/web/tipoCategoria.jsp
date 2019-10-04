<%-- 
    Document   : tiipoCategoria
    Created on : 03/10/2019, 23:44:01
    Author     : Gleison
--%>

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
                <form action="" method="get" id="tipoCat">            
                    <h1>Tipo Categoria</h1>
                    <table>
                        <tr>
                            <td>Tipo Categoria: </td>
                            <td><input type="text" name="tCat" id="tCat"/></td>
                            <td><input type="submit" value="Enviar" id="bCat"/></td>
                        </tr>
                        
                    </table>
                </form>
            </section>
            <%@ include file="footer.jsp"%>
        </div>
    </body>
</html>
