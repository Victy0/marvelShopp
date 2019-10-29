package br.com.marvelShopp.controller;

import br.com.marvelShopp.dao.PersonagemDao;
import br.com.marvelShopp.dao.TipoCategoriaDao;
import br.com.marvelShopp.dao.TipoOcupacaoDao;
import br.com.marvelShopp.dao.TipoSexoDao;
import br.com.marvelShopp.model.Personagem;
import br.com.marvelShopp.model.TipoCategoria;
import br.com.marvelShopp.model.TipoOcupacao;
import br.com.marvelShopp.model.TipoSexo;
import java.io.IOException;
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
     private TipoCategoriaDao categoriaDao ;
     private PersonagemDao personagemDao;
    
  public PersonagemController(){
      super();
      sexoDao=new TipoSexoDao();
      ocupacaoDao=new TipoOcupacaoDao();
      categoriaDao=new TipoCategoriaDao();
      personagemDao= new PersonagemDao();
      }
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)//cria personagem 
            throws ServletException, IOException {
        
        Personagem persona= new Personagem();
        TipoCategoria categoria = categoriaDao.getById(request.getParameter("categoria"));//pega a categoria
        persona.setCategoria(categoria);
        persona.setDescricao(request.getParameter("descricao"));
        persona.setIdentidade(request.getParameter("identidade"));
        persona.setImagemRef(request.getParameter("imagemRef"));
        persona.setLugar(request.getParameter("lugar"));
        persona.setNomeReal(request.getParameter("nomeReal"));
        TipoOcupacao ocupacao= ocupacaoDao.getById(request.getParameter("ocupacao"));//pega a ocupacao
        persona.setOcupacao(ocupacao);
        persona.setPreco(Double.parseDouble(request.getParameter("preco")));
        persona.setQtdEstoque(Integer.parseInt(request.getParameter("estoque")));
        TipoSexo sexo = sexoDao.getById(request.getParameter("sexo"));//pega o sexo
        persona.setSexo(sexo);
        
        this.personagemDao.create(persona);//cria personagem
        RequestDispatcher view= request.getRequestDispatcher("/cadastroDeProduto.jsp");//redireciona para cadastro de produto
        view.forward(request, response);    
    }
}
