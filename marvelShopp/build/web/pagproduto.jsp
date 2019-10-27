<%-- 
    Document   : pagproduto
    Created on : 15/09/2019, 22:24:13
    Author     : victo
--%>
<%@page import="br.com.marvelShopp.model.*"%>
<%@page import="br.com.marvelShopp.model.Carrinho"%>
<%@page import="br.com.marvelShopp.model.Usuario"%>
<%@page import="br.com.marvelShopp.model.Comentarios"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css" />  
        <title>Marvel Shopp</title>
        <link rel="icon" type="imagem/png" href="imagens/deadpoolLogo.png" />
    </head>
    <body>
        <% 
            Usuario loginUser = (Usuario)request.getSession().getAttribute("user");
            Personagem personagem = (Personagem)request.getAttribute("personagem"); 
            String lugar = personagem.getLugar();
            if(lugar == null){
                lugar = "Universo Marvel";
            }
        %>
        <div id="interface">
            <%@ include file="header.jsp"%>
                <h1 style="font-size: 40pt"> <%= personagem.getIdentidade()%> </h1>
                <div class="row">
                    <div class="col-xs-5 col-md-5 col-lg-5">
                        <a href="form.html" style="margin-left: 15px;"><img src="imagens/<%= personagem.getImagemRef() %>" class="img-fluid img-rounded" width="100%"></a>
                    </div>
                    <div class="col-xs-8 col-md-3 col-lg-5 mrgl" vertical-align="center">
                        <h2> Ficha</h2>
                        <p style="font-size: 15pt;">Nome real: <%= personagem.getNomeReal() %>       </p>
                        <p style="font-size: 15pt;">Categoria: <%= personagem.getCategoria().getNome() %>      </p>
                        <p style="font-size: 15pt;">Sexo: <%= personagem.getSexo().getNome() %>                </p>
                        <p style="font-size: 15pt;">Ocupação: <%= personagem.getOcupacao().getNome() %>        </p>
                        <p style="font-size: 15pt;">Local de Atuação: <%= lugar %>   </p>
                        <%  Integer qtd = personagem.getQtdEstoque();
                            if( qtd == 0){%>
                                <p style="color:red;"> Personagem indisponível</p>
                            <%}else{%>
                            <p style="font-size: 15pt;"> R$<%= personagem.getPreco() %> </p>
                                <form action="/marvelShopp/CarrinhoController" method="POST">
                                    <input type="hidden" value="create" name="funcao"/>
                                    <input type="hidden" value="<%= personagem.getId()%>" name="idPersonagem"/>
                                    <input type="submit" class="btn btn-primary" value="Comprar" style="width:90px; ">
                                    <%}
                            if(loginUser != null){ 
                                    if(loginUser.hasThisFavorito(personagem.getId())){%>
                                <a href='/marvelShopp/UsuarioController?acao=remove&idPersonagem=<%=personagem.getId()%>'>
                                    <input type='button' class='btn btn-primary' value='Remover dos favoritos' style='width:200px; background: orange; color:black'></a>
                               <% }else{%>
                                    <a href='/marvelShopp/UsuarioController?acao=add&idPersonagem=<%=personagem.getId()%>'>
                                    <input type='button' class='btn btn-primary' value='Adicionar aos favoritos' style='width:200px; background: yellowgreen; color:black'></a>
                                <%}
                            }%>
                                </form>
                                <br>
                            
                    </div>
                </div>
                <br>
                <div class="row" align="center">
                    <div class="descri" >
                        <h2> Descrição </h2><br>
                        <!-- <p> Spoiler <br> -->
                        <p><%= personagem.getDescricao() %></p>
                        <br>
                    </div>
                </div>
                <hr>
<!--//            <div class ="col-xs-5 col-md-5 col-lg-5 ficha">    
//            </div>-->
            <div class="row">
                <div class="col-xs-5 col-md-5 col-lg-5">
                    <h2 align="center"> Avalie </h2> 
                    <% if(loginUser != null){ %>
                    <form method="POST" action='PagProdutoController' name="frmAddUser">
                        <input type="hidden" id="idPersonagem"  name="idPersonagem" value="<%= personagem.getId() %>">
                        <div class="form-check form-check-inline">
                            <label style="font-size: 10pt">Nota:</label>
                            <input class="for-check-input" type="radio" id="star-5" name="nota" value="5">
                            <label class="form-check-label" for="star-5">5</label>

                            <input class="form-check-input" type="radio" id="star-4" name="nota" value="4">
                            <label class="form-check-label" for="star-4">4</label>

                            <input class="form-check-input" type="radio" id="star-3" name="nota" value="3">
                            <label class="form-check-label" for="star3">3</label>

                            <input type="radio" class="form-check-input" id="star-2" name="nota" value="2">
                            <label class="form-check-label" for="star2">2</label>

                            <input type="radio" class="form-check-input" id="star-1" name="nota" value="1">
                            <label class="form-check-label" for="star1">1</label>
                            
                            <textarea  placeholder="Digite um comentario" name="descricao" style="width: 100%; height: 70%;"></textarea>

                        </div>

                        <input type="submit" class="btn btn-primary" value="adicionar" style="width:90px;" align="center">
                    </form>
                    <%}else{%>
                        <h2 align="center" style="color: red;"> Faça login para poder Avaliar</h2> 
                    <%}%>
                 </div>
           
                <div class=" col-xs-5 col-md-5 col-lg-5 space1 ">
                    <h2> Avaliações </h2>
                    <%  
                    List<Comentarios> listaComentarios = (List<Comentarios>) request.getAttribute("comentList");  
                    for (Comentarios comentario: listaComentarios){
                    %>
                    <hr>
                        <p><strong><%= comentario.getUsuario().getNome()  %></strong> - Nota: <%= comentario.getNota()%></p>
                        <p style="margin-left: 15px;"><%= comentario.getDescricao()%><p>       
                    <hr>
                    <% } %> 
                </div>
               
            </div>
            <hr>
            <%@ include file="footer.jsp"%>
        </div> 
    </body>
</html>