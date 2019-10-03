/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.marvelShopp.dao;

import br.com.marvelShopp.model.TipoCategoria;
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
public class TipoCategoriaDao {
    
    public void create(){
        Connection con = Conexao.getConnection();
        PreparedStatement stm = null;
        
        try {
            stm = con.prepareStatement("INSERT INTO tipo_categoria(nome) VALUES(?)");
            stm.setString(1,"mais um");
            stm.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(TipoSexoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            Conexao.closeConnection(con, stm);
        }
    }
    
    public TipoCategoria getById ( String id){
//        Long id = Long.parseLong(idSTR);
        Connection con = Conexao.getConnection();
        PreparedStatement stm; 
        ResultSet resultado = null;
        TipoCategoria categoria = new TipoCategoria();
        try{
             stm = con.prepareStatement("select * from tipo_categoria where id =?");
             stm.setString(1, id);
             resultado = stm.executeQuery();
             while(resultado.next()){
                categoria.setId(resultado.getLong("id"));
                categoria.setNome(resultado.getString("nome"));
             }
        } catch (SQLException ex) {
            System.out.println("Driver nao pode ser carregado:"+ex);
        } finally{
            Conexao.closeConnection(con, null, resultado);
        }
        return categoria;
    }
    
    public List<TipoCategoria> list(){
        Connection con = Conexao.getConnection();
        Statement st;
        ResultSet resultado = null;
        List<TipoCategoria> listaCategoria = new ArrayList();
        try{
             st = con.createStatement();
             resultado = st.executeQuery("select * from tipo_categoria");
        
            while(resultado.next()) {

                TipoCategoria categoria = new TipoCategoria();


                categoria.setId(resultado.getLong("id"));
                categoria.setNome(resultado.getString("nome"));

                listaCategoria.add(categoria);
           }
        } catch (SQLException ex) {
            System.out.println("Driver nao pode ser carregado:"+ex);
        } finally{
            Conexao.closeConnection(con, null, resultado);
        }

        return listaCategoria;
   }
}
