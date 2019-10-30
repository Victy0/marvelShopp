package br.com.marvelShopp.controller;
import br.com.marvelShopp.dao.CarrinhoDao;
import javax.servlet.http.Cookie;
import br.com.marvelShopp.dao.UsuarioDao;
import br.com.marvelShopp.model.Carrinho;
import br.com.marvelShopp.model.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Victor
 */
public class LoginController extends HttpServlet {
    
    CarrinhoDao carrinhoDao = new CarrinhoDao();//instancia carrinhoDao
    PagamentoController pc = new PagamentoController();
    UsuarioDao userDao = new UsuarioDao();

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //realiza o logout
        request.getSession().setAttribute("user", null);
        request.getSession().setAttribute("carrinho", null);   
        request.getRequestDispatcher("index.jsp").forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");  //recupera o email informado
        String senha = request.getParameter("senha");   //recupera a senha informada
        String pagamento = request.getParameter("pagamento");  //considera se veio do pagamento.jsp
        request.setAttribute("pagamento", pagamento);
        Usuario user = new Usuario();
        user = userDao.validateUser(email, senha);  //valida dados informados
        if(user.getId()!=null){                     //caso tenha se autenticado
            Carrinho carrinho = (Carrinho)request.getSession().getAttribute("carrinho"); //verifica se há carrinho atual
            if(carrinho != null){
               carrinhoDao.setUser(user.getId(), carrinho.getId());  //adiciona o carrinho stual ao usuário
               carrinho.setUsuario(user);
            }else{
                 carrinho = carrinhoDao.getByUser(user);    //recupera último carrinho em aberrto para o usuário
                 if(carrinho.getId() == null){
                    carrinho = null;
                }
            }
            request.getSession().setAttribute("user", user);
            request.getSession().setAttribute("carrinho", carrinho);

            Cookie cookieemail=new Cookie("email",email);   //implementação de cookie dos dados de login
            Cookie cookiesenha= new Cookie("senha",senha);
            cookieemail.setMaxAge(60*60);
            cookiesenha.setMaxAge(60*60);
            response.addCookie(cookieemail);
            response.addCookie(cookiesenha);
            if("null".equals(pagamento)){          //redireciona se não veio de pagamento
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }else{                              //redireciona se veio de pagamento
                pc.doGet(request, response);
            }
        }else{
          boolean erro = true;                      //redireciona com erro se não conseguir autenticar o usuário
          request.setAttribute("errorValidate", erro);
          request.getRequestDispatcher("login.jsp").forward(request, response);
        }    
    }

}
