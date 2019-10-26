package br.com.marvelShopp.controller;

import br.com.marvelShopp.dao.CarrinhoDao;
import br.com.marvelShopp.dao.PersonagemDao;
import br.com.marvelShopp.model.Carrinho;
import br.com.marvelShopp.model.Item;
import br.com.marvelShopp.model.Personagem;
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

/**
 *
 * @author Gleison
 */
@WebServlet(name = "CarrinhoController", urlPatterns = {"/CarrinhoController"})
public class CarrinhoController extends HttpServlet {
    CarrinhoDao carrinhoDao;//instancia um carrinho
    PersonagemDao personagemDao = new PersonagemDao();
    
    public CarrinhoController() {
        super();
        carrinhoDao = new CarrinhoDao();//cria um carrinho
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Usuario loginUser = (Usuario)request.getSession().getAttribute("user");
        request.setAttribute("comentList", carrinhoDao.list(loginUser));
        //processRequest(request, response);
        RequestDispatcher view = request.getRequestDispatcher("/carrinho.jsp");
        view.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String funcao = request.getParameter("funcao");
        String idPersonagem = request.getParameter("idPersonagem");
        Carrinho carrinho = (Carrinho)request.getSession().getAttribute("carrinho");
        
        if(funcao.equals("delete")){
            String idItem = (String)request.getParameter("itemRemove");
            carrinhoDao.delete(idItem, carrinho.getId().toString());
            Long itemId = Long.parseLong(idItem);
            carrinho.removeItem(itemId);
        }        
        
        if(funcao.equals("create")){
            if(carrinho != null){
                Item item = new Item();
                Personagem persona = personagemDao.getById(idPersonagem);
                item.setPersonagem(persona);
                item.setQtd(1);
                item = carrinhoDao.saveItem(item, carrinho.getId());
                carrinho.insereItemLista(item);
                request.getSession().removeAttribute("carrinho");
                request.getSession().setAttribute("carrinho",carrinho); 
            }else{
                carrinho = carrinhoDao.create(idPersonagem);
                request.getSession().removeAttribute("carrinho");
                request.getSession().setAttribute("carrinho", carrinho);
            }
        }        
        
        
        RequestDispatcher view = request.getRequestDispatcher("carrinho.jsp");
        view.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
