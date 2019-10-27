
package br.com.marvelShopp.controller;

import br.com.marvelShopp.dao.EnderecoDao;
import br.com.marvelShopp.dao.PagamentoDao;
import br.com.marvelShopp.model.Endereco;
import br.com.marvelShopp.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
        Usuario user = (Usuario)request.getSession().getAttribute("user");
        if(user == null){
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            //RequestDispatcher view = request.getRequestDispatcher("/login.jsp");
            //view.forward(request, response);
        }
        else{
            String idUser = user.getId().toString();
            request.setAttribute("enderecoList", enderecoDao.list(idUser));
            RequestDispatcher view = request.getRequestDispatcher("/pagamento.jsp");
            view.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String funcao = (String)request.getParameter("funcao");
        if(funcao.equals("irPagar")){
            RequestDispatcher view = request.getRequestDispatcher("/fechamentoCompra.jsp");
            view.forward(request, response);
        }
        
        String idUser = (String)request.getParameter("idUser");
        String idEndereco = (String)request.getParameter("idEndereco");
        String formPag = (String)request.getParameter("formPag");
        String pedidoId = (String)request.getParameter("pedidoId");
        pagamentoDao.create(idEndereco, idUser, formPag, pedidoId);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
