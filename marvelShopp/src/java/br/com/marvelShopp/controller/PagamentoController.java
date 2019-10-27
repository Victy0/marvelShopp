
package br.com.marvelShopp.controller;

import br.com.marvelShopp.dao.PagamentoDao;
import br.com.marvelShopp.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PagamentoController", urlPatterns = {"/PagamentoController"})
public class PagamentoController extends HttpServlet {
    
    PagamentoDao pagamentoDao;
    public PagamentoController() {
        super();
        pagamentoDao = new PagamentoDao();
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
            RequestDispatcher view = request.getRequestDispatcher("/pagamento.jsp");
            view.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Usuario loginUser = (Usuario)request.getSession().getAttribute("user");
        String idUser = loginUser.getId().toString();
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
