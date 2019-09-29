/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.marvelShopp.Dao;

import br.com.marvelShopp.model.*;
import br.com.marvelShopp.utilitarios.Conexao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author victo
 */
public class ComentariosDao {
     public void create (Comentarios com){
         Connection con = Conexao.getConnection();
         PreparedStatement stm= null;
          try {
              stm=con.prepareStatement("INSERT INTO comentario(id,descricao,nota,usuario,personagem) VALUES (?,?,?,?,?) ");
              stm.setLong(1,com.getId());
              stm.setString(2,com.getDescricao());
              stm.setInt(3, com.getNota());
              stm.setLong(4, com.getUsuario());
              stm.setLong(5, com.getPersonagem());
            stm.executeUpdate();
          }catch (SQLException ex) {
            Logger.getLogger(Comentarios.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            Conexao.closeConnection(con, stm);
        }
         
         
    }
     
     public List<Comentarios> list(){
        Connection con = Conexao.getConnection();
        Statement stm;
        ResultSet resultado = null;
        List<Comentarios> listaComent = new ArrayList();
        try{
             stm = con.createStatement();
             //executa consulta e armazena dados
             resultado = stm.executeQuery("select * from comentario");
        
            while(resultado.next()) {

                //Instanciando a classe Telefone
                Comentarios coment = new Comentarios();

                coment.setID (resultado.getInt("id"));
                coment.setDescricao(resultado.getString("descricao"));
                coment.setUsuario(resultado.getLong("usuario"));
                coment.setNota (resultado.getInt("nota"));
                coment.setPersonagem(resultado.getLong("personagem"));

                listaComent.add(coment);
           }
        } catch (SQLException ex) {
            System.out.println("Driver nao pode ser carregado!");
        } finally{
            Conexao.closeConnection(con, null, resultado);
        }

        return listaComent;
   }
    
}
