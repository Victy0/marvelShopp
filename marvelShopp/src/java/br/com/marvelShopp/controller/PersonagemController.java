/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.marvelShopp.Controller;

import br.com.marvelShopp.Dao.PersonagemDao;
import br.com.marvelShopp.Dao.TipoCategoriaDao;
import br.com.marvelShopp.Dao.TipoOcupacaoDao;
import br.com.marvelShopp.Dao.TipoSexoDao;
import br.com.marvelShopp.model.Personagem;
import br.com.marvelShopp.model.TipoCategoria;
import br.com.marvelShopp.model.TipoOcupacao;
import br.com.marvelShopp.model.TipoSexo;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author victo
 */
public class PersonagemController extends HttpServlet {
     private TipoSexoDao sexoDao;
     private TipoOcupacaoDao ocupacaoDao;
     private TipoCategoriaDao  categoriaDao ;
     private PersonagemDao     personagemDao;
    
  public PersonagemController(){
      super();
      sexoDao=new TipoSexoDao();
      ocupacaoDao=new TipoOcupacaoDao();
      categoriaDao=new TipoCategoriaDao();
      personagemDao= new PersonagemDao();
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
        request.setAttribute("sexoLista", sexoDao.list());
        request.setAttribute("ocupacaoLista",ocupacaoDao.list());
        request.setAttribute("categoriaLista", categoriaDao.list());
        RequestDispatcher view= request.getRequestDispatcher("/cadastroDeProduto.jsp");
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
        
        Personagem persona= new Personagem();
        TipoCategoria categoria = categoriaDao.getById(request.getParameter("categoria"));
        persona.setCategoria(categoria);
        persona.setDescricao(request.getParameter("descricao"));
        persona.setIdentidade(request.getParameter("identidade"));
        persona.setImagemRef(request.getParameter("imagemRef"));
        persona.setLugar(request.getParameter("lugar"));
        persona.setNomeReal(request.getParameter("nomeReal"));
        TipoOcupacao ocupacao= ocupacaoDao.getById(request.getParameter("ocupacao"));
        persona.setOcupacao(ocupacao);
        persona.setPreco(Double.parseDouble(request.getParameter("preco")));
        persona.setQtdEstoque(Integer.parseInt(request.getParameter("estoque")));
        TipoSexo sexo = sexoDao.getById(request.getParameter("sexo"));
        persona.setSexo(sexo);
        
        this.personagemDao.create(persona);
        doGet(request,response);
        
        
        
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
