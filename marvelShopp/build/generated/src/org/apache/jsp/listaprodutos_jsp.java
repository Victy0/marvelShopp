package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import br.com.marvelShopp.utilitarios.Conexao;

public final class listaprodutos_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/header.jsp");
    _jspx_dependants.add("/footer.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("         <link rel=\"stylesheet\" href=\"css/estilo.css\" /> \n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"interface\">\n");
      out.write("            ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/css_bootstrap/bootstrap.min.css\" />\r\n");
      out.write("    <header id=\"cabecalho\">                \r\n");
      out.write("        <a href=\"index.jsp\"><img id=\"logo\" src=\"imagens/logo.PNG\"/></a> \r\n");
      out.write("        <nav id=\"menu\">\r\n");
      out.write("            <ul >\r\n");
      out.write("                <li><a href=\"index.jsp\">Home</a></li>\r\n");
      out.write("                <li><a href=\"top10.jsp\">Top 10</a></li>\r\n");
      out.write("                <li><a href=\"promocao.jsp\">Promoção</a></li>\r\n");
      out.write("                <li><a href=\"login.jsp\">Login</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </nav>\r\n");
      out.write("        <nav id=\"carrinho\">\r\n");
      out.write("            <form action = \"CarrinhoController\" id=\"carrinho\">\r\n");
      out.write("                <input type=\"image\" class=\"form-check-label\" src=\"imagens/carrinhoDeCompras.png\" id=\"carrinho\"/>\r\n");
      out.write("            </form> \r\n");
      out.write("        </nav>                    \r\n");
      out.write("        <form action=\" \" method=\"post\" id= \"busca\">\r\n");
      out.write("            <div class=\"form-group row\">\r\n");
      out.write("                <div class=\"col-sm-10\">\r\n");
      out.write("                    <input class=\"form-control\" type=\"search\" id=\"busca\" name=\"q\">\r\n");
      out.write("                </div>\r\n");
      out.write("                <button type=\"submit\" class=\"btn btn-primary\" style=\"background: #000\">Buscar</button>\r\n");
      out.write("            </div>\r\n");
      out.write("        </form>\r\n");
      out.write("    </header>     \r\n");
      out.write("</html>\r\n");
      out.write("\n");
      out.write("            <h1>Lista de produtos</h1>\n");
      out.write("            \n");
      out.write("            ");

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

                
                
      out.write("\n");
      out.write("                \n");
      out.write("                <br>\n");
      out.write("                <br>\n");
      out.write("             ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <footer id=\"rodape\"><!--delimita o rodapé da pagina-->  <!--target=_black faz\\ com que a pagina abra em outra aba-->\t\t\r\n");
      out.write("\t<a href=\"index.jsp\"><img id=\"home\" src=\"imagens/logo.PNG\" /></a>\r\n");
      out.write("                \r\n");
      out.write("        <p id=\"endereco\">Endereço Av. Gal. Milton Tavares de Souza, s/n </br> São Domingos, Niterói - RJ, 24210-310</br>\r\n");
      out.write("        Telefone (21) 2629-2960</br>\r\n");
      out.write("        Copyright © 2019</p>\r\n");
      out.write("        <a href=\"http://facebook.com\" target= \"_black\"><img id=\"facebook\" src=\"imagens/facebook.png\" title=\"Facebook\" /></a>\r\n");
      out.write("        <a href=\"http://instagram.com\" target= \"_black\"><img id=\"instagran\" src=\"imagens/insta.png\" title=\"Instagram\"/></a>\r\n");
      out.write("\t<a href=\"http://twitter.com\" target=\"_black\"><img id=\"twitter\" src=\"imagens/twitter.png\" title=\"Twitter\"/></a>\r\n");
      out.write("        <a href=\"http://web.whatsapp.com/\" target=\"_black\"><img id=\"whatsapp\" src=\"imagens/whatsapp.png\" title=\"Whatsapp\"/></a>\r\n");
      out.write("        <a href=\"http://youtube.com/\" target=\"_black\"><img id=\"youtube\" src=\"imagens/youtube.png\" title=\"Youtube\"/></a>\r\n");
      out.write("    </footer>\r\n");
      out.write("</html>\r\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
