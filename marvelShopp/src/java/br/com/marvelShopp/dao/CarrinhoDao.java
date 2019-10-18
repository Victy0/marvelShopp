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
    
    public void create (Carrinho item, Usuario cliente, String qtd, String status){
        Connection con = Conexao.getConnection(); //cria uma conexao
        PreparedStatement stmItem= null; //cria uma variavel para execução de SQL. Evitar ataques de Injeção de SQL. Mais eficiente
        PreparedStatement stmPedido= null;
        PreparedStatement stmItemPedido= null;
        try {
            stmItem = con.prepareStatement("INSERT INTO item(personagem,quantidade) VALUES (?,?)");
            stmPedido = con.prepareStatement("INSERT INTO pedido(usuario,dt_inicio,status) VALUES (?,?,?)");
            stmItemPedido = con.prepareStatement("INSERT INTO item(item,pedido) VALUES (?,?)");
            
            stmItem.setLong(1, item.getId());
            stmItem.setInt(2, item.getQtd());
            stmPedido.setLong(1, cliente.getId());
            stmPedido.setString(2, "20191012");
            stmPedido.setString(3, status);
            
            stmItem.executeUpdate();//executa o comando SQL
            stmPedido.executeUpdate();//executa o comando SQL
            
            stmItemPedido.setLong(1, 1);// Como pegar o id que acabou de ser criado na tabela item?
            stmItemPedido.setLong(2, 1);// Como pegar o id que acabou de ser criado na tabela pedido?
            
            stmItem.executeUpdate();//executa o comando SQL
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
    
    public List<Carrinho> list(){
        Connection con = Conexao.getConnection(); //cria uma conexao
        Statement stm; //cria uma variavel para execução de SQL
        ResultSet resultado = null; //interface utilizada pra guardar dados vindos de um banco de dados
        List<Carrinho> listaItensPedidos = new ArrayList();
        try{
            stm = con.createStatement();//cria uma instância de Statement para execução de SQL
            resultado = stm.executeQuery("select p.identidade, p.nome_real, p.preco, p.imagem_ref\n" +
                                         "from personagem p, item i, item_pedido ip, pedido ped, usuario u\n" +
                                         "where p.id = i.personagem\n" +
                                         "  and i.id = ip.item\n" +
                                         "  and ip.pedido = ped.id\n" +
                                         "  and ped.usuario = u.id\n" +
                                         "  and u.id = 1;");//executa consulta e armazena dados      
            
            while(resultado.next()) {                
                Carrinho item= new Carrinho();//cria um item
                item.setIdentidade(resultado.getString("identidade"));
                item.setNomeReal(resultado.getString("nome_real"));
                item.setPreco(resultado.getDouble("preco"));
                item.setImagemRef(resultado.getString("imagem_ref"));               

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
