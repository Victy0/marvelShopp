<%-- 
    Document   : login
    Created on : 20/09/2019, 13:55:19
    Author     : chris
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Marvel Shopp - Login</title>
        <link rel="stylesheet" href="css/estilo.css" />
        <link rel="stylesheet" href="css/form.css" />
    </head>
    <body>
        <div id="interface">
            <%@ include file="header.jsp"%>
            
            <section id="corpo"> <!--divisão da pagina. Aqui se inicia o corpo da pagina (seção do meio)-->
                <form method="POST" id="login" action="">
                    <fieldset id="login"> <legend>Login</legend>
                        <p>
                            <label for="iCpf">CPF</label>
                            <input type="text" name="nCpf" id="iCpf" size="15" maxlength="11" placeholder="Somente números" pattern="[0-9]{11}">
                        </p>
                        <p>
                            <label for="iSenha">Senha</label>
                            <input type="password" name="nSenha" id="iSenha" size="15" maxlength="20" placeholder="Digite sua senha">
                        </p>
                        <p>
                            <input type="submit" value="Entrar" id="bEntrar">
                        </p>
                        <p>
                            Não é cliente? <a href="cadastroUsuario.jsp">Cadastre-se</a>
                        </p>
                    </fieldset>

                </form>
            </section>
            
            <%@ include file="footer.jsp"%>
        </div>
    </body>
</html>
