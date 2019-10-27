/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.marvelShopp.controller;

import br.com.marvelShopp.dao.PersonagemDao;
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
    private PersonagemDao personagemDao = new PersonagemDao();
    
    
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
        String acao = request.getParameter("acao");
        Long idPersona = Long.parseLong(request.getParameter("idPersonagem"));
        Usuario user = (Usuario)request.getSession().getAttribute("user");
        if("add".equals(acao)){
            usudao.addFavorito(user.getId(), idPersona);
            user.insereFavorito(personagemDao.getById(idPersona.toString()));
        }else{
            usudao.removeFavorito(user.getId(), idPersona);
            user.removeFavorito(idPersona);
        }
        request.getSession().setAttribute("user", user);
        request.getRequestDispatcher("/PagProdutoController?id="+idPersona).forward(request, response);
        
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
        
        usu.setDt_nascimento(request.getParameter("dataNasc"));
        usu.setNome(request.getParameter("nome"));
        usu.setSenha(request.getParameter("senha1"));
        usu.setEmail(request.getParameter("mail"));
        usu.setSexo(request.getParameter("sexo"));
        usu.setCpf(request.getParameter("cpf"));
        boolean recebeEmail = false;
        if(request.getParameter("recebeEmail")!= null){
            recebeEmail = true;
        }
        usu.setRecebeEmail(recebeEmail);
  
        if(request.getParameter("editar") == null)
        {
            this.usudao.create(usu);
            RequestDispatcher view= request.getRequestDispatcher("/login.jsp");
            view.forward(request, response);
        }
        else if (request.getParameter("editar").equals("editar"))
        {
            this.usudao.editar(usu, request.getParameter("idUser"));
            RequestDispatcher view= request.getRequestDispatcher("/index.jsp");
            view.forward(request, response);
        }
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
