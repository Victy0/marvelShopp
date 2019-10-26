/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.marvelShopp.controller;
import javax.servlet.http.Cookie;
import br.com.marvelShopp.dao.UsuarioDao;
import br.com.marvelShopp.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Victor
 */
public class LoginController extends HttpServlet {

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
        request.getSession().setAttribute("user", null);
        
        request.getRequestDispatcher("index.jsp").forward(request, response);
        
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
         String email = null;
          String senha = null;
       
            email = request.getParameter("email");
         senha = request.getParameter("senha");
        
      
         
        UsuarioDao userDao = new UsuarioDao();
        Usuario user = new Usuario();
        user = userDao.validateUser(email, senha);
        if(user.getId()!=null){
          request.getSession().setAttribute("user", user);
          
         Cookie cookieemail=new Cookie("email",email);
         Cookie cookiesenha= new Cookie("senha",senha);
         cookieemail.setMaxAge(60*60);
         cookiesenha.setMaxAge(60*60);
         response.addCookie(cookieemail);
         response.addCookie(cookiesenha);
          
          request.getRequestDispatcher("index.jsp").forward(request, response);
        }else{
          boolean erro = true;
          request.setAttribute("errorValidate", erro);
          request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>

}
