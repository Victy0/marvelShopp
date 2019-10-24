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
    
    public void create (int idItem, int idUser){
        Connection con = Conexao.getConnection(); //cria uma conexao
        PreparedStatement stmItem= null; //cria uma variavel para execução de SQL. Evitar ataques de Injeção de SQL. Mais eficiente
        PreparedStatement stmPedido= null;
        PreparedStatement stmItemPedido= null;
        try {
            stmItem = con.prepareStatement("INSERT INTO item(personagem,quantidade) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);
            stmPedido = con.prepareStatement("INSERT INTO pedido(usuario,dt_inicio,status) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            stmItemPedido = con.prepareStatement("INSERT INTO item(item,pedido) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);
            
            stmItem.setLong(1, idItem);
            stmItem.setInt(2, 1);
            stmItem.executeUpdate();//executa o comando SQL
            
            stmPedido.setLong(1, idUser);
            stmPedido.setString(2, "20191024");
            stmPedido.setString(3, "testes");
            stmPedido.executeUpdate();//executa o comando SQL
            
            final ResultSet rsItem = stmItem.getGeneratedKeys();
            final ResultSet rsPedido = stmPedido.getGeneratedKeys();
            
            stmItemPedido.setLong(1, rsItem.getInt("id"));// Como pegar o id que acabou de ser criado na tabela item?
            stmItemPedido.setLong(2, rsPedido.getInt("id"));// Como pegar o id que acabou de ser criado na tabela pedido?
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
