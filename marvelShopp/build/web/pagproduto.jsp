<%-- 
    Document   : pagproduto
    Created on : 15/09/2019, 22:24:13
    Author     : victo
--%>

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
        <% Usuario loginUser = (Usuario)request.getSession().getAttribute("user");%>
        <div id="interface">
            <%@ include file="header.jsp"%>
            <fieldset class="content">
                <a href="form .html">  <img src="imagens/<%= request.getAttribute("imagemRef") %>"  width="600px" height="400px" class="grid-item"></a>

            <div class=" label name">

                <h1> <%= request.getAttribute("identidade") %> </h1>
                <p> R$<%= request.getAttribute("preco") %> </p>
                
                <form action="/marvelShopp/CarrinhoController" method="GET">
                    <input type="submit" value="Comprar" style="width:90px; ">
                </form>
                
            </div>

            <div class="grid-item descri">
                <h2> Descrição </h2><br>

                <!-- <p> Spoiler <br> -->
                <%= request.getAttribute("descricao") %>
            </div>

            <div class ="grid-item ficha">
                <p>Nome real: <%= request.getAttribute("nomeReal") %>       </p>
                <p>Categoria: <%= request.getAttribute("categoria") %>      </p>
                <p>Sexo: <%= request.getAttribute("sexo") %>                </p>
                <p>Ocupação: <%= request.getAttribute("ocupacao") %>        </p>
                <p>Local de Atuação: <%= request.getAttribute("lugar") %>   </p>
            </div>

            <div class="comment">

                <h2> Avalie </h2> 

                <form method="POST" action='PagProdutoController' name="frmAddUser">
                    <input type="hidden" id="idPersonagem" name="idPersonagem" value="<%= request.getAttribute("idPersonagem") %>">

                <textarea  placeholder="digite um comentario" rows="10" cols="50" name="descricao"></textarea>

                <div class="radio">
                    <input type="radio" id="star-5" name="nota" value="5">
                    <label class="labels" for="star-5">5</label>

                    <input type="radio" id="star-4" name="nota" value="4">
                    <label class="labels" for="star-4">4</label>

                    <input type="radio" id="star-3" name="nota" value="3">
                    <label class="labels" for="star3">3</label>

                    <input type="radio" class="star star-2" id="star-2" name="nota" value="2">
                    <label class="labels" for="star2">2</label>

                    <input type="radio" class="star star-1" id="star-1" name="nota" value="1">
                    <label class="labels" for="star1">1</label>
                </div>
                
                    <input type="submit" value="adicionar" style="width:90px; " >
                </form>

            </div>

            <h2> Avaliações </h2>
                <%  
                    List<Comentarios> listaComentarios = (List<Comentarios>) request.getAttribute("comentList");  
                    for (Comentarios comentario: listaComentarios){
                %>
                
                <div class= 'grid-item ava'>
                    <div> Usuário: <%= comentario.getUsuario().getNome() %>     </div> 
                    <div> Nota: <%= comentario.getNota()%>                      </div>
                    <div> Descrição: <%= comentario.getDescricao()%>            </div>
                </div>
                
                <% } %>   
            </fieldset>   

        </div>    

        
        <%@ include file="footer.jsp"%>
    </body>
</html>