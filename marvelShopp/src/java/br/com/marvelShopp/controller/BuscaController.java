/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.marvelShopp.controller;

import br.com.marvelShopp.dao.PersonagemDao;
import br.com.marvelShopp.model.Personagem;
import java.io.IOException;
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
        Integer limit = 6;
        String numpagina=request.getParameter("numpagina");
            if(numpagina==null){
                numpagina="1";
            }
        Integer offset=(Integer.parseInt(numpagina)*limit)-limit;
        PersonagemDao personaDao = new PersonagemDao();
        String busca = request.getParameter("busca");
        List<Personagem> lista = personaDao.busca(busca, limit.toString(), offset.toString());
        request.setAttribute("lista", lista);
        request.setAttribute("limit", limit);
        Integer qtdBusca = personaDao.quantidadePersonagem(request.getParameter("busca"));
        request.setAttribute("qtdBusca", qtdBusca);
        request.setAttribute("busca", busca);
        //response.sendRedirect("busca.jsp");
        request.getRequestDispatcher("listaprodutos.jsp").forward(request, response);
    }
    
    
}
