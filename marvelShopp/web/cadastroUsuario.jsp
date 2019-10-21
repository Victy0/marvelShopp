<%-- 
    Document   : cadastroUsuario
    Created on : 22/09/2019, 10:08:34
    Author     : Gleison
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Marvel Shopp - Cadastro</title>
        <link rel="icon" type="imagem/png" href="imagens/deadpoolLogo.png" /> 
        <link rel="stylesheet" href="css/css_bootstrap/bootstrap.min.css" />
        <link rel="stylesheet" href="css/form.css" />
        <script src="js/js_bootstrap/bootstrap.min.js"></script>
    </head>
    <body>
        <% Usuario loginUser = (Usuario)request.getSession().getAttribute("user");%>
        <div id="interface">
            <%@ include file="header.jsp"%>
            
            <section id="corpo"> <!--divisão da pagina. Aqui se inicia o corpo da pagina (seção do meio)-->
                <form method="post" id="cadUsu" action="UsuarioController" oninput="calc_total();"> <!--tag para criação de formularios-->
                    <fieldset id="cadastroUsuario"> <legend>Cadastro de Usuário</legend>
                        <div class="form-group">
                            <label for="nome">Nome</label>
                            <input type="text" class="form-control" name="nome" id="nome" maxlength="50" placeholder="Nome completo">
                        </div>
                        <div class="form-group">
                            <label for="mail">E-mail</label>
                            <input type="email" class="form-control" name="mail" id="mail" maxlength="50" placeholder="email@provedor.com.br">
                        </div>
                        <div class="form-group">
                            <label for="CPF">CPF</label>
                            <input type="cpf" class="form-control" name="cpf" id="cpf" maxlength="11" placeholder="Somente números">
                        </div>
                        <div class="form-group">
                            <label for="sexo">Sexo</label>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="sexo" id="sexo" value="masculino">
                                <label class="form-check-label" for="sexo">Masculino</label>
                            </div>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="sexo" id="sexo" value="feminino">
                                <label class="form-check-label" for="sexo">Feminino</label>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="dataNasc">Data de nascimento</label>
                            <input type="text" class="form-control" name="dataNasc" id="dataNasc" maxlength="50" placeholder="dd/MM/aaaa">
                        </div>
                        <div class="form-group">
                            <label for="senha1">Senha</label>
                            <input type="password" class="form-control" name="senha1" id="senha1" maxlength="50" placeholder="senha">
                        </div>
                        <div class="form-group">
                            <label for="dataNasc">Confirme senha</label>
                            <input type="password" class="form-control" name="senha2" id="senha2" maxlength="50" placeholder="senha">
                        </div>
                        <div class="form-check form-check-inline">
                            <input type="checkbox" class="form-check-input" id="recebeEmail" name="recebeEmail">
                            <label class="form-check-label" for="recebeEmail">Desejo receber ofertas por e-mail</label>
                        </div>
                        <div class="form-group">
                            <button type="submit" class="btn btn-primary" value="criar cadastro" id="enviar">Criar cadastro</button>
                        </div>
                    </fieldset>
                </form>	                      
            </section>
            
            <%@ include file="footer.jsp"%>
        </div>
    </body>
</html>

