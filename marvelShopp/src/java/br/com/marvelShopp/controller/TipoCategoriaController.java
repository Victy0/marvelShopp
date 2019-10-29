/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.marvelShopp.controller;

import br.com.marvelShopp.dao.TipoCategoriaDao;
import br.com.marvelShopp.model.TipoCategoria;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gleison
 */
@WebServlet(name = "TipoCategoriaController", urlPatterns = {"/TipoCategoriaController"})
public class TipoCategoriaController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{//deleta a categoria
       
        String id = request.getParameter("idTCat");
        TipoCategoriaDao tipoDao = new TipoCategoriaDao();
        tipoDao.delete(id);
        response.sendRedirect("tipoCategoria.jsp");
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{//cria categoria
       
        TipoCategoria tc = new TipoCategoria();
        tc.setNome(request.getParameter("tCat"));
        TipoCategoriaDao tcDao = new TipoCategoriaDao();
        tcDao.create(tc);
        response.sendRedirect("tipoCategoria.jsp");
    }

}
