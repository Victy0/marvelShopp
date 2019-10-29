/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.marvelShopp.controller;

import br.com.marvelShopp.dao.TipoSexoDao;
import br.com.marvelShopp.model.TipoSexo;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Victor
 */
public class TipoSexoController extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{//deleta sexo
       
        String id = request.getParameter("idTSexo");
        TipoSexoDao tipoDao = new TipoSexoDao();
        tipoDao.delete(id);
        response.sendRedirect("tipoSexo.jsp");
    }
    
@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{//cria personagem
       
        TipoSexo ts = new TipoSexo();
        ts.setNome(request.getParameter("tSexo"));
        TipoSexoDao tsDao = new TipoSexoDao();
        tsDao.create(ts);
        response.sendRedirect("tipoSexo.jsp");
    }
}
