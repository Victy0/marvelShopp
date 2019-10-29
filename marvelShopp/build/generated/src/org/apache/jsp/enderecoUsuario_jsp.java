package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import br.com.marvelShopp.model.Endereco;
import java.util.List;
import br.com.marvelShopp.dao.EnderecoDao;
import br.com.marvelShopp.model.Usuario;
import br.com.marvelShopp.model.Usuario;

public final class enderecoUsuario_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Marvel Shopp</title>\r\n");
      out.write("        <link rel=\"icon\" type=\"imagem/png\" href=\"imagens/deadpoolLogo.png\" />\r\n");
      out.write("    </head>\r\n");
      out.write("    ");
 Usuario loginUser = (Usuario)request.getSession().getAttribute("user");
        EnderecoDao enderecoDao = new EnderecoDao();
        List<Endereco> lista = enderecoDao.list(loginUser.getId().toString());
           int i =1;
      out.write("\r\n");
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
      out.write("                            <li><a method=\"GET\" href=\"LoginController\">Logout</a></li>\r\n");
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
      out.write("                        <input class=\"form-control\" type=\"search\" id=\"busca\" name=\"busca\" placeholder=\"Buscar\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <button type=\"submit\" class=\"btn btn-primary\" style=\"background: #000\">Buscar</button>\r\n");
      out.write("                </div>\r\n");
      out.write("            </form>\r\n");
      out.write("            <a href='/marvelShopp/CarrinhoController'>\r\n");
      out.write("                ");
if(request.getSession().getAttribute("carrinho")==null){
      out.write("\r\n");
      out.write("                <img id='carrinho' class=\"carrinho-img\" src=\"imagens/carrinhoDeCompras.png\" title=\"Carrinho\" width=\"10%\"/>\r\n");
      out.write("                ");
}else{
      out.write("\r\n");
      out.write("                <img id='carrinho' class=\"carrinho-img\" src=\"imagens/carrinhoDeComprasC.png\" title=\"Carrinho\" width=\"10%\"/>\r\n");
      out.write("                ");
}
      out.write("\r\n");
      out.write("            </a> \r\n");
      out.write("        </nav>\r\n");
      out.write("                           \r\n");
      out.write("        \r\n");
      out.write("    </header>     \r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("            <section id=\"corpo\">\r\n");
      out.write("                 <h1 id=\"titulo\" align=\"center\">Endereços</h1>\r\n");
      out.write("                    ");
 if (lista.isEmpty()){
      out.write("\r\n");
      out.write("                    <div align=\"center\"><h1 style=\"color: red;\">NENHUM ENDEREÇO CADASTRADO!!!</h1></div><br><br>\r\n");
      out.write("                    ");
}else{
      out.write("\r\n");
      out.write("                    <table class=\"table\">\r\n");
      out.write("                        <thead class=\"thead-dark\">\r\n");
      out.write("                          <tr>\r\n");
      out.write("                            <th scope=\"col\">#</th>\r\n");
      out.write("                            <th scope=\"col\">Logradouro</th>\r\n");
      out.write("                            <th scope=\"col\">Número</th>\r\n");
      out.write("                            <th scope=\"col\">Bairro</th>\r\n");
      out.write("                            <th scope=\"col\">Complemento</th>\r\n");
      out.write("                            <th scope=\"col\">Cidade</th>\r\n");
      out.write("                            <th scope=\"col\">CEP</th>\r\n");
      out.write("                            <th scope=\"col\">+ Detalhes</th>\r\n");
      out.write("                          </tr>\r\n");
      out.write("                        </thead>\r\n");
      out.write("                        <tbody>\r\n");
      out.write("                          ");
 for(Endereco endereco : lista ){ 
      out.write("  \r\n");
      out.write("                          <tr>\r\n");
      out.write("                            <th scope=\"row\" >");
      out.print(i++);
      out.write("</th>\r\n");
      out.write("                            <td>");
      out.print(endereco.getRua());
      out.write("</td>\r\n");
      out.write("                            <td>");
      out.print(endereco.getNumeroCasa());
      out.write("</td>\r\n");
      out.write("                            <td>");
      out.print(endereco.getBairro());
      out.write("</td>\r\n");
      out.write("                            <td>");
      out.print(endereco.getComplemento());
      out.write("</td>\r\n");
      out.write("                            <td>");
      out.print(endereco.getCidade());
      out.write("</td>\r\n");
      out.write("                            <td>");
      out.print(endereco.getCep());
      out.write("</td>\r\n");
      out.write("                            <td><form action=\"CadEnderecoController?enderecoId=");
      out.print(endereco.getId());
      out.write("&acao=delete\" method=\"POST\"><input type=\"submit\" class=\"btn btn-primary\" value=\"Excluir\" style=\"width:70px;\"></form></td>\r\n");
      out.write("                          </tr>\r\n");
      out.write("                          ");
}
      out.write("\r\n");
      out.write("                        </tbody>\r\n");
      out.write("                    </table>\r\n");
      out.write("                        <center> \r\n");
      out.write("                    <div style=\"width: 400px;\">\r\n");
      out.write("                    <form action=\"/marvelShopp/CadEnderecoController?acao=create\" method=\"POST\" id=\"cadEndereco\">\r\n");
      out.write("                        <h3>Cadastrar novo endereço de entrega</h3>\r\n");
      out.write("                        <div class=\"form-group\">\r\n");
      out.write("                            <label for=\"rua\">Rua: </label>\r\n");
      out.write("                            <input type=\"text\" class=\"form-control\" name=\"rua\" id=\"rua\" maxlength=\"50\" placeholder=\"Nome da rua\" required>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"form-group\">\r\n");
      out.write("                            <label for=\"numero\">Número: </label>\r\n");
      out.write("                            <input type=\"text\" class=\"form-control\" name=\"numero\" id=\"numero\" maxlength=\"50\" placeholder=\"Número\" required>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"form-group\">\r\n");
      out.write("                            <label for=\"bairro\">Bairro: </label>\r\n");
      out.write("                            <input type=\"text\" class=\"form-control\" name=\"bairro\" id=\"bairro\" maxlength=\"50\" placeholder=\"Bairro\" required>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"form-group\">\r\n");
      out.write("                            <label for=\"complemento\">Complemento: </label>\r\n");
      out.write("                            <input type=\"text\" class=\"form-control\" name=\"complemento\" id=\"complemento\" maxlength=\"50\" placeholder=\"Complemento\">\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"form-group\">\r\n");
      out.write("                            <label for=\"cidade\">Cidade: </label>\r\n");
      out.write("                            <input type=\"text\" class=\"form-control\" name=\"cidade\" id=\"cidade\" maxlength=\"50\" placeholder=\"Cidade\" required>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"form-group\">\r\n");
      out.write("                            <label for=\"cep\">CEP: </label>\r\n");
      out.write("                            <input type=\"text\" class=\"form-control\" name=\"cep\" id=\"cep\" maxlength=\"50\" placeholder=\"CEP\" required>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <input type=\"submit\" class=\"btn-primary\" value=\"Enviar\" ID=\"cadEndereco\" name=\"cadEndereco\" style=\"width:200px; margin-left: 200px;\">\r\n");
      out.write("                        <input type=\"hidden\" value=\"");
      out.print( loginUser.getId());
      out.write("\">\r\n");
      out.write("                    </form>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    </center>\r\n");
      out.write("                        <br><br>\r\n");
      out.write("                    ");
}
      out.write("\r\n");
      out.write("            </section>\r\n");
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
