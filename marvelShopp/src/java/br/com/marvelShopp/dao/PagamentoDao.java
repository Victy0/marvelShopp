package br.com.marvelShopp.dao;

import br.com.marvelShopp.model.Endereco;
import br.com.marvelShopp.model.Pagamento;
import br.com.marvelShopp.model.Usuario;
import br.com.marvelShopp.utilitarios.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PagamentoDao {
    public void create (String idEndereco, String idUser, String formPag, String pedidoId){
        Connection con = Conexao.getConnection(); //cria uma conexao
        PreparedStatement stmPagamento= null;
        try {
            Date now = new Date();
            String dt_pag = ""+(now.getYear()+1900)+(now.getMonth()+1)+now.getDate();
            
            stmPagamento = con.prepareStatement("update pedido \n" +
                                                "set usuario = ?, \n" +
                                                "    status = \"Pago\",\n" +
                                                "    pagamento = ?,\n" +
                                                "    dt_confirmacao = ?, \n" +
                                                "    endereco_cobranca = ?\n" +
                                                "where id = ?;");
                                                
            stmPagamento.setString(1,idUser);
            stmPagamento.setString(2,formPag);
            stmPagamento.setString(3,dt_pag);
            stmPagamento.setString(4,idEndereco);
            stmPagamento.setString(5,pedidoId);
            stmPagamento.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(PagamentoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
