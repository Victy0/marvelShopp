package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class faleConosco_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Marvel Shopp - Contato</title>\n");
      out.write("        <link rel=\"icon\" type=\"imagem/png\" href=\"imagens/deadpoolLogo.png\" />\n");
      out.write("       <!-- <link rel = \"shortcut icon\" type = \"imagem/x-icon\" href = \"imagens/favicon.ico\"/> -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/estilo.css\" /> \n");
      out.write("        <link rel=\"stylesheet\" href=\"css/form.css\" />\n");
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
      out.write("            <section id=\"corpo\"> <!--divisão da pagina. Aqui se inicia o corpo da pagina (seção do meio)-->\n");
      out.write("                <form method=\"post\" id=\"contato\" action=\"\" oninput=\"calc_total();\"> <!--tag para criação de formularios-->\n");
      out.write("                    <fieldset id=\"usuario\"> <!--cria um conjunto de campos-->\n");
      out.write("                        <legend>Fale conosco</legend><!--cria o titulo do conjunto de campos-->\n");
      out.write("                        <p><label for=\"cNome\">Nome: <input type=\"text\" name=\"tNome\" id=\"cNome\" size=\"10\" maxlength=\"30\" placeholder=\"Nome Completo\"/></label></p><!--input: cria um objeto. type=\"text\": cira uma caixa de texto. size: indica o tamanho da caixa, quantos caracteres vao aparecer. maxlength: quantidade maxima de caracteres que serão aceitos. placeholder: dica de qual sera o conteudo da caixa. o label for serve para tornar o nome clicavel-->\n");
      out.write("                        <p><label for=\"cSenha\">Senha: <input type=\"number\" name=\"tSenha\" id=\"cSenha\" size=\"8\" maxlength=\"8\" placeholder=\"Somente números\"/></label></p>\n");
      out.write("                        <p><label for=\"cMail\">E-mail: <input type=\"email\" name=\"tMail\" id=\"cMail\" size=\"20\" maxlength=\"40\"placeholder=\"Email@provedor.com.br\"/></label></p>   \n");
      out.write("                        <p><label for=\"cTel\">Telefone: <input type=\"tel\" name=\"tTel\" id=\"cTel\" size=\"20\" maxlength=\"40\" placeholder=\"Somente números\"/></label></p> \n");
      out.write("                        <p><label for=\"cNasc\">Data de Nascimento: <input type=\"date\" name=\"tNasc\" id=\"cNasc\"/></label></p>\n");
      out.write("                        <p><label for=\"cAssunto\">Nome: <input type=\"text\" name=\"tAssunto\" id=\"cAssunto\" size=\"10\" maxlength=\"30\" placeholder=\"Assunto\"/></label></p>\n");
      out.write("                        <p><label for=\"cMsg\">Mensagem: </label><textarea name=\"tMsg\" id=\"cMsg\" cols=\"61\" rows=\"5\" placeholder=\"Deixe aqui sua mensagem\"></textarea></p>\n");
      out.write("                    </fieldset> \n");
      out.write("                    </br>\n");
      out.write("                    <button type=\"submit\" id=\"bMsg\">Eviar</button><!--cria um botao enviar a partir de uma imagem. Outra opção: <input type=\"submit\" value=\"enviar\"/>-->\n");
      out.write("                </form>\t                      \n");
      out.write("            </section>            \n");
      out.write("            ");
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
