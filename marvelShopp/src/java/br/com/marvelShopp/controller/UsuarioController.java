/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.marvelShopp.controller;

import br.com.marvelShopp.dao.UsuarioDao;
import br.com.marvelShopp.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;

import java.text.ParseException;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author victo
 */
public class UsuarioController extends HttpServlet {
    
    private UsuarioDao usudao;
    
    
    public UsuarioController(){
        super();
        usudao=new UsuarioDao();
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
        RequestDispatcher view= request.getRequestDispatcher("/cadastroUsuario.jsp");
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
          Usuario usu= new Usuario();
         
          String dat=request.getParameter("tNasc");
          usu.setDt_nascimento(dat);
          

          usu.setNome(request.getParameter("tNome"));
           usu.setSenha(request.getParameter("tSenha"));
            usu.setEmail(request.getParameter("tMail"));
             usu.setNome(request.getParameter("tNome"));
             usu.setSexo(request.getParameter("tSexo"));
             usu.setCpf(request.getParameter("tCpf"));
             
             
        
              this.usudao.create(usu);
               RequestDispatcher view= request.getRequestDispatcher("/cadastroUsuario.jsp");
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
