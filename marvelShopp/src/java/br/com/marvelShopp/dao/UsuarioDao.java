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
 * @author victo
 */
//Classe referente a manipulação banco de dados e Usuario
public class UsuarioDao {
    
    //inserir novo usuário na tabela 'usuario'
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
     
    //recuperar Usuario informando o 'id' do mesmo
    public Usuario getById (String id){
        Connection con = Conexao.getConnection();
        PreparedStatement stm; 
        ResultSet resultado = null;
        Usuario usuario = new Usuario();
        
        try{
            stm = con.prepareStatement("select * from usuario where id = ?");
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
    
    //validar se Usuario existe no banco de dados através de seu email e senha para Login
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
               usuario.setHasAdm(resultado.getBoolean("has_adm"));
            }
        } catch (SQLException ex) {
            System.out.println("Driver nao pode ser carregado:"+ex);
        } finally{
            Conexao.closeConnection(con, null, resultado);
        }
        return usuario;
    } 
}
    

