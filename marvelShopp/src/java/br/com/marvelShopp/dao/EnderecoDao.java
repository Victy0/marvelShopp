
package br.com.marvelShopp.dao;

import br.com.marvelShopp.model.Endereco;
import br.com.marvelShopp.utilitarios.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EnderecoDao {
    public void inserir (Endereco endereco){//salva o endereço no banco de dados
        Connection con = Conexao.getConnection(); //cria uma conexao
        PreparedStatement stmEndereco;
        String compl="-";
        if(endereco.getComplemento() != null){
            compl = endereco.getComplemento();
        }
        try {
            stmEndereco = con.prepareStatement("INSERT INTO endereco(rua, bairro, cep, numero, complemento, cidade, usuario) "
                                                + "values (?, ?, ?, ?, ?, ?, ?)");
            stmEndereco.setString(1,endereco.getRua());
            stmEndereco.setString(2,endereco.getBairro());
            stmEndereco.setString(3,endereco.getCep());
            stmEndereco.setString(4,endereco.getNumeroCasa());
            stmEndereco.setString(5,compl);
            stmEndereco.setString(6,endereco.getCidade());
            stmEndereco.setString(7,endereco.getUserId());
            
            stmEndereco.executeUpdate();//executa o SQL
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Endereco getById(String id){ //recupera endereço do banco de dados
        Endereco endereco = new Endereco();
        Connection con = Conexao.getConnection(); //cria uma conexao
        PreparedStatement stmEndereco= null;
        ResultSet resultado = null;
        try {
            stmEndereco = con.prepareStatement("select * from endereco where id =?");
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
        return endereco;//retorna um endereço
    }
    
    public List<Endereco> list(String idUser){//salvar em uma lista os endereços de um usuario
        Connection con = Conexao.getConnection(); //cria uma conexao
        PreparedStatement stmEnderecoList; //cria uma variavel para execução de SQL
        ResultSet resultado = null; //interface utilizada pra guardar dados vindos de um banco de dados
        List<Endereco> listaEnderecos = new ArrayList();
        try{
            stmEnderecoList = con.prepareStatement("select * from endereco where usuario =?");
                stmEnderecoList.setString(1,idUser);
                resultado = stmEnderecoList.executeQuery();
            
            while(resultado.next()) {  //insere o resultado da busca no objeto endereço     
                Endereco endereco = new Endereco();
                endereco.setId(resultado.getLong("id"));
                endereco.setRua(resultado.getString("rua"));
                endereco.setNumeroCasa(resultado.getString("numero"));
                endereco.setBairro(resultado.getString("bairro")); 
                endereco.setComplemento(resultado.getString("complemento"));
                endereco.setCidade(resultado.getString("cidade"));
                endereco.setCep(resultado.getString("cep"));
                endereco.setUserId(resultado.getString("usuario"));

                listaEnderecos.add(endereco);//salva o endereço na lista criada
            }
            
        } 
        catch (SQLException ex) {
            System.out.println("Driver nao pode ser carregado!");
        } 
        finally{
            Conexao.closeConnection(con, null, resultado);
        }                
        return listaEnderecos;//retorna a lista de endereços
    }
    
    public void delete(String idEndereco){//deletar um endereço
        Connection con = Conexao.getConnection(); //cria uma conexao
        PreparedStatement stmEnderecoList; //cria uma variavel para execução de SQL
        try{
            stmEnderecoList = con.prepareStatement("DELETE FROM endereco WHERE id=?");//cria uma instância de Statement para execução de SQL
            stmEnderecoList.setString(1,idEndereco);
            stmEnderecoList.executeUpdate();            
        } 
        catch (SQLException ex) {
            System.out.println("Driver nao pode ser carregado!");
        } 
        finally{
            Conexao.closeConnection(con);
        }                
    }
}
