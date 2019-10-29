package br.com.marvelShopp.controller;

import br.com.marvelShopp.dao.CarrinhoDao;
import br.com.marvelShopp.dao.PersonagemDao;
import br.com.marvelShopp.model.Carrinho;
import br.com.marvelShopp.model.Item;
import br.com.marvelShopp.model.Personagem;
import br.com.marvelShopp.model.Usuario;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gleison
 */
@WebServlet(name = "CarrinhoController", urlPatterns = {"/CarrinhoController"})
public class CarrinhoController extends HttpServlet {
    CarrinhoDao carrinhoDao;//instancia um carrinho
    PersonagemDao personagemDao = new PersonagemDao();//instancia um personagem
    
    public CarrinhoController() {
        super();
        carrinhoDao = new CarrinhoDao();//cria um carrinho
    }

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
        Usuario loginUser = (Usuario)request.getSession().getAttribute("user");//pega o usuario da seção
        String funcao = request.getParameter("funcao");//cria uma variaval que vai indicar a ação do doGet
        String idPersonagem = request.getParameter("idPersonagem");//pega o id do personagem
        Carrinho carrinho = (Carrinho)request.getSession().getAttribute("carrinho");//pega o carrinho da seção
        if(funcao!=null){//se funcao for diferente de null
            Personagem persona = personagemDao.getById(idPersonagem);//busca um personagem no banco
            Item atualizarItem = confereItens(carrinho, persona, request.getParameter("op"));//chama a função confereItens (A ultima função)
            carrinhoDao.atualizaItem(atualizarItem.getId().toString(), atualizarItem.getQtd());   //altera a quantidade de itens
        }else{//se funcao for igual a null
            request.setAttribute("comentList", carrinhoDao.listItensByUser(loginUser));//lista de itens de um usuario
        }
        
        RequestDispatcher view = request.getRequestDispatcher("/carrinho.jsp");//redireciona para pagina de carrinho do usuario
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
        String funcao = request.getParameter("funcao");
        String page = request.getParameter("page");
        String idPersonagem = request.getParameter("idPersonagem");
        Carrinho carrinho = (Carrinho)request.getSession().getAttribute("carrinho");
        
        if(funcao.equals("delete")){ //se a variavel funcao for igual a delete
            String idItem = (String)request.getParameter("itemRemove");//pega o id do item a removido
            carrinhoDao.deleteItem(idItem, carrinho.getId().toString());//deleta o item do banco
            Long itemId = Long.parseLong(idItem);//passa itemId para long
            carrinho.removeItem(itemId);//removem o item do carrinho
            if(carrinho.getItens().isEmpty()){//se o carrinho estiver vazio deleta ele
                carrinhoDao.delete(carrinho.getId());
                carrinho = null;
            }
        }        
        
        if(funcao.equals("create")){//se a variavel funcao for igual a create
            if(carrinho != null){//se carrinho nao for null
                Item item = new Item();
                Personagem persona = personagemDao.getById(idPersonagem);//pega o personagem no banco
                Item atualizarItem = confereItens(carrinho, persona, null);//verifica se um item esta no carrinho
                if(atualizarItem.getId() == null){
                    item.setPersonagem(persona);
                    item.setQtd(1);
                    item = carrinhoDao.saveItem(item, carrinho.getId());
                    carrinho.insereItemLista(item);
                }else{
                    carrinhoDao.atualizaItem(atualizarItem.getId().toString(), atualizarItem.getQtd());
                }
            }else{
                Usuario usuario = (Usuario)request.getSession().getAttribute("user");
                Long idUser = null;
                if(usuario != null){
                    idUser = usuario.getId();
                }
                carrinho = carrinhoDao.create(idPersonagem, idUser);
            }
        }
        request.getSession().removeAttribute("carrinho");
                request.getSession().setAttribute("carrinho", carrinho);
        if(page != null){
                request.getRequestDispatcher("repass.jsp").forward(request, response);
            }else{
        RequestDispatcher view = request.getRequestDispatcher("carrinho.jsp");
        view.forward(request, response);
        }
    }

   private Item confereItens(Carrinho carrinho, Personagem persona, String op){
       Item idItem = new Item();
       for(Item item : carrinho.getItens() ){
           if(item.getPersonagem().getIdentidade().equals(persona.getIdentidade())){
               idItem.setId(item.getId());
               if(op==null){
                   idItem.setQtd(item.getQtd()+1);
               item.setQtd(item.getQtd()+1);
               }else{
                  idItem.setQtd(item.getQtd()-1);
               item.setQtd(item.getQtd()-1); 
               }
           }
       }
       return idItem;
   }
}
