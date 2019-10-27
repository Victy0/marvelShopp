/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.marvelShopp.dao;

import br.com.marvelShopp.model.TipoPagamento;
import br.com.marvelShopp.utilitarios.Conexao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Victor
 */
public class TipoPagamentoDao {
    
    //recuperar todos os TipoPagamento cadastrados na tabela 'tipo_pagamento'
    public List<TipoPagamento> list(){
        Connection con = Conexao.getConnection();
        Statement st;
        ResultSet resultado = null;
        List<TipoPagamento> listaPagamento = new ArrayList();
        try{
            st = con.createStatement();
            resultado = st.executeQuery("select * from tipo_pagamento");  
            while(resultado.next()) {
                TipoPagamento pagamento = new TipoPagamento();
                pagamento.setId(resultado.getLong("id"));
                pagamento.setNome(resultado.getString("nome"));
                listaPagamento.add(pagamento);
           }
        } catch (SQLException ex) {
            System.out.println("Driver nao pode ser carregado!");
        } finally{
            Conexao.closeConnection(con, null, resultado);
        }
        return listaPagamento;
   }
    
   //recuperar TipoPagamento informando o 'id' do mesmo da tabela 'tipo_pagamento'
    public TipoPagamento getById ( String id){
        Connection con = Conexao.getConnection();
        PreparedStatement stm;
        ResultSet resultado = null;
        TipoPagamento pagamento = new TipoPagamento();
        try{
            stm = con.prepareStatement("select * from tipo_pagamento where id =?");  
            stm.setString(1, id);
            resultado = stm.executeQuery();
            while(resultado.next()){
                pagamento.setId(resultado.getLong("id"));
                pagamento.setNome(resultado.getString("nome"));
            }
        } catch (SQLException ex) {
            System.out.println("Driver não pôde ser carregado:"+ex);
        } finally{
            Conexao.closeConnection(con, null, resultado);
        }
        return pagamento;
    }
}
