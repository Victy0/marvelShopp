/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.marvelShopp.controller;

import br.com.marvelShopp.dao.PersonagemDao;
import br.com.marvelShopp.model.Personagem;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author chris
 */
@WebServlet(name = "BuscaController", urlPatterns = {"/BuscaController"})
public class BuscaController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PersonagemDao personaDao = new PersonagemDao();
        List<Personagem> lista = personaDao.busca(request.getParameter("busca"));
        request.setAttribute("lista", lista);
        //response.sendRedirect("busca.jsp");
        request.getRequestDispatcher("busca.jsp").forward(request, response);
    }
    
    
}
