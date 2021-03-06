<%-- 
    Document   : listaadmin
    Created on : 26/10/2019, 18:01:34
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
        <title>lista produtos admin</title>
         <link rel="icon" type="imagem/png" href="imagens/deadpoolLogo.png" />
    </head>
    <body>
        <div id="interface">
            <%@ include file="header.jsp"%>
            <h1>Lista de produtos admin</h1>

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
                out.print("<div class='container' style='width: 85%;'>");
                out.print("<div class='row'>");
                while(rs.next()){
                   
                   out.print("<div class='col-sm-4'>"+"<div class='card spacecard' style='width: 18rem;'>"+
                        "<img class='card-img-top' src='"+"imagens/"+rs.getString("imagem_ref")+"' width=150px height=230px alt='Card image cap'>"+
                        " <div class='card-body'>"+
                        "<h5 class='card-title'>"+rs.getString("identidade")+"</h5>"+
                        "<p class='card-text'>"+"R$"+rs.getString("preco")+"</p>"+
                        "<a href='/marvelShopp/editarProduto.jsp?idPersonagem="+rs.getString("id")+"' class='btn btn-primary spacebt'>Editar</a>"+
                         "<a href='/marvelShopp/EditarPersonagemController?id="+rs.getString("id")+"' class='btn btn-danger'>Deletar</a>"+    
                        "</div><br>"+
                        "</div></div>");
                  
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
                
              
               out.print( "<nav aria-label='Page navigation example' align='center'><ul class='pagination'>");
             for(int j=1;j<=totalpaginas;j++){
              
             out.println("<li class='page-item'><a class='page-link' href='listaadmin.jsp?numpagina="+j+"'>"+j+"</a></li>");
}
    
    
           out.print ("</ul></nav>");
              
                
                %>

                <br>
                <br>
             <%@ include file="footer.jsp"%>
        </div>
    </body>
</html>