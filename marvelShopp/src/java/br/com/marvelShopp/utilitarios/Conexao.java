package br.com.marvelShopp.utilitarios;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Victor
 */
//Classe referente a conexão com banco de dados
public class Conexao {
    //propriedades da conexão
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/marvel_shopp?useTimezone=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "root";
    
    //criar e retornar conexão com banco de dados
    public static Connection getConnection(){
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);  
        }catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na conexão:"+ex , ex);
        }
    }
     
    //fechar a conexão estabelecida
    public static void closeConnection(Connection con){
        try { 
            if(con != null){       
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    //fechar a conexão estabelecida com PreparedStatement em aberto
    public static void closeConnection(Connection con, PreparedStatement stmt){
        closeConnection(con);
        try {
            if(stmt != null){
                stmt.close();     //fecha PreparedStatement se este estiver em aberto
            }
        }catch (SQLException ex) {
            System.err.println("Erro:"+ex);
        }       
    } 

    //fechar a conexão estabelecida com PreparedStatement e ResultSet em aberto
    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){
        closeConnection(con, stmt);    //fecha PreparedStatement se este estiver em aberto
        try {
            if(rs != null){
                rs.close();            //fecha ResultSet se este estiver em aberto
        } 
        }catch (SQLException ex) {
            System.err.println("Erro:"+ex);
        }       
    }
}
