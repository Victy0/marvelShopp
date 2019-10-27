package br.com.marvelShopp.dao;

import br.com.marvelShopp.model.TipoSexo;
import br.com.marvelShopp.utilitarios.Conexao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Victor
 */
//Classe referente a manipulação banco de dados e TipoSexo
public class TipoSexoDao {
    
    //insere um novo tipo de sexo na tabela 'tipo_sexo'
    public void create(TipoSexo ts){
        Connection con = Conexao.getConnection();
        PreparedStatement stm = null;
        try {
            stm = con.prepareStatement("INSERT INTO tipo_sexo(nome) VALUES(?)");
            stm.setString(1,ts.getNome());
            stm.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(TipoSexoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            Conexao.closeConnection(con, stm);
        }
    }
    
    //deleta TipoSexo informando o 'id' do mesmo da tabela 'tipo_sexo'
    public void delete (String id){
        Connection con = Conexao.getConnection();
        PreparedStatement stm; 
        ResultSet resultado = null;
        try{
            stm = con.prepareStatement("delete from tipo_sexo where id =?");
            stm.setString(1, id);
            stm.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("Driver nao pode ser carregado:"+ex);
        } finally{
            Conexao.closeConnection(con, null, resultado);
        }
    }

    //recuperar TipoSexo informando o 'id' do mesmo da tabela 'tipo_sexo'
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
    
     
    //recuperar todos os TipoSexo cadastrados na tabela 'tipo_sexo'
    public List<TipoSexo> list(){
        Connection con = Conexao.getConnection();
        Statement st;
        ResultSet resultado = null;
        List<TipoSexo> listaSexo = new ArrayList();
        try{
            st = con.createStatement();
            resultado = st.executeQuery("select * from tipo_sexo");  
            while(resultado.next()) {
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





