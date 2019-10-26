/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.marvelShopp.dao;

import br.com.marvelShopp.model.Carrinho;
import br.com.marvelShopp.model.Personagem;
import br.com.marvelShopp.model.Usuario;
import br.com.marvelShopp.utilitarios.Conexao;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gleison
 */
public class CarrinhoDao {
    
    public String create (String idItem, String idPedido){
        String pedidoId = idPedido;
        Connection con = Conexao.getConnection(); //cria uma conexao
        PreparedStatement stmItem= null; //cria uma variavel para execução de SQL. Evitar ataques de Injeção de SQL. Mais eficiente
        PreparedStatement stmPedido= null;
        PreparedStatement stmItemPedido= null;
        try {
            stmItem = con.prepareStatement("INSERT INTO item(personagem,qtd) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);
            stmPedido = con.prepareStatement("INSERT INTO pedido(dt_inicio) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
            stmItemPedido = con.prepareStatement("INSERT INTO item_pedido(item, pedido) VALUES (?,?)");
            
            stmItem.setString(1, idItem);
            stmItem.setInt(2, 1);
            stmItem.executeUpdate();//executa o comando SQL
            final ResultSet rsItem = stmItem.getGeneratedKeys();
            String itemId = "";
            if (rsItem.next()) { // Como pegar o id que acabou de ser criado na tabela item?
               itemId = rsItem.getString(1);
            } 
            
            stmPedido.setString(1, "20191024");
            stmPedido.executeUpdate();//executa o comando SQL
            final ResultSet rsPedido = stmPedido.getGeneratedKeys();
            if(pedidoId == null){
                if (rsPedido.next()) { // Como pegar o id que acabou de ser criado na tabela item?
                   pedidoId = rsPedido.getString(1);
                } 
            }
            
            stmItemPedido.setString(1,itemId);
            stmItemPedido.setString(2,pedidoId);
            stmItemPedido.executeUpdate();//executa o comando SQL
            
        }
        catch (SQLException ex) {
            Logger.getLogger(Personagem.class.getName()).log(Level.SEVERE, null, ex);
        } 
        finally{
            Conexao.closeConnection(con, stmItem);
            Conexao.closeConnection(con, stmPedido);
            Conexao.closeConnection(con, stmItemPedido);
        }
        return pedidoId; //retorna o id de pedido para salvar na sessão
    }
    
    public void delete (String idItem, String idPedido){
        Connection con = Conexao.getConnection();
        PreparedStatement deleteItemPedido; 
        PreparedStatement deleteItem;
        PreparedStatement deletePedido;
        ResultSet resultado = null;
        
        try{
            deleteItemPedido = con.prepareStatement("delete from item_pedido \n" +
                                                    "where item_pedido.id = (select ip.id\n" +
                                                                "from item_pedido ip, pedido p, usuario u, item i, personagem pe\n" +
                                                                "where ip.pedido = p.id\n" +
                                                                "and p.id = ?\n" +
                                                                "and ip.item = i.id\n" +
                                                                "and i.personagem = pe.id\n" +
                                                                "and pe.id = ? );");
            deleteItemPedido.setString(1, idPedido);
            deleteItemPedido.setString(2, idItem);
            deleteItemPedido.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("Driver nao pode ser carregado:"+ex);
        } finally{
            Conexao.closeConnection(con, null, resultado);
        }
    }

    
    public List<Carrinho> list(Usuario user){
        Connection con = Conexao.getConnection(); //cria uma conexao
        PreparedStatement stm; //cria uma variavel para execução de SQL
        ResultSet resultado = null; //interface utilizada pra guardar dados vindos de um banco de dados
        List<Carrinho> listaItensPedidos = new ArrayList();
        try{
            stm = con.prepareStatement("select p.identidade, p.nome_real, p.preco, p.imagem_ref\n" +
                                         "from personagem p, item i, item_pedido ip, pedido ped, usuario u\n" +
                                         "where p.id = i.personagem\n" +
                                         "  and i.id = ip.item\n" +
                                         "  and ip.pedido = ped.id\n" +
                                         "  and ped.usuario = u.id\n" +
                                         "  and u.id =?;");//cria uma instância de Statement para execução de SQL
            stm.setLong(1,user.getId());
            resultado = stm.executeQuery();
            while(resultado.next()) {       
                Personagem personagem = new Personagem();
                Carrinho item= new Carrinho();//cria um item
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
}
