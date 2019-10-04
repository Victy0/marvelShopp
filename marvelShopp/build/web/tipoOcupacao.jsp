<%-- 
    Document   : tipoOcupacao
    Created on : 03/10/2019, 23:33:58
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
                <form action="" method="get" id="tipoOcup">            
                    <h1>Tipo Ocupação</h1>
                    <table>
                        <tr>
                            <td>Tipo Ocupação: </td>
                            <td><input type="text" name="tOcup" id="tOcup"/></td>
                            <td><input type="submit" value="Enviar" id="bOcup"/></td>
                        </tr>
                        
                    </table>
                </form>
            </section>
            <%@ include file="footer.jsp"%>
        </div>
    </body>
</html>
