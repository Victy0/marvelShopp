<%-- 
    Document   : login
    Created on : 20/09/2019, 13:55:19
    Author     : chris
--%>

<%@page import="org.apache.tomcat.util.http.Cookies"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Marvel Shopp - Login</title>
        <link rel="icon" type="imagem/png" href="imagens/deadpoolLogo.png" />
        <link rel="stylesheet" href="css/style.css" />
        <link rel="stylesheet" href="css/form.css" />
    </head>
    <body>
        <div id="interface">
            <%@ include file="header.jsp"%>
            <%
               Cookie[] cookies = request.getCookies();
               String email="";
               String senha ="";
               if(cookies!=null){
               for(Cookie cookie: cookies){
                if(cookie.getName().equals("email")){
                  
                   email= cookie.getValue();
               }
                 if(cookie.getName().equals("senha")){
                    senha= cookie.getValue();
               } 
               }
               }%>
               
            
            <section id="corpo"> <!--divisão da pagina. Aqui se inicia o corpo da pagina (seção do meio)-->
                <form method="POST" id="login" action="LoginController">
                    <fieldset id="login"> <legend>Login</legend>
                        <%if(request.getAttribute("errorValidate") != null){ %>
                        <span style="color: red; font-size: 15pt;">Usuário ou senha inválido!</span>
                        <%}%>
                        <div class="form-group">
                            <label for="email">E-mail</label>
                            <input type="email" name="email" id="email" class="form-control" value="<%=email%>" placeholder="Email cadastrado" required>
                        </div>
                        <div class="form-group">
                            <label for="senha">Senha</label>
                            <input type="password" name="senha" id="senha" class="form-control" value="<%=senha%>" placeholder="Senha cadastrada" required>
                        </div>
                        <div class="form-group">
                            <input type="submit" class="btn btn-primary btn-lg btn-block" value="Enviar" id="Enviar">
                        </div>
                        <h5>
                            Não é cliente? <a href="cadastroUsuario.jsp">Cadastre-se</a>
                        </h5>
                    </fieldset>

                </form>
            </section>
            
            <%@ include file="footer.jsp"%>
        </div>
    </body>
</html>
