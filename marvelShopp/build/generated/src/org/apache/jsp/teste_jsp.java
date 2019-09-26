package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class teste_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/header.jsp");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Marvel Shopp</title>\n");
      out.write("        <link rel=\"icon\" type=\"imagem/png\" href=\"imagens/deadpoolLogo.png\" />\n");
      out.write("       <!-- <link rel = \"shortcut icon\" type = \"imagem/x-icon\" href = \"imagens/favicon.ico\"/> -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/header.css\" /> \n");
      out.write("        <link rel=\"stylesheet\" href=\"css/corpo-footer.css\" /> \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"interface\">\n");
      out.write("            ");
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
      out.write("        <form action=\" \" method=\"post\" id= \"busca\">\t\t\t\r\n");
      out.write("            <input type=\"search\" id=\"busca\" name=\"q\">\r\n");
      out.write("            <button type=\"submit\">Buscar</button>\r\n");
      out.write("        </form>\r\n");
      out.write("    </header>     \r\n");
      out.write("</html>\r\n");
      out.write("\n");
      out.write("            \n");
      out.write("           \n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
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
