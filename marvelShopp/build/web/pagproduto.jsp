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
        <link rel="stylesheet" href="css/estilo.css" /> 
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" /> 
    
         
        <title>JSP Page</title>
    </head>
    <body>
        <div id="interface">
             <%@ include file="header.jsp"%>
             <fieldset class="content">
          <a href="form .html">  <img src="imagens/maxresdefault.jpg"  width="600px" height="400px" class="grid-item"></a>
     
          <div class=" label">
       
            <h1 > Eva 1</h1>
            <p> R$ 39,00</p>
             <button type="button" value="Comprar">Comprar</button>
          </div>
 
          <div class="grid-item descri">
          <h2 >Descrição</h2><br>
   
       <p>Spoiler <br>
        Ela é a prtaicamente é a mãe do shinji <br>
         transformada em um eva , absurdo né não<br>
         imagina sua mâe transformada em uma eva<br>
         traumatizante</p>
          </div>

    <div class ="grid-item ficha">
        <p>Nome real: mãe do shinji</p>
         <p>categoria :robo altão</p>
         <p> sexo: feminino</p>
         <p>aiai</p>
         <p>aiaia</p>
     </div>
    
  
          
 
         <div class="comment">
     
         <h2> Avalie </h2> 
         
          <form method="POST" action='ComentariosController' name="frmAddUser">
       
         <textarea  placeholder="digite um comentario" rows="10" cols="50" name="descricao"></textarea>
         
     
 
             
         <div class="radio">
                     <input type="radio"  id="star-5" name="nota" value="5">
                    <label class="labels" for="star-5">5</label>
                     
                    
                     <input type="radio"  id="star-4" name="nota"value="4">
                      <label  class="labels" for="star-4">4</label>
                    
                    
                     <input type="radio"  id="star-3" name="nota"value="3">
                     <label  class="labels" ></label>
                     
                     
                     <input type="radio" class="star star-2" id="star-2" name="nota"value="2">
                     
                      <label  class="labels" >2</label>
                    
                     <input type="radio" class="star star-1" id="star-1" name="nota"value="1">
                      <label  class="labels" >1</label>
                     </div>
            <input type="submit" value="adicionar" style="width:90px; " ></input>
          </form>
         
         </div>
          
          <h2> Avaliações</h2>
           <%  
                        List<Comentarios> coment = (List<Comentarios>) request.getAttribute("comentList");  
                        for (int i = 0; i < coment.size(); i++) {  
                           out.println("<div class= 'grid-item ava'>");
                            out.println("Usuario :"+coment.get(i).getUsuario() + "<br>");
                             out.println("Personagem :"+coment.get(i).getPersonagem() + "<br>");
                              out.println("Nota:"+coment.get(i).getNota() + "<br>");
                               out.println("Descrição:"+coment.get(i).getDescricao() + "<br>");
                               out.println("</div>");
                        }  
                    %>   
                  </fieldset>   
                 
             
         </div>    
      
      </fieldset>
       
     
       
       <br>
        <%@ include file="footer.jsp"%>
    </body>
</html>
