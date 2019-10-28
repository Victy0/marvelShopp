package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import br.com.marvelShopp.model.Usuario;

public final class fechamentoCompra_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\" />\r\n");
      out.write("        <title>Marvel Shopp</title>\r\n");
      out.write("        <link rel=\"icon\" type=\"imagem/png\" href=\"imagens/deadpoolLogo.png\" />\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <div id=\"interface\">\r\n");
      out.write("            ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/style.css\" />\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/css_bootstrap/bootstrap.min.css\" />\r\n");
      out.write("    ");
 Usuario login = (Usuario)request.getSession().getAttribute("user");
      out.write("\r\n");
      out.write("    <header id=\"cabecalho\">                \r\n");
      out.write("        <a href=\"index.jsp\"><img id=\"logo\" src=\"imagens/logo.PNG\"/></a> \r\n");
      out.write("        <nav id=\"menu\">\r\n");
      out.write("            <ul >\r\n");
      out.write("                <li><a href=\"index.jsp\">Home</a></li>\r\n");
      out.write("                <li><a href=\"#\">Produtos</a>\r\n");
      out.write("                    <ul>\r\n");
      out.write("                        <li><a href=\"#\">Ocupação</a>\r\n");
      out.write("                            <ul>\r\n");
      out.write("                                <li><a href=\"/marvelShopp/BuscaController?busca=heroi\">Herói</a></li>\r\n");
      out.write("                                <li><a href=\"/marvelShopp/BuscaController?busca=anti-heroi\">Anti-Herói</a></li>\r\n");
      out.write("                                <li><a href=\"/marvelShopp/BuscaController?busca=vilao\">Vilão</a></li>\r\n");
      out.write("                            </ul>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li><a href=\"#\">Categoria</a>\r\n");
      out.write("                            <ul>\r\n");
      out.write("                                <li><a href=\"/marvelShopp/BuscaController?busca=cosmico\">Cósmico</a></li>\r\n");
      out.write("                                <li><a href=\"/marvelShopp/BuscaController?busca=habilidade\">Habilidade</a></li>\r\n");
      out.write("                                <li><a href=\"/marvelShopp/BuscaController?busca=mistico\">Místico</a></li>\r\n");
      out.write("                                <li><a href=\"/marvelShopp/BuscaController?busca=mutante\">Mutante</a></li>\r\n");
      out.write("                                <li><a href=\"/marvelShopp/BuscaController?busca=tecnologia\">Tecnologia</a></li>\r\n");
      out.write("                            </ul>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li><a href=\"#\">Sexo</a>\r\n");
      out.write("                            <ul>\r\n");
      out.write("                                <li><a href=\"/marvelShopp/BuscaController?busca=masculino\">Masculino</a></li>\r\n");
      out.write("                                <li><a href=\"/marvelShopp/BuscaController?busca=feminino\">Feminino</a></li>\r\n");
      out.write("                                <li><a href=\"/marvelShopp/BuscaController?busca=indeterminado\">Indeterminado</a></li>\r\n");
      out.write("                            </ul>\r\n");
      out.write("                        </li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("\r\n");
      out.write("                </li>\r\n");
      out.write("                <li><a href=\"top6.jsp\">Top 6</a></li>\r\n");
      out.write("                ");
 if(login != null){
      out.write("\r\n");
      out.write("                ");
 Usuario user = (Usuario)request.getSession().getAttribute("user"); 
      out.write("\r\n");
      out.write("                    <li><a>");
      out.print( user.getNome() );
      out.write("</a>\r\n");
      out.write("                        <ul>\r\n");
      out.write("                            <li><a href=\"listaFavoritos.jsp\">Favoritos</a></li>\r\n");
      out.write("                            <li><a href=\"editarUsuario.jsp\">Editar Dados</a></li>\r\n");
      out.write("                            <li><a href=\"enderecoUsuario.jsp\">Meus Endereços</a></li>\r\n");
      out.write("                            <li><a href=\"pedidosUsuario.jsp\">Meus Pedidos</a></li>\r\n");
      out.write("                            <li><a method=\"GET\" href=\"LoginController\">Logout</a></li>\r\n");
      out.write("                            \r\n");
      out.write("                            ");
 if(user.getHasAdm()){ 
      out.write("\r\n");
      out.write("                            <li><a href=\"cadastroDeProduto.jsp\">Cadastrar Produto</a></li>\r\n");
      out.write("                            <li><a href=\"tipoOcupacao.jsp\">Cadastrar Ocupação</a></li>\r\n");
      out.write("                            <li><a href=\"tipoCategoria.jsp\">Cadastrar Categoria</a></li>\r\n");
      out.write("                            <li><a href=\"tipoSexo.jsp\">Cadastrar Sexo</a></li>\r\n");
      out.write("                            <li><a href=\"listaadmin.jsp\">Listar Produtos</a></li>                            \r\n");
      out.write("                            ");
 } 
      out.write("\r\n");
      out.write("\r\n");
      out.write("                        </ul>\r\n");
      out.write("\r\n");
      out.write("                    </li>\r\n");
      out.write("                ");
}else{
      out.write("\r\n");
      out.write("                    <li><a href=\"login.jsp\">Login</a></li>\r\n");
      out.write("                ");
} 
      out.write("\r\n");
      out.write("            </ul>\r\n");
      out.write("            <form  action=\"BuscaController\" method=\"GET\" id= \"busca\">\r\n");
      out.write("                <div class=\"form-group row\">\r\n");
      out.write("                    <div class=\"col-sm-10\">\r\n");
      out.write("                        <input class=\"form-control\" type=\"search\" id=\"busca\" name=\"busca\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <button type=\"submit\" class=\"btn btn-primary\" style=\"background: #000\">Buscar</button>\r\n");
      out.write("                </div>\r\n");
      out.write("            </form>\r\n");
      out.write("            <a href='/marvelShopp/CarrinhoController'>\r\n");
      out.write("                <img id='carrinho' class=\"carrinho-img\" src=\"imagens/carrinhoDeCompras.png\" title=\"Carrinho\" width=\"10%\"/>\r\n");
      out.write("            </a> \r\n");
      out.write("        </nav>\r\n");
      out.write("                           \r\n");
      out.write("        \r\n");
      out.write("    </header>     \r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("            <section id=\"corpo\"> <!--divisão da pagina. Aqui se inicia o corpo da pagina (seção do meio)-->\r\n");
      out.write("                <hr>\r\n");
      out.write("                <div class=\"container\" style=\"width: 100%;\">\r\n");
      out.write("                    <div class=\"col-md-auto\" align=\"center\">\r\n");
      out.write("                        <a href='/marvelShopp/BuscaController?busca=heroi'>\r\n");
      out.write("                            <img id='heroList' class=\"img-rounded\" src=\"imagens/hero.png\" title=\"Super heróis cadastrados\" height=\"20%\" width=\"90%\"/> \r\n");
      out.write("                        </a>\r\n");
      out.write("                        <h5></h5>\r\n");
      out.write("                    </div>              \r\n");
      out.write("                \r\n");
      out.write("                    <div class=\"col-md-auto\" align=\"center\">\r\n");
      out.write("                        <a href='/marvelShopp/BuscaController?busca=cosmico'>\r\n");
      out.write("                            <img id='cosmicList' class=\"img-rounded float-left\" src=\"imagens/cosmic.png\" title=\"Combatentes cósmicos cadastrados\" height=\"20%\" width=\"49%\"/>\r\n");
      out.write("                        </a>\r\n");
      out.write("                        <a href='/marvelShopp/BuscaController?busca=habilidade'>\r\n");
      out.write("                            <img id='abilitiesList' class=\"img-rounded float-left\" src=\"imagens/abilities.png\" title=\"Combatentes de habilidades cadastrados\" height=\"20%\" width=\"49%\"/>\r\n");
      out.write("                        </a>\r\n");
      out.write("                        <h5></h5>\r\n");
      out.write("                    </div>              \r\n");
      out.write("                \r\n");
      out.write("                    <div class=\"col-md-auto\" align=\"center\">\r\n");
      out.write("                        <a href='/marvelShopp/BuscaController?busca=mistico'>\r\n");
      out.write("                            <img id='mysticList' class=\"img-rounded float-left\" src=\"imagens/mystic.png\" title=\"Combatentes místicos cadastrados\" width=\"50%\"/>\r\n");
      out.write("                        </a>                       \r\n");
      out.write("                        <h5></h5>\r\n");
      out.write("                    </div>              \r\n");
      out.write("                \r\n");
      out.write("                    <div class=\"col-md-auto\" align=\"center\">\r\n");
      out.write("                        <a href='/marvelShopp/BuscaController?busca=mutante'>\r\n");
      out.write("                            <img id='mutantList' class=\"img-rounded float-left\" src=\"imagens/mutant.png\" title=\"Combatentes mutantes cadastrados\" width=\"47%\"/> \r\n");
      out.write("                        </a>\r\n");
      out.write("                        <a href='/marvelShopp/BuscaController?busca=tecnologia'>\r\n");
      out.write("                            <img id='techList' class=\"img-rounded float-left\" src=\"imagens/tech.png\" title=\"Combatentes tecnológicos cadastrados\" width=\"52%\"/> \r\n");
      out.write("                        </a>\r\n");
      out.write("                        <h5></h5>\r\n");
      out.write("                    </div>              \r\n");
      out.write("                \r\n");
      out.write("                    <div class=\"col-md-auto\" align=\"center\">\r\n");
      out.write("                        <a href='/marvelShopp/BuscaController?busca=aranha'>\r\n");
      out.write("                            <img id='girlList' class=\"img-rounded\" src=\"imagens/aranha.png\" title=\"Combatentes do aranhaverso cadastrados\" width=\"60%\"/> \r\n");
      out.write("                        </a>\r\n");
      out.write("                        <h5></h5>\r\n");
      out.write("                    </div>              \r\n");
      out.write("                \r\n");
      out.write("                    <div class=\"col-md-auto\" align=\"center\">\r\n");
      out.write("                        <a href='/marvelShopp/BuscaController?busca=feminino'>\r\n");
      out.write("                            <img id='spiderList' class=\"img-rounded float-left\" src=\"imagens/girl.png\" title=\"Combatentes femininas cadastrads\" width=\"48%\"/>\r\n");
      out.write("                        </a>\r\n");
      out.write("                        <a href='/marvelShopp/BuscaController?busca=anti-heroi'>\r\n");
      out.write("                            <img id='antiheroList' class=\"img-rounded float-left\" src=\"imagens/antihero.png\" title=\"Anti-heróis cadastrados\" width=\"51%\"/> \r\n");
      out.write("                        </a>\r\n");
      out.write("                        <h5></h5>\r\n");
      out.write("                    </div>              \r\n");
      out.write("                \r\n");
      out.write("                    <div class=\"col-md-auto\" align=\"center\">\r\n");
      out.write("                        <a href='/marvelShopp/BuscaController?busca=vilao'>\r\n");
      out.write("                            <img id='villainList' class=\"img-rounded\" alt=\"Responsive image\" src=\"imagens/vilo.png\" title=\"Vilões cadastrados\" width=\"90%\"/>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </div>              \r\n");
      out.write("                </div> \r\n");
      out.write("                <hr>\r\n");
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
