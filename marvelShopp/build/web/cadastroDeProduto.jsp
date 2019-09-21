<%-- 
    Document   : cadastroDeProduto
    Created on : 21/09/2019, 11:37:19
    Author     : chris
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/estilo.css" />
        <title>Cadastro de Produto</title>
    </head>
    <body>
        <div id="interface">
            <%@ include file="header.jsp"%>
            
            <section id="corpo"> <!--divisão da pagina. Aqui se inicia o corpo da pagina (seção do meio)-->
                <form method="POST" id="cadastroProduto" action="">
                    <fieldset id="cadastroProduto"> <legend>Cadastro de Produto</legend> <!-- <fieldset> que dizer conjunto de campos -->
                        <p>
                            <label for="iNomeReal">Nome Real</label>
                            <input type="text" name="nNomeReal" id="iNomeReal" size="30" maxlength="50" placeholder="Ex.: Antony Edward 'Tony' Stark">
                        </p>
                        <p>
                            <label for="iIdentidade">Identidade</label>
                            <input type="text" name="nIdentidade" id="iIdentidade" size="30" maxlength="50" placeholder="Ex.: Homem de Ferro">
                        </p>
                        <p>
                            <label for="iCategoria">Categoria</label>
                            <select name="nCategoria" id="iCategoria">
                                <option> </option>
                            </select>
                        </p>
                        <p>
                            <label for="iDescricao">Descrição</label>
                            <textarea name="nDescricao" id="iDescricao" cols="80" rows="10" placeholder="Descrição do Produto" ></textarea>
                        </p>
                        <p>
                            <label for="iPreco">Preço</label>
                            <input type="text" name="nPreco" id="iPreco" size="10" maxlength="10" placeholder="R$ 999,99" />
                        </p>
                        <p>
                            <label for="iOcupacao">Ocupação</label>
                            <select name="nOcupacao" id="iOcupacao">
                                <option> </option>
                            </select>
                        </p>
                        <p>
                            <label>Sexo</label>
                            <select name="nSexo" id="iSexo">
                                <option> </option>
                            </select>
                        </p>
                        <p>
                            <label for="iEstoque">Quantidade inicial em estoque</label>
                            <input type="number" name="nEstoque" id="iEstoque" value="0" min="0" max="1000000000" size="10" maxlength="11" />
                        </p>
                        <p>
                            <label for="iLugar">Local de atuação</label>
                            <input type="Text" name="nLugar" id="iLugar" size="30" maxlength="50" placeholder="Ex.: Nova York"/>
                        </p>
                        <p>
                            <label for="iImagemRef">Referência da imagem do produto</label>
                            <input type="" name="nImagemRef" id="iImagemRef" size="30" maxlength="50" placeholder="Ex.: imagens/produtos/homemDeFerro.jpg">
                        </p>
                        
                        <p>
                            <input type="submit" value="Cadastrar">
                        </p>
                    </fieldset>

                </form>
            </section>
            
            <%@ include file="footer.jsp"%>
        </div>
    </body>
</html>
