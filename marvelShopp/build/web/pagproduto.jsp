<%-- 
    Document   : pagproduto
    Created on : 15/09/2019, 22:24:13
    Author     : victo
--%>
<%@page import="br.com.marvelShopp.model.Personagem"%>
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
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" /> 


        <title>JSP Page</title>
    </head>
    <body>
        <% 
            Usuario loginUser = (Usuario)request.getSession().getAttribute("user");
            long idUser = loginUser.getId();
        %>
        <div id="interface">
            <%@ include file="header.jsp"%>
            <div class="container space">
                <div class="row">
                    
                    <div class="col-xs-5 col-md-5 col-lg-5">
                <a href="form .html">  <img src="imagens/<%= request.getAttribute("imagemRef") %>" class="img-fluid" width="100%" height="400px" class="grid-item"></a>
                        </div>
                       
                        
            <div class="col-xs-8 col-md-3 col-lg-5 mrgl ">

                <h1> <%= request.getAttribute("identidade") %> </h1>
                <p> R$<%= request.getAttribute("preco") %> </p>
                
                <form action="/marvelShopp/CarrinhoController" method="POST">
                    <input type="hidden" value="<%= Integer.parseInt(request.getParameter("id"))%>" name="idItem"/>
                    <input type="hidden" value="<%=idUser %>" name="idUser"/>
                    <input type="submit" value="Comprar" style="width:90px; ">
                </form>
                
            </div>
                </div>
                <div class="row">
            <div class="col-xs-5 col-md-11 col-lg-5 descri">
                <h2> Descrição </h2><br>

                <!-- <p> Spoiler <br> -->
                <%= request.getAttribute("descricao") %>
            </div>

            <div class ="col-xs-5 col-md-5 col-lg-5 ficha">
                <h2> Ficha</h2>
                <p>Nome real: <%= request.getAttribute("nomeReal") %>       </p>
                <p>Categoria: <%= request.getAttribute("categoria") %>      </p>
                <p>Sexo: <%= request.getAttribute("sexo") %>                </p>
                <p>Ocupação: <%= request.getAttribute("ocupacao") %>        </p>
                <p>Local de Atuação: <%= request.getAttribute("lugar") %>   </p>
            </div>
                 </div>
            <div class="row">
                <div class="col-xs-5 col-md-5 col-lg-5">
                <h2> Avalie </h2> 

                <form method="POST" action='PagProdutoController' name="frmAddUser">
                    <input type="hidden" id="idPersonagem"  name="idPersonagem" value="<%= request.getAttribute("idPersonagem") %>">

                <textarea  placeholder="digite um comentario" rows="3" cols="20" name="descricao"></textarea>

                <div class="form-check form-check-inline">
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
                </div>
                
                    <input type="submit" value="adicionar" style="width:90px; " >
                </form>
                 </div>
           
                    <div class=" col-xs-5 col-md-5 col-lg-5 space1 ">
            <h2> Avaliações </h2>
                <%  
                    List<Comentarios> listaComentarios = (List<Comentarios>) request.getAttribute("comentList");  
                    for (Comentarios comentario: listaComentarios){
                %>
                
                <div class= 'grid-item ava'>
                    Usuario:<%= comentario.getUsuario().getNome()  %>               <br>
                    Nota: <%= comentario.getNota()%>                                <br>
                    Descrição: <%= comentario.getDescricao()%>                      <br>
                </div>
                
                <% } %> 
                </div>
               
             </div>
        </div>    

        
        <%@ include file="footer.jsp"%>
    </body>
</html>