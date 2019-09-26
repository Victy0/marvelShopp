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
       <!-- <link rel = "shortcut icon" type = "imagem/x-icon" href = "imagens/favicon.ico"/> -->
        <link rel="stylesheet" href="css/estilo.css" /> 
        <link rel="stylesheet" href="css/form.css" />
    </head>
    <body>
        <div id="interface">
            <%@ include file="header.jsp"%>
            
            <section id="corpo"> <!--divisão da pagina. Aqui se inicia o corpo da pagina (seção do meio)-->
                <form method="post" id="cadUsu" action="" oninput="calc_total();"> <!--tag para criação de formularios-->
                    <fieldset id="usuario"> <!--cria um conjunto de campos-->
                        <legend>Cadastre-se</legend><!--cria o titulo do conjunto de campos-->
                        <h3>Preencha o formulário abaixo</h3>
                        <p><label for="cMail">E-mail: <input type="email" name="tMail" id="cMail" size="20" maxlength="40"placeholder="Email@provedor.com.br"/></label></p>
                        <p><label for="cSenha">Senha: <input type="password" name="tSenha" id="cSenha" size="8" maxlength="8" placeholder="Mínimo de 8 dígitos"/></label></p>
                        <p><label for="cSenha">CPF: <input type="number" name="tSenha" id="cSenha" size="8" maxlength="8" placeholder="Somente números"/></label></p>
                        <p><label for="cNome">Nome: <input type="text" name="tNome" id="cNome" size="10" maxlength="30" placeholder="Nome Completo"/></label></p><!--input: cria um objeto. type="text": cira uma caixa de texto. size: indica o tamanho da caixa, quantos caracteres vao aparecer. maxlength: quantidade maxima de caracteres que serão aceitos. placeholder: dica de qual sera o conteudo da caixa. o label for serve para tornar o nome clicavel-->
                        <p><label for="cNasc">Data de Nascimento: <input type="date" name="tNasc" id="cNasc"/></label></p>
                        <fieldset id="sexo"><!--cria um conjunto de campos-->
                            <p>Sexo</p><!--cria o titulo do conjunto de campos-->
                            <input type="radio" name="tSexo" id="cMasc" checked/><label for="cMasc">Masculino</label><!--lembrar que o name tem que ser igual neste caso. o label for serve para tornar o nome clicavel. checked: deixa o item ja marcado-->
                            <input type="radio" name="tSexo" id="cFem"/><label for="cFem">Feminino</label>
                        </fieldset>
                        <p><label for="cTel">Telefone: <input type="tel" name="tTel" id="cTel" size="20" maxlength="40" placeholder="Somente números"/></label></p> 
                        <input type="checkbox" name="tOferta" id="cOferta"/><label for="cFem">Desejo receber ofertas por e-mail</label>
                    </fieldset> 
                    </br>
                    <input type="submit" value="criar seu cadastro" id="bCad"/><!--cria um botao enviar a partir de uma imagem. Outra opção: <input type="submit" value="enviar"/>-->
                </form>	                      
            </section>
            
            <%@ include file="footer.jsp"%>
        </div>
    </body>
</html>

