package br.com.marvelShopp.dao;

import br.com.marvelShopp.model.Carrinho;
import br.com.marvelShopp.model.Item;
import br.com.marvelShopp.utilitarios.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PagamentoDao {
    PersonagemDao personagemDao = new PersonagemDao();
    
    public void create (String idEndereco, String idUser, String formPag, Carrinho carrinho){//atualiza o campo status para fechado, finalizando a compra
        Connection con = Conexao.getConnection(); //cria uma conexao
        PreparedStatement stmPagamento;
        try {
            Date now = new Date();
            String dt_pag = ""+(now.getYear()+1900)+(now.getMonth()+1)+now.getDate();//pega a data e hora do fechamento da compra
            
            stmPagamento = con.prepareStatement("update pedido \n" +
                                                "set usuario = ?, \n" +
                                                "    status = 'fechado',\n" +
                                                "    pagamento = ?,\n" +
                                                "    dt_confirmacao = ?, \n" +
                                                "    endereco_cobranca = ?\n" +
                                                "where id = ?;");                                    
            stmPagamento.setString(1,idUser);
            stmPagamento.setString(2,formPag);
            stmPagamento.setString(3,dt_pag);
            stmPagamento.setString(4,idEndereco);
            stmPagamento.setLong(5,carrinho.getId());
            stmPagamento.executeUpdate();
            
            for(Item item : carrinho.getItens()){       //atualiza o estoque dos personagens
                int newEstoque = item.getPersonagem().getQtdEstoque() - item.getQtd();    //pega novo valor de estoque
                personagemDao.atualizaEstoque(item.getPersonagem().getId(), newEstoque);   //atualiza no banco
            }
 
        } catch (SQLException ex) {
            Logger.getLogger(PagamentoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
