package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import br.com.marvelShopp.model.Comentarios;
import java.util.List;

public final class pagproduto_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/estilo.css\" /> \r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\" /> \r\n");
      out.write("    \r\n");
      out.write("         \r\n");
      out.write("        <title>JSP Page</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <div id=\"interface\">\r\n");
      out.write("             ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <header id=\"cabecalho\">                \r\n");
      out.write("        <a href=\"index.jsp\"><img id=\"logo\" src=\"imagens/logo.PNG\"/></a>             \r\n");
      out.write("        <nav id=\"menu\">\r\n");
      out.write("            <ul type=\"disk\">\r\n");
      out.write("                <li><a href=\"index.jsp\">Home</a></li>\r\n");
      out.write("                <li><a href=\"top10.jsp\">Top 10</a></li>\r\n");
      out.write("                <li><a href=\"promocao.jsp\">Promoção</a></li>\r\n");
      out.write("                <li><a href=\"faleConosco.jsp\">Fale Conosco</a></li>\r\n");
      out.write("                <li><a href=\"login.jsp\">Login</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </nav>\r\n");
      out.write("        <nav id=\"carrinho\">\r\n");
      out.write("            <ul type=\"disk\">\r\n");
      out.write("                <li><a href=\"carrinhoDeCompras.jsp\"><img id=\"carrinho\" src=\"imagens/carrinhoDeCompras.png\"/></a></li>\r\n");
      out.write("            </ul>                    \r\n");
      out.write("        </nav>    \r\n");
      out.write("                \r\n");
      out.write("        <form action=\"BuscaController\" method=\"get\" id= \"busca\">\t\t\t\r\n");
      out.write("            <input type=\"search\" id=\"busca\" name=\"busca\">\r\n");
      out.write("            <button type=\"submit\">Buscar</button>\r\n");
      out.write("        </form>\r\n");
      out.write("    </header>     \r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("             <fieldset class=\"content\">\r\n");
      out.write("          <a href=\"form .html\">  <img src=\"imagens/maxresdefault.jpg\"  width=\"600px\" height=\"400px\" class=\"grid-item\"></a>\r\n");
      out.write("     \r\n");
      out.write("          <div class=\" label\">\r\n");
      out.write("       \r\n");
      out.write("            <h1 > Eva 1</h1>\r\n");
      out.write("            <p> R$ 39,00</p>\r\n");
      out.write("             <button type=\"button\" value=\"Comprar\">Comprar</button>\r\n");
      out.write("          </div>\r\n");
      out.write(" \r\n");
      out.write("          <div class=\"grid-item descri\">\r\n");
      out.write("          <h2 >Descrição</h2><br>\r\n");
      out.write("   \r\n");
      out.write("       <p>Spoiler <br>\r\n");
      out.write("        Ela é a prtaicamente é a mãe do shinji <br>\r\n");
      out.write("         transformada em um eva , absurdo né não<br>\r\n");
      out.write("         imagina sua mâe transformada em uma eva<br>\r\n");
      out.write("         traumatizante</p>\r\n");
      out.write("          </div>\r\n");
      out.write("\r\n");
      out.write("    <div class =\"grid-item ficha\">\r\n");
      out.write("        <p>Nome real: mãe do shinji</p>\r\n");
      out.write("         <p>categoria :robo altão</p>\r\n");
      out.write("         <p> sexo: feminino</p>\r\n");
      out.write("         <p>aiai</p>\r\n");
      out.write("         <p>aiaia</p>\r\n");
      out.write("     </div>\r\n");
      out.write("    \r\n");
      out.write("  \r\n");
      out.write("          \r\n");
      out.write(" \r\n");
      out.write("         <div class=\"comment\">\r\n");
      out.write("     \r\n");
      out.write("         <h2> Avalie </h2> \r\n");
      out.write("         \r\n");
      out.write("          <form method=\"POST\" action='ComentariosController' name=\"frmAddUser\">\r\n");
      out.write("       \r\n");
      out.write("         <textarea  placeholder=\"digite um comentario\" rows=\"10\" cols=\"50\" name=\"descricao\"></textarea>\r\n");
      out.write("         \r\n");
      out.write("     \r\n");
      out.write(" \r\n");
      out.write("             \r\n");
      out.write("         <div class=\"radio\">\r\n");
      out.write("                     <input type=\"radio\"  id=\"star-5\" name=\"nota\" value=\"5\">\r\n");
      out.write("                    <label class=\"labels\" for=\"star-5\">5</label>\r\n");
      out.write("                     \r\n");
      out.write("                    \r\n");
      out.write("                     <input type=\"radio\"  id=\"star-4\" name=\"nota\"value=\"4\">\r\n");
      out.write("                      <label  class=\"labels\" for=\"star-4\">4</label>\r\n");
      out.write("                    \r\n");
      out.write("                    \r\n");
      out.write("                     <input type=\"radio\"  id=\"star-3\" name=\"nota\"value=\"3\">\r\n");
      out.write("                     <label  class=\"labels\" >3</label>\r\n");
      out.write("                     \r\n");
      out.write("                     \r\n");
      out.write("                     <input type=\"radio\" class=\"star star-2\" id=\"star-2\" name=\"nota\"value=\"2\">\r\n");
      out.write("                     \r\n");
      out.write("                      <label  class=\"labels\" >2</label>\r\n");
      out.write("                    \r\n");
      out.write("                     <input type=\"radio\" class=\"star star-1\" id=\"star-1\" name=\"nota\"value=\"1\">\r\n");
      out.write("                      <label  class=\"labels\" >1</label>\r\n");
      out.write("                     </div>\r\n");
      out.write("            <input type=\"submit\" value=\"adicionar\" style=\"width:90px; \" ></input>\r\n");
      out.write("          </form>\r\n");
      out.write("         \r\n");
      out.write("         </div>\r\n");
      out.write("          \r\n");
      out.write("          <h2> Avaliações</h2>\r\n");
      out.write("            \r\n");
      out.write("                  </fieldset>   \r\n");
      out.write("                 \r\n");
      out.write("             \r\n");
      out.write("         </div>    \r\n");
      out.write("      \r\n");
      out.write("      </fieldset>\r\n");
      out.write("       \r\n");
      out.write("     \r\n");
      out.write("       \r\n");
      out.write("       <br>\r\n");
      out.write("        ");
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
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
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
