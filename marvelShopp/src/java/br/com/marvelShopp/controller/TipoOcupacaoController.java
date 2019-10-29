/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.marvelShopp.controller;

import br.com.marvelShopp.dao.TipoOcupacaoDao;
import br.com.marvelShopp.model.TipoOcupacao;
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
@WebServlet(name = "TipoOcupacaoController", urlPatterns = {"/TipoOcupacaoController"})
public class TipoOcupacaoController extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{//deleta ocupacao
       
        String id = request.getParameter("idTOcup");
        TipoOcupacaoDao tipoDao = new TipoOcupacaoDao();
        tipoDao.delete(id);
        response.sendRedirect("tipoOcupacao.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{//cria ocupacao
       
        TipoOcupacao to = new TipoOcupacao();
        to.setNome(request.getParameter("tOcup"));
        TipoOcupacaoDao toDao = new TipoOcupacaoDao();
        toDao.create(to);
        response.sendRedirect("tipoOcupacao.jsp");
    }

}
