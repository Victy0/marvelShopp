/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.marvelShopp.dao;

import br.com.marvelShopp.model.Personagem;
import br.com.marvelShopp.utilitarios.Conexao;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
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
     
    public Personagem getById ( String id){
        Connection con = Conexao.getConnection();
        PreparedStatement stm; 
        ResultSet resultado = null;
        Personagem personagem = new Personagem();
        TipoCategoriaDao tcd = new TipoCategoriaDao();
        TipoOcupacaoDao tod = new TipoOcupacaoDao();
        TipoSexoDao tsd = new TipoSexoDao();
        
        try{
             stm = con.prepareStatement("select * from personagem where id =?");
             stm.setString(1, id);
             resultado = stm.executeQuery();
             while(resultado.next()){
                personagem.setId(resultado.getLong("id"));
                personagem.setNomeReal(resultado.getString("nome_real"));
                personagem.setIdentidade(resultado.getString("identidade"));
                personagem.setCategoria(tcd.getById(resultado.getString("id")));
                personagem.setDescricao(resultado.getString("descricao"));
                personagem.setPreco(resultado.getDouble("preco"));
                personagem.setOcupacao(tod.getById(resultado.getString("id")));
                personagem.setSexo(tsd.getById(resultado.getString("id")));
                personagem.setLugar(resultado.getString("lugar"));
                personagem.setImagemRef(resultado.getString("imagem_ref"));
             }
        } catch (SQLException ex) {
            System.out.println("Driver nao pode ser carregado:"+ex);
        } finally{
            Conexao.closeConnection(con, null, resultado);
        }
        return personagem;
    }
     
     public List<Personagem> busca(String termo)
     {
         Connection con = Conexao.getConnection();
         PreparedStatement stm = null;
         ResultSet resultado = null;
         List<Personagem> listaPersonagem = new ArrayList();
         
         
         try{
             stm = con.prepareStatement("select * from personagem p, tipo_categoria c, tipo_sexo s, tipo_ocupacao o \n" +
                                        "where 	(nome_real like '%" + termo + "%'\n" +
                                        "or	identidade like '%" + termo + "%'\n" +
                                        "or	c.nome like '%" + termo + "%'\n" +
                                        "or	o.nome like '%" + termo + "%'\n" +
                                        "or	s.nome like '%" + termo + "%'\n" +
                                        "or	lugar like '%" + termo + "%')\n" +
                                        "and p.ocupacao=o.id and p.sexo=s.id and p.categoria=c.id;");
             //for (int i = 1; i <= 6; i++)
             //   stm.setString(i, termo);
             resultado = stm.executeQuery();
             while(resultado.next()){
                Personagem personagem = this.getById(resultado.getString("id"));
                listaPersonagem.add(personagem);
             }
        } catch (SQLException ex) {
            System.out.println("Driver não pôde ser carregado: "+ex);
        } finally{
            Conexao.closeConnection(con, null, resultado);
        }
        Collections.sort(listaPersonagem, java.util.Comparator.comparing(Personagem::getIdentidade));
        return listaPersonagem;
     }
}
