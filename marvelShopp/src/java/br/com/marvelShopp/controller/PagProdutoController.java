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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author chris
 */
@WebServlet(name = "PagProdutoController", urlPatterns = {"/PagProdutoController"})
public class PagProdutoController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PersonagemDao personaDao = new PersonagemDao();
        Personagem persona = personaDao.getById(request.getParameter("idPersonagem"));
        
        request.setAttribute("nomeReal", persona.getNomeReal());
        request.setAttribute("identidade", persona.getIdentidade());
        request.setAttribute("categoria", persona.getCategoria().getNome());
        request.setAttribute("descricao", persona.getDescricao());
        request.setAttribute("preco", persona.getPreco());
        request.setAttribute("ocupacao", persona.getOcupacao().getNome());
        request.setAttribute("sexo", persona.getSexo().getNome());
        request.setAttribute("lugar", persona.getLugar());
        request.setAttribute("imagemRef", persona.getImagemRef());
        
        request.getRequestDispatcher("ComentariosController").forward(request, response);
    }
}

