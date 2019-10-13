package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import br.com.marvelShopp.model.TipoCategoria;
import br.com.marvelShopp.model.TipoOcupacao;
import java.util.List;
import br.com.marvelShopp.model.TipoSexo;

public final class cadastroDeProduto_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/estilo.css\" />\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/css_bootstrat/bootstrap.min.css\" />\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/form.css\" />\r\n");
      out.write("        <script src=\"js/js_bootstrap/bootstrap.min.js\" />\r\n");
      out.write("        <title>MarvelShopp</title>\r\n");
      out.write("        <link rel=\"icon\" type=\"imagem/png\" href=\"imagens/deadpoolLogo.png\" />\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <div id=\"interface\">\r\n");
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
      out.write("\r\n");
      out.write("            <div class=container\">\r\n");
      out.write("                <div class=\"jumbotron\" style=\"background: #FF4500;\" />\r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("            \r\n");
      out.write("            <section id=\"corpo\"> <!--divisão da pagina. Aqui se inicia o corpo da pagina (seção do meio)-->\r\n");
      out.write("                <form method=\"POST\" id=\"cadastroProduto\" action=\"PersonagemController\">\r\n");
      out.write("                    <fieldset id=\"cadastroProduto\"> <legend>Cadastro de Produto</legend> <!-- <fieldset> que dizer conjunto de campos -->\r\n");
      out.write("                        <p>\r\n");
      out.write("                            <label for=\"nomeReal\">Nome Real</label>\r\n");
      out.write("                            <input type=\"text\" name=\"nomeReal\" id=\"nomeReal\" size=\"30\" maxlength=\"50\" placeholder=\"Ex.: Antony Edward 'Tony' Stark\">\r\n");
      out.write("                        </p>\r\n");
      out.write("                        <p>\r\n");
      out.write("                            <label for=\"identidade\">Identidade</label>\r\n");
      out.write("                            <input type=\"text\" name=\"identidade\" id=\"identidade\" size=\"30\" maxlength=\"50\" placeholder=\"Ex.: Homem de Ferro\">\r\n");
      out.write("                        </p>\r\n");
      out.write("                        <p>\r\n");
      out.write("                            <label for=\"categoria\">Categoria</label>\r\n");
      out.write("                            <select name=\"categoria\" id=\"categoria\">\r\n");
      out.write("                                <option> Selecione... </option>\r\n");
      out.write("                                ");
 List<TipoCategoria> listaCategoria = (List)request.getAttribute("categoriaLista");
                                    for(int i = 0; i < listaCategoria.size(); i++){
                                        out.println("<option value =" + listaCategoria.get(i).getId() + ">" + listaCategoria.get(i).getNome() + "</option>");																
                                    } 
      out.write("\r\n");
      out.write("                            </select>\r\n");
      out.write("                        </p>\r\n");
      out.write("                        <p>\r\n");
      out.write("                            <label for=\"descricao\">Descrição</label>\r\n");
      out.write("                            <textarea name=\"descricao\" id=\"descricao\" cols=\"61\" rows=\"10\" placeholder=\"Descrição do Produto\" ></textarea>\r\n");
      out.write("                        </p>\r\n");
      out.write("                        <p>\r\n");
      out.write("                            <label for=\"preco\">Preço</label>\r\n");
      out.write("                            <input type=\"text\" name=\"preco\" id=\"preco\" size=\"10\" maxlength=\"10\" placeholder=\"R$ 999,99\" />\r\n");
      out.write("                        </p>\r\n");
      out.write("                        <p>\r\n");
      out.write("                            <label for=\"ocupacao\">Ocupação</label>\r\n");
      out.write("                            <select name=\"ocupacao\" id=\"ocupacao\">\r\n");
      out.write("                                <option> Selecione... </option>\r\n");
      out.write("                                ");
 List<TipoOcupacao> listaOcupacao = (List)request.getAttribute("ocupacaoLista");
                                    for(int i = 0; i < listaOcupacao.size(); i++){
                                        out.println("<option value =" + listaOcupacao.get(i).getId() + ">" + listaOcupacao.get(i).getNome() + "</option>");																
                                    } 
      out.write("\r\n");
      out.write("                            </select>\r\n");
      out.write("                        </p>\r\n");
      out.write("                        <p>\r\n");
      out.write("                            <label>Sexo</label>\r\n");
      out.write("                            <select name=\"sexo\" id=\"sexo\">\r\n");
      out.write("                                <option> Selecione... </option>\r\n");
      out.write("                                 ");
 List<TipoSexo> listaSexo = (List)request.getAttribute("sexoLista");
                                    for(int i = 0; i < listaSexo.size(); i++){
                                        out.println("<option value =" + listaSexo.get(i).getId() + ">" + listaSexo.get(i).getNome() + "</option>");																
                                    } 
      out.write("\r\n");
      out.write("                            </select>\r\n");
      out.write("                        </p>\r\n");
      out.write("                        <p>\r\n");
      out.write("                            <label for=\"estoque\">Quantidade inicial em estoque</label>\r\n");
      out.write("                            <input type=\"number\" name=\"estoque\" id=\"estoque\" value=\"0\" min=\"0\" max=\"1000000000\" size=\"10\" maxlength=\"11\" />\r\n");
      out.write("                        </p>\r\n");
      out.write("                        <p>\r\n");
      out.write("                            <label for=\"lugar\">Local de atuação</label>\r\n");
      out.write("                            <input type=\"Text\" name=\"lugar\" id=\"lugar\" size=\"30\" maxlength=\"50\" placeholder=\"Ex.: Nova York\"/>\r\n");
      out.write("                        </p>\r\n");
      out.write("                        <p>\r\n");
      out.write("                            <label for=\"imagemRef\">Referência da imagem do produto</label>\r\n");
      out.write("                            <input type=\"\" name=\"imagemRef\" id=\"imagemRef\" size=\"30\" maxlength=\"50\" placeholder=\"Ex.: imagens/produtos/homemDeFerro.jpg\">\r\n");
      out.write("                        </p>\r\n");
      out.write("                        \r\n");
      out.write("                        <p>\r\n");
      out.write("                            <input type=\"submit\" value=\"Cadastrar\">\r\n");
      out.write("                        </p>\r\n");
      out.write("                    </fieldset>\r\n");
      out.write("\r\n");
      out.write("                </form>\r\n");
      out.write("            </section>\r\n");
      out.write("            \r\n");
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
      out.write("\r\n");
      out.write("        </div>\r\n");
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