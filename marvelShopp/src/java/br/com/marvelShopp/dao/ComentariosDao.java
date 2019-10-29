package br.com.marvelShopp.dao;

import br.com.marvelShopp.model.Comentarios;
import br.com.marvelShopp.utilitarios.Conexao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * @author victo
 */
//Classe referente a manipulação banco de dados e TipoSexo
public class ComentariosDao {
    
    //insere um novo comentario na tabela 'comentario'
    public void create (Comentarios com){
        Connection con = Conexao.getConnection();
        PreparedStatement stm= null;
        try{
            stm = con.prepareStatement("INSERT INTO comentario(descricao,nota,usuario,personagem) VALUES (?,?,?,?) ");
            stm.setString(1, com.getDescricao());
            stm.setInt(2, com.getNota());
            stm.setLong(3, com.getUsuario().getId());
            stm.setLong(4, com.getPersonagem().getId());
            stm.executeUpdate();
        }catch (SQLException ex) {
            Logger.getLogger(Comentarios.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            Conexao.closeConnection(con, stm);
        }
    }
    
    //recuperar todos os Comentarios de determinado Personagem
    public List<Comentarios> list(String id){
        Connection con = Conexao.getConnection();
        Statement stm;
        ResultSet resultado = null;
        List<Comentarios> listaComent = new ArrayList();
        try{
            stm = con.createStatement();
            resultado = stm.executeQuery("select * from comentario where personagem = " + id);
            while(resultado.next()) {
                Comentarios coment = new Comentarios();
                UsuarioDao usuarioDao = new UsuarioDao();
                coment.setId (resultado.getInt("id"));
                coment.setDescricao(resultado.getString("descricao"));
                coment.setUsuario(usuarioDao.getById(resultado.getString("usuario")));
                coment.setNota(resultado.getInt("nota"));
                listaComent.add(coment);
            }
        } catch (SQLException ex){
            System.out.println("Driver nao pode ser carregado!");
        } finally{
            Conexao.closeConnection(con, null, resultado);
        }
        return listaComent;
   }
    
    public Double getRank(String id){// retorna uma media das avaliacoes de um personagem
        Connection con = Conexao.getConnection();
        Statement stm;
        ResultSet resultado = null;
        Double rank = 0.0;
        try{
            stm = con.createStatement();
            resultado = stm.executeQuery("Select avg(nota) as mrank from comentario  where personagem="+id+" group by personagem");
            while(resultado.next()) {
                rank = resultado.getDouble("mrank");
            }
        } catch (SQLException ex){
            System.out.println("Driver nao pode ser carregado!");
        } finally{
            Conexao.closeConnection(con, null, resultado);
        }
        return rank;
    }
}
