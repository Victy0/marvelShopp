
package br.com.marvelShopp.controller;

import br.com.marvelShopp.dao.EnderecoDao;
import br.com.marvelShopp.dao.PagamentoDao;
import br.com.marvelShopp.model.Usuario;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PagamentoController", urlPatterns = {"/PagamentoController"})
public class PagamentoController extends HttpServlet {
    
    PagamentoDao pagamentoDao;
    EnderecoDao enderecoDao;
    public PagamentoController() {
        super();
        pagamentoDao = new PagamentoDao();
        enderecoDao = new EnderecoDao();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Usuario user = (Usuario)request.getSession().getAttribute("user");//pega o usuario da seção
        if(user == null){//se nao tiver usuario logado
            request.setAttribute("pagamento", "p");
            request.getRequestDispatcher("/login.jsp").forward(request,response);//redireciona para pagina de login
        }
        String idUser = user.getId().toString();//pega id do usuario
        request.setAttribute("enderecoList", enderecoDao.list(idUser));//pega a lista de endereco do usuario
        request.getRequestDispatcher("/pagamento.jsp").forward(request, response);//redireciona para pagina de pagamento
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String idUser = (String)request.getParameter("idUser");//pega id do usuario
            String idEndereco = (String)request.getParameter("idEndereco");//pega id do endereco
            String formPag = (String)request.getParameter("formPag");//pega id da forma de pagamento
            String pedidoId = (String)request.getParameter("pedidoId");//pega id do pedido
            pagamentoDao.create(idEndereco, idUser, formPag, pedidoId);//cria um pagamento
            request.getSession().setAttribute("carrinho", null);//zera o carrinho da seção
            RequestDispatcher view = request.getRequestDispatcher("/fechamentoCompra.jsp");//redireciona para pagina de confirmação da compra
            view.forward(request, response);
       
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
