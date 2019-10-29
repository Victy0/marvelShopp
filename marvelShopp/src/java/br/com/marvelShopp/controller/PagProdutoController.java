/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.marvelShopp.controller;
import br.com.marvelShopp.dao.ComentariosDao;
import br.com.marvelShopp.model.Comentarios;
import br.com.marvelShopp.dao.PersonagemDao;
import br.com.marvelShopp.model.Personagem;
import br.com.marvelShopp.model.Usuario;
import java.io.IOException;
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
ComentariosDao dao;

 public PagProdutoController() {
        super();
        dao = new ComentariosDao();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)//comentario e rank personagem
            throws ServletException, IOException {
        PersonagemDao personaDao = new PersonagemDao();//instancia um personagemDao
        Personagem persona = personaDao.getById(request.getParameter("id"));//cria um personagem
        persona.setRank(dao.getRank(persona.getId().toString()));//pega o rank do personagem
        
        request.setAttribute("personagem", persona);//retorna personagem
//        request.setAttribute("identidade", persona.getIdentidade());
//        request.setAttribute("categoria", persona.getCategoria().getNome());
//        request.setAttribute("descricao", persona.getDescricao());
//        request.setAttribute("preco", persona.getPreco());
//        request.setAttribute("ocupacao", persona.getOcupacao().getNome());
//        request.setAttribute("sexo", persona.getSexo().getNome());
//        request.setAttribute("lugar", persona.getLugar());
//        request.setAttribute("imagemRef", persona.getImagemRef());
//        request.setAttribute("idPersonagem",persona.getId());
//        request.setAttribute("qtdEstoque",persona.getQtdEstoque());
        request.setAttribute("comentList", dao.list(persona.getId().toString()));//pega lista de comentarios
        
        request.getRequestDispatcher("pagproduto.jsp").forward(request, response);//redireciona para pagProduto.jsp
    }
    
    protected void doGet2(HttpServletRequest request, HttpServletResponse response, String idPersona)//comentario e rank personagem
            throws ServletException, IOException {
        PersonagemDao personaDao = new PersonagemDao();//instancia um personagemDao
        Personagem persona = personaDao.getById(idPersona);//cria um personagem
        persona.setRank(dao.getRank(persona.getId().toString()));//pega o rank do personagem
        
        request.setAttribute("personagem", persona);
//        request.setAttribute("nomeReal", persona.getNomeReal());
//        request.setAttribute("identidade", persona.getIdentidade());
//        request.setAttribute("categoria", persona.getCategoria().getNome());
//        request.setAttribute("descricao", persona.getDescricao());
//        request.setAttribute("preco", persona.getPreco());
//        request.setAttribute("ocupacao", persona.getOcupacao().getNome());
//        request.setAttribute("sexo", persona.getSexo().getNome());
//        request.setAttribute("lugar", persona.getLugar());
//        request.setAttribute("imagemRef", persona.getImagemRef());
//        request.setAttribute("idPersonagem",persona.getId());
//        request.setAttribute("qtdEstoque",persona.getQtdEstoque());
        request.setAttribute("comentList", dao.list(persona.getId().toString()));//pega lista de comentarios
        
        request.getRequestDispatcher("pagproduto.jsp").forward(request, response);//redireciona para pagProduto.jsp
    }
    
     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)//cria comentario
            throws ServletException, IOException {
        Comentarios coment=new Comentarios();//instancia um comentario
        PersonagemDao personaDao = new PersonagemDao();//instancia um personagemDao
        Personagem persona = personaDao.getById(request.getParameter("idPersonagem"));//cria um personagem
        coment.setDescricao(request.getParameter("descricao"));
        coment.setPersonagem(persona);
        coment.setNota(Integer.parseInt(request.getParameter("nota")));
        coment.setUsuario((Usuario)request.getSession().getAttribute("user"));
        
        dao.create(coment);//cria comentario
        request.setAttribute("comentList", dao.list(persona.getId().toString()));//retorna lista de coemtnario
        doGet2(request,response,request.getParameter("idPersonagem"));//chama doGet2
    }
}

