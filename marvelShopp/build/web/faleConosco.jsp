<%-- 
    Document   : faleConosco
    Created on : 22/09/2019, 10:07:05
    Author     : Gleison
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Marvel Shopp - Contato</title>
        <link rel="icon" type="imagem/png" href="imagens/deadpoolLogo.png" />
       <!-- <link rel = "shortcut icon" type = "imagem/x-icon" href = "imagens/favicon.ico"/> -->
        <link rel="stylesheet" href="css/estilo.css" /> 
        <link rel="stylesheet" href="css/form.css" />
    </head>
    <body>
        <div id="interface">
            <%@ include file="header.jsp"%>
            
            <section id="corpo"> <!--divisão da pagina. Aqui se inicia o corpo da pagina (seção do meio)-->
                <form method="post" id="contato" action="" oninput="calc_total();"> <!--tag para criação de formularios-->
                    <fieldset id="usuario"> <!--cria um conjunto de campos-->
                        <legend>Fale conosco</legend><!--cria o titulo do conjunto de campos-->
                        <p><label for="cNome">Nome: <input type="text" name="tNome" id="cNome" size="10" maxlength="30" placeholder="Nome Completo"/></label></p><!--input: cria um objeto. type="text": cira uma caixa de texto. size: indica o tamanho da caixa, quantos caracteres vao aparecer. maxlength: quantidade maxima de caracteres que serão aceitos. placeholder: dica de qual sera o conteudo da caixa. o label for serve para tornar o nome clicavel-->
                        <p><label for="cSenha">CPF: <input type="number" name="tSenha" id="cSenha" size="8" maxlength="8" placeholder="Somente números"/></label></p>
                        <p><label for="cMail">E-mail: <input type="email" name="tMail" id="cMail" size="20" maxlength="40"placeholder="Email@provedor.com.br"/></label></p>   
                        <p><label for="cTel">Telefone: <input type="tel" name="tTel" id="cTel" size="20" maxlength="40" placeholder="Somente números"/></label></p> 
                        <p><label for="cNasc">Data de Nascimento: <input type="date" name="tNasc" id="cNasc"/></label></p>
                        <p><label for="cAssunto">Assunto: <input type="text" name="tAssunto" id="cAssunto" size="10" maxlength="30" placeholder="Assunto"/></label></p>
                        <p><label for="cMsg">Mensagem: </label><textarea name="tMsg" id="cMsg" cols="61" rows="5" placeholder="Deixe aqui sua mensagem"></textarea></p>
                    </fieldset> 
                    </br>
                    <input type="submit" value="enviar" id="bMsg"/><!--cria um botao enviar a partir de uma imagem. Outra opção: <input type="submit" value="enviar"/>-->
                </form>	                      
            </section>            
            <%@ include file="footer.jsp"%>
        </div>
    </body>
</html>
