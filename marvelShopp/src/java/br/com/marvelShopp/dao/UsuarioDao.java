/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.marvelShopp.dao;

import br.com.marvelShopp.model.Usuario;

import br.com.marvelShopp.utilitarios.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author victo
 */

    
    public class UsuarioDao {
     public void create (Usuario usu){
         Connection con = Conexao.getConnection();
         PreparedStatement stm= null;
          try {
              stm=con.prepareStatement("INSERT INTO usuario(nome,email,senha,cpf,sexo,dt_nascimento) VALUES (?,?,?,?,?,?) ");
              
              stm.setString(1,usu.getNome());
              stm.setString(2, usu.getEmail());
              stm.setString(3, usu.getSenha());
              stm.setString(4, usu.getCpf());
              stm.setString(5, usu.getSexo());
              stm.setString(6,usu.getDt_nascimento());
            stm.executeUpdate();
          }catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            Conexao.closeConnection(con, stm);
        }
         
         
    }
    }
    

