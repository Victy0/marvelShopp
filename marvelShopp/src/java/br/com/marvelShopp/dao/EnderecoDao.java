
package br.com.marvelShopp.dao;

import br.com.marvelShopp.model.Endereco;
import br.com.marvelShopp.model.Usuario;
import br.com.marvelShopp.utilitarios.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EnderecoDao {
    public void inserir (Endereco endereco){
        Connection con = Conexao.getConnection(); //cria uma conexao
        PreparedStatement stmEndereco= null;
        try {
            stmEndereco = con.prepareStatement("INSERT INTO endereco(rua, bairro, cep, numero, complemento, cidade, usuario) "
                                                + "values (?, ?, ?, ?, ?, ?, ?)");
            stmEndereco.setString(1,endereco.getRua());
            stmEndereco.setString(2,endereco.getBairro());
            stmEndereco.setString(3,endereco.getCep());
            stmEndereco.setString(4,endereco.getNumeroCasa());
            stmEndereco.setString(5,endereco.getComplemento());
            stmEndereco.setString(6,endereco.getCidade());
            stmEndereco.setString(7,endereco.getUserId());
            
            stmEndereco.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Endereco getById(String id){
        Endereco endereco = new Endereco();
        Connection con = Conexao.getConnection(); //cria uma conexao
        PreparedStatement stmEndereco= null;
        ResultSet resultado = null;
        try {
            stmEndereco = con.prepareStatement("select * from personagem where id =?");
            stmEndereco.setString(1, id);
            resultado = stmEndereco.executeQuery();
            while(resultado.next()){
                endereco.setId(resultado.getLong("id"));
                endereco.setRua(resultado.getString("rua"));
                endereco.setNumeroCasa(resultado.getString("numero"));
                endereco.setBairro(resultado.getString("bairro"));
                endereco.setComplemento(resultado.getString("complemento"));
                endereco.setCidade(resultado.getString("cidade"));
                endereco.setCep(resultado.getString("cep"));
                endereco.setUserId(resultado.getString("usuario"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return endereco;
    }
}
