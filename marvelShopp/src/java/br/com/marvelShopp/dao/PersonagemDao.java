package br.com.marvelShopp.dao;

import br.com.marvelShopp.model.Personagem;
import br.com.marvelShopp.utilitarios.Conexao;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Victor
 */
//Classe referente a manipulação banco de dados e Personagem
public class PersonagemDao {
    
    ComentariosDao comentarioDao = new ComentariosDao();
    
    //insere um novo tipo de sexo na tabela 'personagem'
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
     
    //recuperar Personagem informando o 'id' do mesmo da tabela 'personagem'
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
                personagem.setCategoria(tcd.getById(resultado.getString("categoria")));
                personagem.setDescricao(resultado.getString("descricao"));
                personagem.setPreco(resultado.getDouble("preco"));
                personagem.setOcupacao(tod.getById(resultado.getString("ocupacao")));
                personagem.setSexo(tsd.getById(resultado.getString("sexo")));
                personagem.setLugar(resultado.getString("lugar"));
                personagem.setImagemRef(resultado.getString("imagem_ref"));
                personagem.setQtdEstoque(resultado.getInt("qtd_estoque"));
            }
        } catch (SQLException ex) {
            System.out.println("Driver nao pode ser carregado:"+ex);
        } finally{
            Conexao.closeConnection(con, null, resultado);
        }
        return personagem;
    }
    
    //recuperar lista de Personagem a partir do termo pesquisado
    //inclusão de limit e offset para paginação da lista no JSP
    public List<Personagem> busca(String termo, String limit, String offset)
    {
        Connection con = Conexao.getConnection();
        PreparedStatement stm = null;
        ResultSet resultado = null;
        List<Personagem> listaPersonagem = new ArrayList();
        TipoCategoriaDao tcd = new TipoCategoriaDao();
        TipoOcupacaoDao tod = new TipoOcupacaoDao();
        TipoSexoDao tsd = new TipoSexoDao();
        String prefixo = ("heroi".equals(termo)) ? "'" : "'%";
        termo = prefixo + termo;
        try{
            stm = con.prepareStatement("select * from personagem p, tipo_categoria c, tipo_sexo s, tipo_ocupacao o \n" +
                                        "where (nome_real like " + termo + "%'\n" +
                                        "or identidade like " + termo + "%'\n" +
                                        "or c.nome like " + termo + "%'\n" +
                                        "or o.nome like " + termo + "%'\n" +
                                        "or s.nome like " + termo + "%'\n" +
                                        "or lugar like " + termo + "%')\n" +
                                        "and p.ocupacao=o.id and p.sexo=s.id and p.categoria=c.id"
                                        + " Limit "+limit+" Offset "+offset+";");
            resultado = stm.executeQuery();
            while(resultado.next()){
                Personagem personagem = new Personagem();
                personagem.setId(resultado.getLong("id"));
                personagem.setNomeReal(resultado.getString("nome_real"));
                personagem.setIdentidade(resultado.getString("identidade"));
                personagem.setCategoria(tcd.getById(resultado.getString("categoria")));
                personagem.setDescricao(resultado.getString("descricao"));
                personagem.setPreco(resultado.getDouble("preco"));
                personagem.setOcupacao(tod.getById(resultado.getString("ocupacao")));
                personagem.setSexo(tsd.getById(resultado.getString("sexo")));
                personagem.setLugar(resultado.getString("lugar"));
                personagem.setImagemRef(resultado.getString("imagem_ref"));
                personagem.setQtdEstoque(resultado.getInt("qtd_estoque"));
                personagem.setRank(comentarioDao.getRank(personagem.getId().toString()));
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
    
    //informa quantidade total de Personagem da busca para paginação no JSP
    public int quantidadePersonagem(String termo){
        Connection con = Conexao.getConnection();
        PreparedStatement stm = null;
        ResultSet resultado = null;
        int qtd = 0;
        String prefixo = ("heroi".equals(termo)) ? "'" : "'%";
        termo = prefixo + termo;
        try{
            stm = con.prepareStatement("select count(*) as registros from personagem p, tipo_categoria c, tipo_sexo s, tipo_ocupacao o \n" +
                                        "where 	(nome_real like " + termo + "%'\n" +
                                        "or identidade like " + termo + "%'\n" +
                                        "or c.nome like " + termo + "%'\n" +
                                        "or o.nome like " + termo + "%'\n" +
                                        "or s.nome like " + termo + "%'\n" +
                                        "or lugar like " + termo + "%')\n" +
                                        "and p.ocupacao=o.id and p.sexo=s.id and p.categoria=c.id;");
            resultado = stm.executeQuery();
            while(resultado.next()){
                qtd = resultado.getInt("registros");
            }
        } catch (SQLException ex) {
            System.out.println("Driver não pôde ser carregado: "+ex);
        } finally{
            Conexao.closeConnection(con, null, resultado);
        }
        return qtd;
    }
    
    public void editarPersonagem(Personagem persona){//altera os dados de um personagem
        Connection con = Conexao.getConnection();
        PreparedStatement stm = null;
        try {
            stm = con.prepareStatement("UPDATE personagem\n" +
                                        "SET nome_real = ? , identidade = ?, categoria = ?, descricao = ?, preco = ?,\n" +
                                        "ocupacao = ?, sexo = ?, qtd_estoque = ?, lugar = ?, imagem_ref = ?\n" +
                                        "where id = ?;");
            stm.setString(1,persona.getNomeReal());
            stm.setString(2,persona.getIdentidade());
            stm.setLong(3,persona.getCategoria().getId());
            stm.setString(4,persona.getDescricao());
            stm.setDouble(5,persona.getPreco());
            stm.setLong(6,persona.getOcupacao().getId());
            stm.setLong(7,persona.getSexo().getId());
            stm.setLong(8,persona.getQtdEstoque());
            stm.setString(9,persona.getLugar());
            stm.setString(10,persona.getImagemRef());
            stm.setLong(11,persona.getId());
            stm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(TipoSexoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            Conexao.closeConnection(con, stm);
        }
    }
    //deleta um personagem
    public void deletarPersonagem(String id){
        Connection con = Conexao.getConnection();
        PreparedStatement stm = null;
        try {
            stm = con.prepareStatement("DELETE FROM personagem\n" +
                                        "WHERE id= ?;");            
            stm.setString(1,id);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TipoSexoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            Conexao.closeConnection(con, stm);
        }
    }
    //cria uma lista 6 mais bens avaliados personagens
     public List<Personagem> getTop6(){
        Connection con = Conexao.getConnection();
        Statement stm;
        ResultSet resultado = null;
        List<Personagem> list = new ArrayList();
        Double rank = 0.0;
        try{
            stm = con.createStatement();
            resultado = stm.executeQuery("Select personagem,avg(nota) mRank from comentario group by personagem order by mRank desc limit 6;");
            while(resultado.next()) {
                rank = resultado.getDouble("mrank");
                Personagem persona = getById(resultado.getString("personagem"));
                persona.setRank(rank);
                list.add(persona);
            }
        } catch (SQLException ex){
            System.out.println("Driver nao pode ser carregado!");
        } finally{
            Conexao.closeConnection(con, null, resultado);
        }
        return list;
    }
     
    public void atualizaEstoque(Long idPersonagem, int qtd){
        Connection con = Conexao.getConnection();
        PreparedStatement stm = null;
        try{
            stm = con.prepareStatement("UPDATE personagem SET qtd_estoque="+qtd+" WHERE id="+idPersonagem+";");
            stm.executeUpdate();
        } catch (SQLException ex){
            System.out.println("Driver nao pode ser carregado!");
        } finally{
            Conexao.closeConnection(con);
        }
    }
    
}
