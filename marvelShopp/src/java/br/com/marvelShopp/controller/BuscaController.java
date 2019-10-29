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
        Integer limit = 6;  //limita o numero de Personagem por página
        String numpagina=request.getParameter("numpagina");  //informa o numero da página
            if(numpagina==null){   //considera senda a primeira página se não for especificado
                numpagina="1";
            }
        Integer offset=(Integer.parseInt(numpagina)*limit)-limit;  //define offset para busca no banco
        PersonagemDao personaDao = new PersonagemDao();
        String busca = request.getParameter("busca");   //define o termo de busca
        List<Personagem> lista = personaDao.busca(busca, limit.toString(), offset.toString());  //recupera a lista de Personagens
        request.setAttribute("lista", lista);
        request.setAttribute("limit", limit);
        Integer qtdBusca = personaDao.quantidadePersonagem(request.getParameter("busca"));
        request.setAttribute("qtdBusca", qtdBusca);
        request.setAttribute("busca", busca);
        request.getRequestDispatcher("listaprodutos.jsp").forward(request, response);
    }
    
    
}
