
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
        String idUser = request.getParameter("idUser");
        request.setAttribute("enderecoList", enderecoDao.list(idUser));
        RequestDispatcher view = request.getRequestDispatcher("/pagamento.jsp");
        view.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {      
        String acao = request.getParameter("acao");
        if(acao != null){
            if("delete".equals(acao)){
                String enderecoId = request.getParameter("enderecoId");
                enderecoDao.delete(enderecoId);
                request.getRequestDispatcher("/enderecoUsuario.jsp").forward(request,response);
            }else{
                Usuario user = (Usuario)request.getSession().getAttribute("user");
                Endereco endereco = new Endereco();
                endereco.setRua(request.getParameter("rua"));
                endereco.setNumeroCasa(request.getParameter("numero"));
                endereco.setBairro(request.getParameter("bairro"));
                endereco.setComplemento(request.getParameter("complemento"));
                endereco.setCidade(request.getParameter("cidade"));
                endereco.setCep(request.getParameter("cep"));
                endereco.setUserId(user.getId().toString());

                enderecoDao.inserir(endereco);
                request.getRequestDispatcher("/enderecoUsuario.jsp").forward(request,response);
            }              
        }else{
            Usuario user = (Usuario)request.getSession().getAttribute("user");
            Endereco endereco = new Endereco();
            endereco.setRua(request.getParameter("rua"));
            endereco.setNumeroCasa(request.getParameter("numero"));
            endereco.setBairro(request.getParameter("bairro"));
            endereco.setComplemento(request.getParameter("complemento"));
            endereco.setCidade(request.getParameter("cidade"));
            endereco.setCep(request.getParameter("cep"));
            endereco.setUserId(user.getId().toString());

            enderecoDao.inserir(endereco);
            request.setAttribute("enderecoList", enderecoDao.list(user.getId().toString()));
            RequestDispatcher view= request.getRequestDispatcher("/pagamento.jsp");
            view.forward(request, response);
        }
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
