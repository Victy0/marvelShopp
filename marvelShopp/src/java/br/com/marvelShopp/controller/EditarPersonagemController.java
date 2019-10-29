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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author chris
 */
@WebServlet(name = "EditarPersonagemController", urlPatterns = {"/EditarPersonagemController"})
public class EditarPersonagemController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)//deletar um personagem
            throws ServletException, IOException {
        PersonagemDao personagemDao = new PersonagemDao();//instacia um personagemDao
        String id = request.getParameter("id");//pega o id do personagem
        personagemDao.deletarPersonagem(id);//deleta um personagem
        response.sendRedirect("listaadmin.jsp");//redireciona para listaadm.jsp
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)//edita um personagem
            throws ServletException, IOException {
        Personagem persona = new Personagem();//instacia um personagem
        PersonagemDao personagemDao = new PersonagemDao();//instancia um personagemDao
        TipoCategoriaDao categoriaDao = new TipoCategoriaDao();//instancia um tipoCategoriaDao
        TipoOcupacaoDao ocupacaoDao = new TipoOcupacaoDao();//instancia um tipoOcupacaoDao
        TipoSexoDao sexoDao = new TipoSexoDao();//instancia um tipoSexoDao
        
        TipoCategoria categoria = categoriaDao.getById(request.getParameter("categoria"));//pega o categoria do personagem
        persona.setCategoria(categoria);
        persona.setDescricao(request.getParameter("descricao"));
        persona.setIdentidade(request.getParameter("identidade"));
        persona.setImagemRef(request.getParameter("imagemRef"));
        persona.setLugar(request.getParameter("lugar"));
        persona.setNomeReal(request.getParameter("nomeReal"));
        TipoOcupacao ocupacao= ocupacaoDao.getById(request.getParameter("ocupacao"));//pega a ocupacao do personagem
        persona.setOcupacao(ocupacao);
        persona.setPreco(Double.parseDouble(request.getParameter("preco")));
        persona.setQtdEstoque(Integer.parseInt(request.getParameter("estoque")));
        TipoSexo sexo = sexoDao.getById(request.getParameter("sexo"));
        persona.setSexo(sexo);//pega o sexo do personagem
        Long id = Long.parseLong(request.getParameter("idPersonagem"));
        persona.setId(id);
        
        personagemDao.editarPersonagem(persona);//edita o personagem
        response.sendRedirect("listaadmin.jsp");//redireciona para a pagina do administrador
    }
}
