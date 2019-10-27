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
        <script src="js/formConfig.js"></script>
    </head>
    <body>
        <% Usuario loginUser = (Usuario)request.getSession().getAttribute("user");%>
        <div id="interface">
            <%@ include file="header.jsp"%>
            
            <section id="corpo"> <!--divisão da pagina. Aqui se inicia o corpo da pagina (seção do meio)-->
                <form method="post" id="cadUsu" action="UsuarioController">
                    <input type="hidden" id="idUser"  name="idUser" value="<%= loginUser.getId() %>">
                    <input type="hidden" id="editar"  name="editar" value="editar">
                    <fieldset id="cadastroUsuario"> <legend>Cadastro de Usuário</legend>
                        <div class="form-group">
                            <label for="nome">Nome</label>
                            <input type="text" class="form-control" name="nome" id="nome" maxlength="50" placeholder="Nome completo" value="<%= loginUser.getNome()%>" required>
                        </div>
                        <div class="form-group">
                            <label for="mail">E-mail</label>
                            <input type="email" class="form-control" name="mail" id="mail" maxlength="50" placeholder="email@dominio.com" value="<%= loginUser.getEmail()%>" required>
                        </div>
                        <div class="form-group">
                            <label for="CPF">CPF</label>
                            <input type="cpf" class="form-control" name="cpf" id="cpf" maxlength="14" placeholder="Somente números" onkeydown="MaskDown(this)" onkeyup="MaskUp(this,'###.###.###-##')" onkeypress="somenteNumeros(event);"  value="<%= loginUser.getCpf()%>" required>
                        </div>
                        <div class="form-group">
                            <label for="sexo">Sexo</label>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="sexo" id="sexo" value="masculino" <% if("masculino".equalsIgnoreCase(loginUser.getSexo())){ out.print(" checked "); } %> required>
                                <label class="form-check-label" for="sexo">Masculino</label>
                            </div>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="sexo" id="sexo" value="feminino" <% if("feminino".equalsIgnoreCase(loginUser.getSexo())){ out.print(" checked "); } %>>
                                <label class="form-check-label" for="sexo">Feminino</label>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="dataNasc">Data de nascimento</label>
                            <input type="text" class="form-control" name="dataNasc" id="dataNasc" maxlength="10" onkeydown="MaskDown(this)" onkeyup="MaskUp(this,'##/##/####')" onkeypress="somenteNumeros(event);" placeholder="dd/MM/aaaa" value="<%= loginUser.getDt_nascimento()%>"  required>
                        </div>
                        <div class="form-group">
                            <label for="senha1">Senha</label>
                            <input type="password" class="form-control" name="senha1" id="senha1" maxlength="10" placeholder="senha" onChange="validatePassword()" value="<%= loginUser.getSenha()%>"  required>
                        </div>
                        <div class="form-group">
                            <label for="senha2">Confirme senha</label>
                            <input type="password" class="form-control" name="senha2" id="senha2" maxlength="10" placeholder="senha" onChange="validatePassword()" value="<%= loginUser.getSenha()%>"   required>
                            <span id="erroSenhas" style="color: red; display: none;">Senhas diferentes!</span>
                        </div>
                        <div class="form-check form-check-inline">
                            <input type="checkbox" class="form-check-input" id="recebeEmail" name="recebeEmail" <% if(loginUser.getRecebeEmail()){ out.print("checked"); } %>>
                            <label class="form-check-label" for="recebeEmail">Desejo receber ofertas por e-mail</label>
                        </div>
                        <div class="form-group">
                            <h5></h5>
                            <button type="submit" class="btn btn-primary" value="criar cadastro" id="enviar">Salvar Alterações</button>
                        </div>
                    </fieldset>
                </form>	                      
            </section>
            
            <%@ include file="footer.jsp"%>
        </div>
    </body>
</html>

