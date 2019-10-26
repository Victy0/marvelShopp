package br.com.marvelShopp.dao;

import br.com.marvelShopp.model.TipoOcupacao;
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
//Classe referente a manipulação banco de dados e TipoOcupacao
public class TipoOcupacaoDao {
    
    //insere um novo tipo de sexo na tabela 'tipo_ocupacao'
    public void create(TipoOcupacao to){
        Connection con = Conexao.getConnection();
        PreparedStatement stm = null;
        try {
            stm = con.prepareStatement("INSERT INTO tipo_ocupacao(nome) VALUES(?)");
            stm.setString(1,to.getNome());
            stm.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(TipoSexoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            Conexao.closeConnection(con, stm);
        }
    }
    
    //recuperar TipoOcupacao informando o 'id' do mesmo da tabela 'tipo_ocupacao'
    public TipoOcupacao getById ( String id){
        Connection con = Conexao.getConnection();
        PreparedStatement stm;
        ResultSet resultado = null;
        TipoOcupacao ocupacao = new TipoOcupacao();
        try{
             stm = con.prepareStatement("select * from tipo_ocupacao where id =?");
             stm.setString(1, id);
             resultado = stm.executeQuery();
             while(resultado.next()){
                ocupacao.setId(resultado.getLong("id"));
                ocupacao.setNome(resultado.getString("nome"));
             }
        } catch (SQLException ex) {
            System.out.println("Driver nao pode ser carregado:"+ex);
        } finally{
            Conexao.closeConnection(con, null, resultado);
        }
        return ocupacao;
    } 
    
    //recuperar todos os TipoOcupacao cadastrados na tabela 'tipo_ocupacao'
    public List<TipoOcupacao> list(){
        Connection con = Conexao.getConnection();
        Statement st;
        ResultSet resultado = null;
        List<TipoOcupacao> listaOcupacao = new ArrayList();
        try{
             st = con.createStatement();
             resultado = st.executeQuery("select * from tipo_ocupacao");
            while(resultado.next()) {
                TipoOcupacao ocupacao = new TipoOcupacao();
                ocupacao.setId(resultado.getLong("id"));
                ocupacao.setNome(resultado.getString("nome"));
                listaOcupacao.add(ocupacao);
           }
        } catch (SQLException ex) {
            System.out.println("Driver nao pode ser carregado:"+ex);
        } finally{
            Conexao.closeConnection(con, null, resultado);
        }
        return listaOcupacao;
   }
}
