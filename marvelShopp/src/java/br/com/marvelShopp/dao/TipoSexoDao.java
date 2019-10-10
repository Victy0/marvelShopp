/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.marvelShopp.dao;

import br.com.marvelShopp.model.TipoSexo;
import br.com.marvelShopp.utilitarios.Conexao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Victor
 */
public class TipoSexoDao {
    
    
    public void create(){
        Connection con = Conexao.getConnection();
        PreparedStatement stm = null;
        
        try {
            stm = con.prepareStatement("INSERT INTO tipo_sexo(nome) VALUES(?)");
            stm.setString(1,"mais um");
            stm.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(TipoSexoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            Conexao.closeConnection(con, stm);
        }
    }

     public TipoSexo getById ( String id){
        Connection con = Conexao.getConnection();
        PreparedStatement stm;
        ResultSet resultado = null;
        TipoSexo sexo = new TipoSexo();
        try{
            stm = con.prepareStatement("select * from tipo_sexo where id =?");
            stm.setString(1, id);
            resultado = stm.executeQuery();
            while(resultado.next()){
                sexo.setId(resultado.getLong("id"));
                sexo.setNome(resultado.getString("nome"));
            }
        } catch (SQLException ex) {
            System.out.println("Driver nao pode ser carregado:"+ex);
        } finally{
            Conexao.closeConnection(con, null, resultado);
        }
        return sexo;
    }
    
     
     
     public List<TipoSexo> list(){
        Connection con = Conexao.getConnection();
        Statement st;
        ResultSet resultado = null;
        List<TipoSexo> listaSexo = new ArrayList();
        try{
             st = con.createStatement();
             //executa consulta e armazena dados
             resultado = st.executeQuery("select * from tipo_sexo");
        
            while(resultado.next()) {
                //Instanciando a classe Telefone
                TipoSexo sexo = new TipoSexo();
                sexo.setId(resultado.getLong("id"));
                sexo.setNome(resultado.getString("nome"));
                listaSexo.add(sexo);
           }
        } catch (SQLException ex) {
            System.out.println("Driver nao pode ser carregado!");
        } finally{
            Conexao.closeConnection(con, null, resultado);
        }
        return listaSexo;
   }
}




