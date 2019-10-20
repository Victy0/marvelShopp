<%-- 
    Document   : listaprodutos
    Created on : 16/10/2019, 20:16:36
    Author     : victo
--%>
<%@page import="java.sql.ResultSet"%>

<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="br.com.marvelShopp.utilitarios.Conexao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="css/style.css" /> 
        <title>JSP Page</title>
    </head>
    <body>
        <div id="interface">
            <%@ include file="header.jsp"%>
            <h1>Lista de produtos</h1>
            
            <%
                int limite=6;
                String numpagina=request.getParameter("numpagina");
                if(numpagina==null){
                numpagina="1";
                }
                int offset=(Integer.parseInt(numpagina)*limite)-limite;
                Connection con=Conexao.getConnection();
                
              
                PreparedStatement ps= con.prepareStatement("select* from personagem LIMIT 6 OFFSET ?");
                ps.setInt(1,offset);
                ResultSet rs=ps.executeQuery();
               out.print("<div class='container'>");
                out.print("<div class='row'>");
                while(rs.next()){
                   
                   out.print("<div class='col-sm-4'>"+"<div class='card' style='width: 18rem;'>"+
  "<img class='card-img-top' src='"+"imagens/"+rs.getString("imagem_ref")+"' width=200px height=200px alt='Card image cap'>"+
 " <div class='card-body'>"+
    "<h5 class='card-title'>"+rs.getString("identidade")+"</h5>"+
    "<p class='card-text'>"+"R$"+rs.getString("preco")+"</p>"+
    "<a href='/marvelShopp/PagProdutoController?id="+rs.getString("id")+"' class='btn btn-primary'>Comprar</a>"+
  "</div>"+
"</div>"+"</div>");
                  
               }
           out.print("</div>"+"</div>");
               //out.println("<a href=listaprodutos.jsp?numpagina=1>1</a>");
               //out.println("<a href=listaprodutos.jsp?numpagina=2>2</a>");
               //out.println("<a href=listaprodutos.jsp?numpagina=3>3</a><br>");
                PreparedStatement psconta= con.prepareStatement("select count(*)AS contaRegistros from personagem ");
                ResultSet rsc=psconta.executeQuery();
                rsc.next();
                int totalderegistros= Integer.parseInt(rsc.getString("contaRegistros"));
                 
                int totalpaginas= totalderegistros/limite;
                if(totalderegistros%limite!=0){
                     totalpaginas++;
                 
                 }
                
             for(int i=1;i<=totalpaginas;i++){
                 out.println("<a href=listaprodutos.jsp?numpagina="+i+">"+i+"</a>");
             }

                
                %>
                
                <br>
                <br>
             <%@ include file="footer.jsp"%>
        </div>
    </body>
</html>
