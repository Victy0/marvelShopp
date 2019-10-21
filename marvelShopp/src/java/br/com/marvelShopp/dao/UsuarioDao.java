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
import java.sql.ResultSet;
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
              stm=con.prepareStatement("INSERT INTO usuario(nome,email,senha,cpf,sexo,dt_nascimento,recebe_email) VALUES (?,?,?,?,?,?,?) ");
              String recEmail = "0";
              if(usu.getRecebeEmail()){
                  recEmail = "1";
              }
              stm.setString(1,usu.getNome());
              stm.setString(2, usu.getEmail());
              stm.setString(3, usu.getSenha());
              stm.setString(4, usu.getCpf());
              stm.setString(5, usu.getSexo());
              stm.setString(6,usu.getDt_nascimento());
              stm.setString(7, recEmail);
            stm.executeUpdate();
          }catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            Conexao.closeConnection(con, stm);
        }
       }
     
     public Usuario getById (String id){
        Connection con = Conexao.getConnection();
        PreparedStatement stm; 
        ResultSet resultado = null;
        Usuario usuario = new Usuario();
        
        try{
            stm = con.prepareStatement("select * from suario where id = ?");
            stm.setString(1, id);
            resultado = stm.executeQuery();
            while(resultado.next()){
               usuario.setId(resultado.getLong("id"));
               usuario.setNome(resultado.getString("nome"));
               usuario.setEmail(resultado.getString("email"));
               usuario.setSenha(resultado.getString("senha"));
               usuario.setCpf(resultado.getString("cpf"));
               usuario.setSexo(resultado.getString("sexo"));
               usuario.setDt_nascimento(resultado.getString("dt_nascimento"));
            }
        } catch (SQLException ex) {
            System.out.println("Driver nao pode ser carregado:"+ex);
        } finally{
            Conexao.closeConnection(con, null, resultado);
        }
        return usuario;
    }
     
     public Usuario validateUser (String email, String senha){
        Connection con = Conexao.getConnection();
        PreparedStatement stm; 
        ResultSet resultado = null;
        Usuario usuario = new Usuario();
        
        try{
            stm = con.prepareStatement("select * from usuario where email = ? and senha = ?");
            stm.setString(1, email);
            stm.setString(2,senha);
            resultado = stm.executeQuery();
            while(resultado.next()){
               usuario.setId(resultado.getLong("id"));
               usuario.setNome(resultado.getString("nome"));
               usuario.setEmail(resultado.getString("email"));
               usuario.setSenha(resultado.getString("senha"));
               usuario.setCpf(resultado.getString("cpf"));
               usuario.setSexo(resultado.getString("sexo"));
               usuario.setDt_nascimento(resultado.getString("dt_nascimento"));
            }
        } catch (SQLException ex) {
            System.out.println("Driver nao pode ser carregado:"+ex);
        } finally{
            Conexao.closeConnection(con, null, resultado);
        }
        return usuario;
    } 
}
    

