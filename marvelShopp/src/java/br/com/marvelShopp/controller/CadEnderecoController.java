
package br.com.marvelShopp.controller;

import br.com.marvelShopp.dao.EnderecoDao;
import br.com.marvelShopp.model.Endereco;
import br.com.marvelShopp.model.Usuario;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CadEnderecoController", urlPatterns = {"/CadEnderecoController"})
public class CadEnderecoController extends HttpServlet {
    
    private EnderecoDao enderecoDao;
    
    public CadEnderecoController(){
      super();
      enderecoDao = new EnderecoDao();
    }
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idUser = request.getParameter("idUser");//pega o id do usuario
        request.setAttribute("enderecoList", enderecoDao.list(idUser));//salva os enderecos do usuario em enderecoList
        RequestDispatcher view = request.getRequestDispatcher("/pagamento.jsp");// redireciona para pagamento.jsp
        view.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {      
        String acao = request.getParameter("acao");//cria uma variavel que vai definir a acao do doPost
        if(acao != null){//se a variavel nao estiver vazia
            if("delete".equals(acao)){//se ela for igual a "acao"
                String enderecoId = request.getParameter("enderecoId");//pega o id do endereco
                enderecoDao.delete(enderecoId);//chama o enderecoDao para deletar um endereço
                request.getRequestDispatcher("/enderecoUsuario.jsp").forward(request,response);// redireciona para enderecoUsuario.jsp
            }else{//se acao não for igual a "acao". Aqui redireciona para a pagina de enderecos cadastrados do usuario
                Usuario user = (Usuario)request.getSession().getAttribute("user");//pega o usuario da seção
                Endereco endereco = new Endereco();//cria um objeto endereço
                endereco.setRua(request.getParameter("rua"));
                endereco.setNumeroCasa(request.getParameter("numero"));
                endereco.setBairro(request.getParameter("bairro"));
                endereco.setComplemento(request.getParameter("complemento"));
                endereco.setCidade(request.getParameter("cidade"));
                endereco.setCep(request.getParameter("cep"));
                endereco.setUserId(user.getId().toString());

                enderecoDao.inserir(endereco);//insere um endereço no banco
                request.getRequestDispatcher("/enderecoUsuario.jsp").forward(request,response);//redireciona para enderecoUsuario.jsp
            }              
        }else{//se a variavel for null. Neste redireciona para a pagina de pagamento
            Usuario user = (Usuario)request.getSession().getAttribute("user");//pega o usuario da seção
            Endereco endereco = new Endereco();//cria um objeto endereço
            endereco.setRua(request.getParameter("rua"));
            endereco.setNumeroCasa(request.getParameter("numero"));
            endereco.setBairro(request.getParameter("bairro"));
            endereco.setComplemento(request.getParameter("complemento"));
            endereco.setCidade(request.getParameter("cidade"));
            endereco.setCep(request.getParameter("cep"));
            endereco.setUserId(user.getId().toString());

            enderecoDao.inserir(endereco);//insere um endereço no banco
            request.setAttribute("enderecoList", enderecoDao.list(user.getId().toString()));
            RequestDispatcher view= request.getRequestDispatcher("/pagamento.jsp");//redireciona para pagamento.jsp
            view.forward(request, response);
        }
    }
}
