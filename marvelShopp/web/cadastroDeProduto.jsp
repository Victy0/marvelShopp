<%-- 
    Document   : cadastroDeProduto
    Created on : 21/09/2019, 11:37:19
    Author     : chris
--%>

<%@page import="br.com.marvelShopp.model.TipoCategoria"%>
<%@page import="br.com.marvelShopp.model.TipoOcupacao"%>
<%@page import="java.util.List"%>
<%@page import="br.com.marvelShopp.model.TipoSexo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/estilo.css" />
        <link rel="stylesheet" href="css/form.css" />
        <title>Cadastro de Produto</title>
    </head>
    <body>
        <div id="interface">
            <%@ include file="header.jsp"%>
            
            <section id="corpo"> <!--divisão da pagina. Aqui se inicia o corpo da pagina (seção do meio)-->
                <form method="POST" id="cadastroProduto" action="">
                    <fieldset id="cadastroProduto"> <legend>Cadastro de Produto</legend> <!-- <fieldset> que dizer conjunto de campos -->
                        <p>
                            <label for="nomeReal">Nome Real</label>
                            <input type="text" name="nNomeReal" id="nomeReal" size="30" maxlength="50" placeholder="Ex.: Antony Edward 'Tony' Stark">
                        </p>
                        <p>
                            <label for="identidade">Identidade</label>
                            <input type="text" name="nIdentidade" id="identidade" size="30" maxlength="50" placeholder="Ex.: Homem de Ferro">
                        </p>
                        <p>
                            <label for="categoria">Categoria</label>
                            <select name="nCategoria" id="categoria">
                                <option> Selecione... </option>
                                <% List<TipoCategoria> listaCategoria = (List)request.getAttribute("categoriaLista");
                                    for(int i = 0; i < listaCategoria.size(); i++){
                                        out.println("<option value =" + listaCategoria.get(i).getId() + ">" + listaCategoria.get(i).getNome() + "</option>");																
                                    } %>
                            </select>
                        </p>
                        <p>
                            <label for="descricao">Descrição</label>
                            <textarea name="nDescricao" id="descricao" cols="61" rows="10" placeholder="Descrição do Produto" ></textarea>
                        </p>
                        <p>
                            <label for="preco">Preço</label>
                            <input type="text" name="nPreco" id="preco" size="10" maxlength="10" placeholder="R$ 999,99" />
                        </p>
                        <p>
                            <label for="ocupacao">Ocupação</label>
                            <select name="nOcupacao" id="ocupacao">
                                <option> Selecione... </option>
                                <% List<TipoOcupacao> listaOcupacao = (List)request.getAttribute("ocupacaoLista");
                                    for(int i = 0; i < listaOcupacao.size(); i++){
                                        out.println("<option value =" + listaOcupacao.get(i).getId() + ">" + listaOcupacao.get(i).getNome() + "</option>");																
                                    } %>
                            </select>
                        </p>
                        <p>
                            <label>Sexo</label>
                            <select name="nSexo" id="sexo">
                                <option> Selecione... </option>
                                 <% List<TipoSexo> listaSexo = (List)request.getAttribute("sexoLista");
                                    for(int i = 0; i < listaSexo.size(); i++){
                                        out.println("<option value =" + listaSexo.get(i).getId() + ">" + listaSexo.get(i).getNome() + "</option>");																
                                    } %>
                            </select>
                        </p>
                        <p>
                            <label for="estoque">Quantidade inicial em estoque</label>
                            <input type="number" name="nEstoque" id="estoque" value="0" min="0" max="1000000000" size="10" maxlength="11" />
                        </p>
                        <p>
                            <label for="lugar">Local de atuação</label>
                            <input type="Text" name="nLugar" id="lugar" size="30" maxlength="50" placeholder="Ex.: Nova York"/>
                        </p>
                        <p>
                            <label for="imagemRef">Referência da imagem do produto</label>
                            <input type="" name="nImagemRef" id="imagemRef" size="30" maxlength="50" placeholder="Ex.: imagens/produtos/homemDeFerro.jpg">
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
