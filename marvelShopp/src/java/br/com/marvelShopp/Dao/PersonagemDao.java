/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.marvelShopp.dao;

import br.com.marvelShopp.model.Personagem;
import br.com.marvelShopp.utilities.Conexao;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Victor
 */
public class PersonagemDao {
    
     public void create(Personagem persona){
        Connection con = Conexao.getConnection();
        PreparedStatement stm = null;
        
        try {
            stm = con.prepareStatement("INSERT INTO personagem(categoria, descricao, identidade, imagem_ref, lugar, nome_real, ocupacao, preco, qtd_estoque, sexo) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            stm.setString(1,persona.getCategoria().getId().toString());
            stm.setString(2,persona.getDescricao());
            stm.setString(3,persona.getIdentidade());
            stm.setString(4,persona.getImagemRef());
            stm.setString(5,persona.getLugar());
            stm.setString(6,persona.getNomeReal());
            stm.setString(7,persona.getOcupacao().getId().toString());
            stm.setString(8,persona.getPreco().toString());
            stm.setString(9,persona.getQtdEstoque().toString());
            stm.setString(10,persona.getSexo().getId().toString());
            stm.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(TipoSexoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            Conexao.closeConnection(con, stm);
        }
    }
}
