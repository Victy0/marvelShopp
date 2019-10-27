/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.marvelShopp.dao;

import br.com.marvelShopp.model.Carrinho;
import br.com.marvelShopp.model.Item;
import br.com.marvelShopp.model.Personagem;
import br.com.marvelShopp.model.Usuario;
import br.com.marvelShopp.utilitarios.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gleison
 */
public class CarrinhoDao {
    
    PersonagemDao personaDao = new PersonagemDao();
    
    public Carrinho create (String idPersonagem, Long idUser){
        Carrinho carrinho = new Carrinho();
        Connection con = Conexao.getConnection(); //cria uma conexao
        PreparedStatement stmItem= null; //cria uma variavel para execução de SQL. Evitar ataques de Injeção de SQL. Mais eficiente
        PreparedStatement stmPedido= null;
        PreparedStatement stmItemPedido = null;
        try {
            Date now = new Date();
            String dt_inicio = ""+(now.getYear()+1900)+(now.getMonth()+1)+now.getDate();
            if(idUser == null){
                stmPedido = con.prepareStatement("INSERT INTO pedido(dt_inicio) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
                stmPedido.setString(1, dt_inicio);
            }else{
                stmPedido = con.prepareStatement("INSERT INTO pedido(dt_inicio, usuario) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);
                stmPedido.setString(1, dt_inicio); 
                stmPedido.setLong(2, idUser); 
            }
            stmPedido.executeUpdate();//executa o comando SQL
            final ResultSet rsPedido = stmPedido.getGeneratedKeys();
            String pedidoId = "";
                if (rsPedido.next()) { // Como pegar o id que acabou de ser criado na tabela item?
                   pedidoId = rsPedido.getString(1);
                } 
            carrinho.setId(Long.parseLong(pedidoId));
            carrinho.setDtInicio(now.toString());
            
            Item item = new Item();
            Personagem persona = personaDao.getById(idPersonagem);
            item.setPersonagem(persona);
            item.setQtd(1);
            stmItem = con.prepareStatement("INSERT INTO item(personagem,qtd) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);
            stmItem.setString(1, idPersonagem);
            stmItem.setInt(2, item.getQtd());
            stmItem.executeUpdate();//executa o comando SQL
            final ResultSet rsItem = stmItem.getGeneratedKeys();
            String itemId = "";
            if (rsItem.next()) { // Como pegar o id que acabou de ser criado na tabela item?
               itemId = rsItem.getString(1);
            } 
            item.setId(Long.parseLong(itemId));
        carrinho.insereItemLista(item);
            
            stmItemPedido = con.prepareStatement("INSERT INTO item_pedido(pedido,item) VALUES (?,?)");
            stmItemPedido.setLong(1, carrinho.getId());
            stmItemPedido.setLong(2, item.getId());
            stmItemPedido.executeUpdate();
        }
        catch (SQLException ex) {
            Logger.getLogger(Personagem.class.getName()).log(Level.SEVERE, null, ex);
        } 
        finally{
            Conexao.closeConnection(con, stmItem);
            Conexao.closeConnection(con, stmPedido);
        }
        return carrinho; //retorna o id de pedido para salvar na sessão
    }
    
    public void delete (String idItem, String idPedido){
        Connection con = Conexao.getConnection();
        PreparedStatement deleteItemPedido; 
        PreparedStatement deleteItem;
        ResultSet resultado = null;
        
        try{
            deleteItem = con.prepareStatement("DELETE FROM item \n" +
                                                    "where id = ?;");
            deleteItem.setString(1, idItem);
            deleteItem.executeUpdate();
            
            deleteItemPedido = con.prepareStatement("DELETE FROM item_pedido WHERE id=?;");
            deleteItemPedido.setString(1, idPedido);
            deleteItemPedido.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("Driver nao pode ser carregado:"+ex);
        } finally{
            Conexao.closeConnection(con, null, resultado);
        }
    }

    public Carrinho getByUser(Usuario user){
        Connection con = Conexao.getConnection(); //cria uma conexao
        PreparedStatement stm; //cria uma variavel para execução de SQL
        ResultSet resultado = null;
        Carrinho carrinho = new Carrinho();
        try{
            if(user!= null){
                stm = con.prepareStatement("select p.id, p.status, p.dt_inicio \n" +
                                             "from pedido p\n" +
                                             "where p.usuario = ?\n" +
                                             "  and p.status = 'aberto';");//cria uma instância de Statement para execução de SQL
                stm.setLong(1,user.getId());
                resultado = stm.executeQuery();
                while(resultado.next()) {
                    carrinho.setId(resultado.getLong("id"));
                    carrinho.setStatus(resultado.getString("status"));
                    carrinho.setDtInicio(resultado.getString("dt_inicio"));
                    carrinho.setUsuario(user);
                }
                stm = con.prepareStatement("select i.id, i.personagem, i.qtd \n" +
                                             "from item i, item_pedido ip\n" +
                                             "where ip.pedido = "+carrinho.getId()+" and i.id=ip.item;");
                resultado = stm.executeQuery();
                while(resultado.next()) {
                    Item item = new Item();
                    item.setId(resultado.getLong("id"));
                    item.setQtd(resultado.getInt("qtd"));
                    Personagem persona = personaDao.getById(resultado.getString("personagem"));
                    item.setPersonagem(persona);
                    carrinho.insereItemLista(item);
                }
                
            }
        }catch (SQLException ex) {
            System.out.println("Driver não pôde ser carregado!");
        } 
        finally{
            Conexao.closeConnection(con, null, resultado);
        }                
        return carrinho;
    }
    
    public List<Item> list(Usuario user){
        Connection con = Conexao.getConnection(); //cria uma conexao
        PreparedStatement stm; //cria uma variavel para execução de SQL
        ResultSet resultado = null; //interface utilizada pra guardar dados vindos de um banco de dados
        List<Item> listaItensPedidos = new ArrayList();
        try{
            if(user!= null){
                stm = con.prepareStatement("select p.identidade, p.nome_real, p.preco, p.imagem_ref\n" +
                                             "from personagem p, item i, item_pedido ip, pedido ped, usuario u\n" +
                                             "where p.id = i.personagem\n" +
                                             "  and i.id = ip.item\n" +
                                             "  and ip.pedido = ped.id\n" +
                                             "  and ped.usuario = u.id\n" +
                                             "  and u.id =?;");//cria uma instância de Statement para execução de SQL
                stm.setLong(1,user.getId());
                resultado = stm.executeQuery();
            }
            if(user== null){
                stm = con.prepareStatement("select p.identidade, p.nome_real, p.preco, p.imagem_ref\n" +
                                             "from personagem p, item i, item_pedido ip, pedido ped, usuario u\n" +
                                             "where p.id = i.personagem\n" +
                                             "  and i.id = ip.item\n" +
                                             "  and ip.pedido = ped.id\n" +
                                             "  and ped.usuario is null;");//cria uma instância de Statement para execução de SQL
                resultado = stm.executeQuery();
            }
            
            while(resultado.next()) {       
                Personagem personagem = new Personagem();
                Item item= new Item();//cria um item
                item.personagem = personagem;
                item.personagem.setIdentidade(resultado.getString("identidade"));
                item.personagem.setNomeReal(resultado.getString("nome_real"));
                item.personagem.setPreco(resultado.getDouble("preco"));
                item.personagem.setImagemRef(resultado.getString("imagem_ref"));               

                listaItensPedidos.add(item);//salva o item na lista criada
            }
            
        } 
        catch (SQLException ex) {
            System.out.println("Driver nao pode ser carregado!");
        } 
        finally{
            Conexao.closeConnection(con, null, resultado);
        }                
        return listaItensPedidos;
    }
    
    public Item saveItem(Item item, Long idPedido){
        String itemId = "";
        Connection con = Conexao.getConnection(); //cria uma conexao
        PreparedStatement stm; //cria uma variavel para execução de SQL
        ResultSet resultado = null; //interface utilizada pra guardar dados vindos de um banco de dados
        try{
            stm = con.prepareStatement("INSERT INTO item(personagem,qtd) VALUES(?,?)", Statement.RETURN_GENERATED_KEYS);
            stm.setString(1, item.getPersonagem().getId().toString());
            stm.setInt(2, item.getQtd());
            stm.executeUpdate();
            final ResultSet rsItem = stm.getGeneratedKeys();
            if (rsItem.next()) { // Como pegar o id que acabou de ser criado na tabela item?
               itemId = rsItem.getString(1);
            } 
            
            stm = con.prepareStatement("INSERT INTO item_pedido(item, pedido) VALUES(?,?)");
            stm.setString(1, itemId);
            stm.setLong(2, idPedido);
            stm.executeUpdate();
        } 
        catch (SQLException ex) {
            System.out.println("Driver nao pode ser carregado!");
        } 
        finally{
            Conexao.closeConnection(con, null, resultado);
        } 
        item.setId(Long.parseLong(itemId));
        return item;
    }
    
    public void setUser(Long idUser, Long idPedido){
        Connection con = Conexao.getConnection(); //cria uma conexao
        PreparedStatement stm; //cria uma variavel para execução de SQL
        ResultSet resultado = null; //interface utilizada pra guardar dados vindos de um banco de dados
        try{
            stm = con.prepareStatement("UPDATE pedido SET status='abandonado' WHERE usuario=? and status='aberto'");
            stm.setLong(1, idUser);
            stm.executeUpdate();
            
            stm = con.prepareStatement("UPDATE pedido SET usuario=? WHERE id=?");
            stm.setLong(1, idUser);
            stm.setLong(2, idPedido);
            stm.executeUpdate();
        } 
        catch (SQLException ex) {
            System.out.println("Driver nao pode ser carregado!");
        } 
        finally{
            Conexao.closeConnection(con, null, resultado);
        } 
    }
    
//    public List<Carrinho> listPedidos(Usuario user){
//        Connection con = Conexao.getConnection(); //cria uma conexao
//        PreparedStatement stm; //cria uma variavel para execução de SQL
//        ResultSet resultado = null;
//        List<Carrinho> carrinhoList = new ArrayList();
//        try{
//            stm = con.prepareStatement("select * \n" +
//                                        "from pedido p\n" +
//                                        "where p.usuario = ?\n" +
//                                        "  and p.status = 'aberto';");//cria uma instância de Statement para execução de SQL
//                stm.setLong(1,user.getId());
//                resultado = stm.executeQuery();
//                while(resultado.next()) {
//                    Carrinho carrinho = new Carrinho();
//                    carrinho.setId(resultado.getLong("id"));
//                    carrinho.setStatus(resultado.getString("status"));
//                    carrinho.setDtInicio(resultado.getString("dt_inicio"));
//                    carrinho.setUsuario(user);
//                    carrinho.setEndereco()
//                }
//                stm = con.prepareStatement("select i.id, i.personagem, i.qtd \n" +
//                                             "from item i, item_pedido ip\n" +
//                                             "where ip.pedido = "+carrinho.getId()+" and i.id=ip.item;");
//                resultado = stm.executeQuery();
//                while(resultado.next()) {
//                    Item item = new Item();
//                    item.setId(resultado.getLong("id"));
//                    item.setQtd(resultado.getInt("qtd"));
//                    Personagem persona = personaDao.getById(resultado.getString("personagem"));
//                    item.setPersonagem(persona);
//                    carrinho.insereItemLista(item);
//                }
//                
//        }catch (SQLException ex) {
//            System.out.println("Driver não pôde ser carregado!");
//        } 
//        finally{
//            Conexao.closeConnection(con, null, resultado);
//        }                
//        return carrinhoList;
//    }

}
