/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.marvelShopp.controller;

import br.com.marvelShopp.dao.ComentariosDao;
import br.com.marvelShopp.dao.PersonagemDao;
import br.com.marvelShopp.model.Comentarios;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author victo
 */
@WebServlet(name = "ComentariosController", urlPatterns = {"/ComentariosController"})
public class ComentariosController extends HttpServlet {
    ComentariosDao dao;
    
    
    public ComentariosController() {
        super();
        dao = new ComentariosDao();
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   

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
        String forward="";
        String action = "ComentList";
        
        request.setAttribute("comentList", dao.list(request.getParameter("idPersonagem")));
        
        request.getRequestDispatcher("/pagproduto.jsp").forward(request, response);
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
        Comentarios coment = new Comentarios();
        PersonagemDao personagemDao = new PersonagemDao();
        
         
        coment.setDescricao(request.getParameter("descricao"));
        coment.setPersonagem(personagemDao.getById("idPersonagem"));
        coment.setNota(Integer.parseInt(request.getParameter("nota")));
        coment.setUsuario(null);        //Consertar mais tarde <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
        
        dao.create(coment);
        RequestDispatcher view = request.getRequestDispatcher("/pagproduto.jsp");
        request.setAttribute("comentList", dao.list(request.getParameter("id")));
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
