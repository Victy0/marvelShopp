<%-- 
    Document   : cadastroDeProduto
    Created on : 21/09/2019, 11:37:19
    Author     : chris
--%>

<%@page import="br.com.marvelShopp.dao.TipoCategoriaDao"%>
<%@page import="br.com.marvelShopp.dao.TipoOcupacaoDao"%>
<%@page import="br.com.marvelShopp.dao.TipoSexoDao"%>
<%@page import="br.com.marvelShopp.model.TipoCategoria"%>
<%@page import="br.com.marvelShopp.model.TipoOcupacao"%>
<%@page import="java.util.List"%>
<%@page import="br.com.marvelShopp.model.TipoSexo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css" />
        <link rel="stylesheet" href="css/css_bootstrap/bootstrap.min.css" />
        <link rel="stylesheet" href="css/form.css" />
        <script src="js/js_bootstrap/bootstrap.min.js"></script>
        <title>MarvelShopp</title>
        <link rel="icon" type="imagem/png" href="imagens/deadpoolLogo.png" />
    </head>
    <body>
        <% Usuario loginUser = (Usuario)request.getSession().getAttribute("user");%>
        <%  TipoSexoDao sexoDao=new TipoSexoDao();
            TipoOcupacaoDao ocupacaoDao=new TipoOcupacaoDao();
            TipoCategoriaDao categoriaDao=new TipoCategoriaDao(); %>
        <div id="interface">
            <%@ include file="header.jsp"%>
            <section id="corpo"> <!--divisão da pagina. Aqui se inicia o corpo da pagina (seção do meio)-->
                <form method="POST" id="cadastroProduto" action="PersonagemController">
                    <fieldset id="cadastroProduto"> <legend>Cadastro de Personagem</legend>
                        <div class="form-group">
                            <label for="nomeReal">Nome Real</label>
                            <input type="text" class="form-control" name="nomeReal" id="nomeReal" maxlength="50" placeholder="Ex.: Antony Edward Stark">
                        </div>
                        <div class="form-group">
                            <label for="identidade">Identidade</label>
                            <input type="text" class="form-control" name="identidade" id="identidade" size="30" maxlength="50" placeholder="Ex.: Homem de Ferro">
                        </div>
                        <div class="form-group">
                            <label for="categoria">Categoria</label>
                            <select class="form-control" name="categoria" id="categoria">
                                <option> Selecione... </option>
                                <% List<TipoCategoria> listaCategoria = categoriaDao.list();
                                    for(int i = 0; i < listaCategoria.size(); i++){
                                        out.println("<option value =" + listaCategoria.get(i).getId() + ">" + listaCategoria.get(i).getNome() + "</option>");																
                                    } %>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="ocupacao">Ocupação</label>
                            <select class="form-control" name="ocupacao" id="ocupacao">
                                <option> Selecione... </option>
                                <% List<TipoOcupacao> listaOcupacao = ocupacaoDao.list();
                                    for(int i = 0; i < listaOcupacao.size(); i++){
                                        out.println("<option value =" + listaOcupacao.get(i).getId() + ">" + listaOcupacao.get(i).getNome() + "</option>");																
                                    } %>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Sexo</label>
                            <select class="form-control" name="sexo" id="sexo">
                                <option> Selecione... </option>
                                 <% List<TipoSexo> listaSexo = sexoDao.list();
                                    for(int i = 0; i < listaSexo.size(); i++){
                                        out.println("<option value =" + listaSexo.get(i).getId() + ">" + listaSexo.get(i).getNome() + "</option>");																
                                    } %>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="preco">Preço</label>
                            <input type="text" class="form-control" name="preco" id="preco" size="10" maxlength="10" placeholder="Ex.: 999,99" />
                        </div>
                        <div class="form-group">
                            <label for="estoque">Quantidade em estoque</label>
                            <input type="number" class="form-control" name="estoque" id="estoque" value="0" min="0" max="1000000000" size="10" maxlength="11" />
                        </div>
                        <div class="form-group">
                            <label for="descricao">Descrição</label>
                            <textarea class="form-control" name="descricao" id="descricao" cols="61" rows="10" placeholder="Descrição do Produto" ></textarea>
                        </div>
                        <div class="form-group">
                            <label for="lugar">Local de atuação</label>
                            <input type="Text"class="form-control" name="lugar" id="lugar" size="30" maxlength="50" placeholder="Ex.: Nova York"/>
                        </div>
                        <div class="form-group">
                            <label for="imagemRef">Referência da imagem do personagem</label>
                            <input type="text" class="form-control"name="imagemRef" id="imagemRef" size="30" maxlength="50" placeholder="Ex.: homemDeFerro.jpg">
                        </div>
                        
                        <div class="form-group">
                            <button type="submit" class="btn btn-primary" value="Cadastrar">Cadastrar</button>
                        </div>
                    </fieldset>

                </form>
            </section>
            
            <%@ include file="footer.jsp"%>
        </div>
    </body>
</html>
