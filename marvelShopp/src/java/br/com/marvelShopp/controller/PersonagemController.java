/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.marvelShopp.controller;

import br.com.marvelShopp.dao.TipoCategoriaDao;
import br.com.marvelShopp.dao.TipoOcupacaoDao;
import br.com.marvelShopp.dao.TipoSexoDao;
import br.com.marvelShopp.model.TipoSexo;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Victor
 */
public class PersonagemController extends HttpServlet {
    
    public PersonagemController(){
        super();
        sexoDao = new TipoSexoDao();
        ocupacaoDao = new TipoOcupacaoDao();
        categoriaDao = new TipoCategoriaDao();
    }
    
    private TipoSexoDao sexoDao;
    
    private TipoOcupacaoDao ocupacaoDao;
    
    private TipoCategoriaDao categoriaDao;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet PersonagemController</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet PersonagemController at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
//    }

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
//        String acao = request.getParamater("acao");
//        if("create".equals(acao))
        request.setAttribute("sexoLista", sexoDao.list());
        request.setAttribute("ocupacaoLista", ocupacaoDao.list());
        request.setAttribute("categoriaLista", categoriaDao.list());
        RequestDispatcher view = request.getRequestDispatcher("/cadastroDeProduto.jsp");
        view.forward(request, response);
        
//        processRequest(request, response);
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
//        processRequest(request, response);
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
