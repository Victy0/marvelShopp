package br.com.marvelShopp.dao;

import br.com.marvelShopp.model.Carrinho;
import br.com.marvelShopp.model.Item;
import br.com.marvelShopp.model.Personagem;
import br.com.marvelShopp.model.Usuario;
import br.com.marvelShopp.utilitarios.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gleison
 */
public class CarrinhoDao {
    
    PersonagemDao personaDao = new PersonagemDao();//instancia o personagemDAO
    EnderecoDao enderecoDao = new EnderecoDao();//instancia o enderecoDAO
    TipoPagamentoDao pagamentoDao = new TipoPagamentoDao();//instancia o pagamentoDAO
    
    public Carrinho create (String idPersonagem, Long idUser){//criar um carrinho
        Carrinho carrinho = new Carrinho();//instancia um carrinho
        Connection con = Conexao.getConnection(); //cria uma conexao
        PreparedStatement stmItem= null; //cria uma variavel para execução de SQL na tabela item. Evitar ataques de Injeção de SQL. Mais eficiente
        PreparedStatement stmPedido= null;//cria uma variavel para execução de SQL na tabela pedido
        PreparedStatement stmItemPedido = null;//cria uma variavel para execução de SQL na tabela item_pedido
        try {
            Date now = new Date();//cria uma variável para capturar a hora atual.
            String dt_inicio = ""+(now.getYear()+1900)+(now.getMonth()+1)+now.getDate();//captura a hora
            if(idUser == null){//verifica se tem um usuário logado, caso não insere so a data atual no pedido
                stmPedido = con.prepareStatement("INSERT INTO pedido(dt_inicio) VALUES (?)", Statement.RETURN_GENERATED_KEYS);//RETURN_GENERATED_KEYS retorna o id que acbou de ser craido na tabela pedido
                stmPedido.setString(1, dt_inicio);//variavel que será inseria no sql
            }else{//se existir o um usuario logado ele insere data e id do usurio
                stmPedido = con.prepareStatement("INSERT INTO pedido(dt_inicio, usuario) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);//RETURN_GENERATED_KEYS retorna o id que acbou de ser craido na tabela pedido
                stmPedido.setString(1, dt_inicio); //variavel que será inseria no sql
                stmPedido.setLong(2, idUser); //variavel que será inseria no sql
            }
            stmPedido.executeUpdate();//executa o comando SQL
            final ResultSet rsPedido = stmPedido.getGeneratedKeys();//cria uma variavel que vai receber o id capturado por RETURN_GENERATED_KEYS
            String pedidoId = "";
                if (rsPedido.next()) { // pega o id que acabou de ser criado e joga na varivel pedidoId
                   pedidoId = rsPedido.getString(1);
                } 
            carrinho.setId(Long.parseLong(pedidoId));//salva o id capturado no carrinho
            carrinho.setDtInicio(now.toString());//salva a data no carrinho
            
            Item item = new Item();//instancia item
            Personagem persona = personaDao.getById(idPersonagem);//intancia personagem
            item.setPersonagem(persona);
            item.setQtd(1);
            stmItem = con.prepareStatement("INSERT INTO item(personagem,qtd) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);//RETURN_GENERATED_KEYS retorna o id que acbou de ser craido na tabela item
            stmItem.setString(1, idPersonagem);
            stmItem.setInt(2, item.getQtd());
            stmItem.executeUpdate();//executa o comando SQL
            final ResultSet rsItem = stmItem.getGeneratedKeys();//cria uma variavel que vai receber o id capturado por RETURN_GENERATED_KEYS
            String itemId = "";
            if (rsItem.next()) { // pega o id que acabou de ser criado e joga na varivel itemId
               itemId = rsItem.getString(1);
            } 
            item.setId(Long.parseLong(itemId));
        carrinho.insereItemLista(item);//insere o item no array de itens do carrinho
            
            stmItemPedido = con.prepareStatement("INSERT INTO item_pedido(pedido,item) VALUES (?,?)");//SQL para iserir os Ids capturados na tabela item_pedido
            stmItemPedido.setLong(1, carrinho.getId());
            stmItemPedido.setLong(2, item.getId());
            stmItemPedido.executeUpdate();//executa o comando SQL
        }
        catch (SQLException ex) {
            Logger.getLogger(Personagem.class.getName()).log(Level.SEVERE, null, ex);
        } 
        finally{//fecha as conexoes com o banco
            Conexao.closeConnection(con, stmItem);
            Conexao.closeConnection(con, stmPedido);
        }
        return carrinho; //retorna o carrinho
    }
    
    public void deleteItem (String idItem, String idPedido){//deletar um item do carrinho
        Connection con = Conexao.getConnection();//cria uma conexao
        PreparedStatement deleteItemPedido; //cria uma variavel para execução de SQL na tabela item_pedido
        PreparedStatement deleteItem;//cria uma variavel para execução de SQL na tabela pedido
        ResultSet resultado = null;
        
        try{
            deleteItemPedido = con.prepareStatement("DELETE FROM item_pedido WHERE pedido=? and item=?;");//SQL para exclusão do item do carrinho
            deleteItemPedido.setString(1, idPedido);
            deleteItemPedido.setString(2, idItem);
            deleteItemPedido.executeUpdate();//executa o comando SQL
            
            deleteItem = con.prepareStatement("DELETE FROM item \n" +//SQL para exclusão do item do carrinho
                                                    "where id = ?;");
            deleteItem.setString(1, idItem);
            deleteItem.executeUpdate();//executa o comando SQL
  
        } catch (SQLException ex) {
            System.out.println("Driver nao pode ser carregado:"+ex);
        } finally{//fecha as conexoes com o banco
            Conexao.closeConnection(con, null, resultado);
        }
    }
    
     public void delete (Long carrinhoId){//deletar um pedido
        Connection con = Conexao.getConnection();//cria uma conexao
        PreparedStatement deletePedido; 
        ResultSet resultado = null;
        
        try{
            deletePedido = con.prepareStatement("DELETE FROM pedido WHERE id=?;");
            deletePedido.setLong(1, carrinhoId);
            deletePedido.executeUpdate();
  
        } catch (SQLException ex) {
            System.out.println("Driver nao pode ser carregado:"+ex);
        } finally{
            Conexao.closeConnection(con, null, resultado);
        }
    }

    public Carrinho getByUser(Usuario user){//pegar um carrinho no banco
        Connection con = Conexao.getConnection(); //cria uma conexao
        PreparedStatement stm; //cria uma variavel para execução de SQL
        ResultSet resultado = null;//variavel que vai receber o resultado da consulta SQL
        Carrinho carrinho = new Carrinho();//instancia um carrinho
        try{
            if(user!= null){//se houver um usuario logado
                stm = con.prepareStatement("select p.id, p.status, p.dt_inicio \n" +
                                             "from pedido p\n" +
                                             "where p.usuario = ?\n" +
                                             "  and p.status = 'aberto';");//consulta para pegar o id, status e dt_inicio a partir do id do usuario
                stm.setLong(1,user.getId());
                resultado = stm.executeQuery();//executa a consulta
                while(resultado.next()) {//insere o resultado da busca no carrinho
                    carrinho.setId(resultado.getLong("id"));
                    carrinho.setStatus(resultado.getString("status"));
                    carrinho.setDtInicio(resultado.getString("dt_inicio"));
                    carrinho.setUsuario(user);
                }
                stm = con.prepareStatement("select i.id, i.personagem, i.qtd \n" +
                                             "from item i, item_pedido ip\n" +
                                             "where ip.pedido = "+carrinho.getId()+" and i.id=ip.item;");//pegar o id do item, personagem e quantidade
                resultado = stm.executeQuery();
                while(resultado.next()) {//insere o resultado da busca no carrinho
                    Item item = new Item();
                    item.setId(resultado.getLong("id"));
                    item.setQtd(resultado.getInt("qtd"));
                    Personagem persona = personaDao.getById(resultado.getString("personagem"));//chama o getById do personagemDao
                    item.setPersonagem(persona);
                    carrinho.insereItemLista(item);//insere o item no carrinho
                }
                
            }
        }catch (SQLException ex) {
            System.out.println("Driver não pôde ser carregado!");
        } 
        finally{
            Conexao.closeConnection(con, null, resultado);
        }                
        return carrinho;//retorna um carrinho
    }
    
    public List<Item> listItensByUser(Usuario user){//listar os itens do carrinho
        Connection con = Conexao.getConnection(); //cria uma conexao
        PreparedStatement stm; //cria uma variavel para execução de SQL
        ResultSet resultado = null; //interface utilizada pra guardar dados vindos de um banco de dados
        List<Item> listaItensPedidos = new ArrayList();//cria uma array para receber os itens
        try{
            if(user!= null){//se o usuario estuver logado busca o item pelo id dele
                stm = con.prepareStatement("select p.identidade, p.nome_real, p.preco, p.imagem_ref\n" +
                                             "from personagem p, item i, item_pedido ip, pedido ped, usuario u\n" +
                                             "where p.id = i.personagem\n" +
                                             "  and i.id = ip.item\n" +
                                             "  and ip.pedido = ped.id\n" +
                                             "  and ped.usuario = u.id\n" +
                                             "  and u.id =?;");//
                stm.setLong(1,user.getId());
                resultado = stm.executeQuery();
            }
            if(user== null){//se o usuario nao estiver logado busca os itens que tem a coluna usuario da tabela pedido igual a null
                stm = con.prepareStatement("select p.identidade, p.nome_real, p.preco, p.imagem_ref\n" +
                                             "from personagem p, item i, item_pedido ip, pedido ped, usuario u\n" +
                                             "where p.id = i.personagem\n" +
                                             "  and i.id = ip.item\n" +
                                             "  and ip.pedido = ped.id\n" +
                                             "  and ped.usuario is null;");
                resultado = stm.executeQuery();
            }
            
            while(resultado.next()) {     //insere o resultado da pesquisa na array list listaItensPedidos  
                Personagem personagem = new Personagem();
                Item item= new Item();//cria um item
                personagem.setIdentidade(resultado.getString("identidade"));
                personagem.setNomeReal(resultado.getString("nome_real"));
                personagem.setPreco(resultado.getDouble("preco"));
                personagem.setImagemRef(resultado.getString("imagem_ref"));               
                item.setPersonagem(personagem);
                
                listaItensPedidos.add(item);//salva o item na lista criada
            }
            
        } 
        catch (SQLException ex) {
            System.out.println("Driver nao pode ser carregado!");
        } 
        finally{
            Conexao.closeConnection(con, null, resultado);
        }                
        return listaItensPedidos; //retorna o array list listaItensPedidos  
    }
    
    public Item saveItem(Item item, Long idPedido){//salva item na tabela item e item_pedido
        String itemId = "";
        Connection con = Conexao.getConnection(); //cria uma conexao
        PreparedStatement stm; //cria uma variavel para execução de SQL
        ResultSet resultado = null; //interface utilizada pra guardar dados vindos de um banco de dados
        try{
            stm = con.prepareStatement("INSERT INTO item(personagem,qtd) VALUES(?,?)", Statement.RETURN_GENERATED_KEYS);
            stm.setString(1, item.getPersonagem().getId().toString());
            stm.setInt(2, item.getQtd());
            stm.executeUpdate();
            final ResultSet rsItem = stm.getGeneratedKeys();
            if (rsItem.next()) { // pega o id que acabou de ser criado na tabela item
               itemId = rsItem.getString(1);
            } 
            
            stm = con.prepareStatement("INSERT INTO item_pedido(item, pedido) VALUES(?,?)");
            stm.setString(1, itemId);
            stm.setLong(2, idPedido);
            stm.executeUpdate();
        } 
        catch (SQLException ex) {
            System.out.println("Driver nao pode ser carregado!");
        } 
        finally{
            Conexao.closeConnection(con, null, resultado);
        } 
        item.setId(Long.parseLong(itemId));
        return item;
    }
    
    public void setUser(Long idUser, Long idPedido){//altera o usuario tabela pedido quando ele se logar
        Connection con = Conexao.getConnection(); //cria uma conexao
        PreparedStatement stm; //cria uma variavel para execução de SQL
        ResultSet resultado = null; //interface utilizada pra guardar dados vindos de um banco de dados
        try{
            stm = con.prepareStatement("UPDATE pedido SET status='abandonado' WHERE usuario=? and status='aberto'");
            stm.setLong(1, idUser);
            stm.executeUpdate();
            
            stm = con.prepareStatement("UPDATE pedido SET usuario=? WHERE id=?");
            stm.setLong(1, idUser);
            stm.setLong(2, idPedido);
            stm.executeUpdate();
        } 
        catch (SQLException ex) {
            System.out.println("Driver nao pode ser carregado!");
        } 
        finally{
            Conexao.closeConnection(con, null, resultado);
        } 
    }
    
    public List<Carrinho> listPedidos(Usuario user){//lista com todos os pedidos com status fechado de um usuario
        Connection con = Conexao.getConnection(); //cria uma conexao
        PreparedStatement stmPedido; //cria uma variavel para execução de SQL
        PreparedStatement stmItem;
        ResultSet resultadoPedido = null;
        ResultSet resultadoItem = null;
        List<Carrinho> carrinhoList = new ArrayList();
        try{
            stmPedido = con.prepareStatement("select * \n" +
                                        "from pedido p\n" +
                                        "where p.usuario = ?\n" +
                                        "  and p.status = 'fechado';");
                stmPedido.setLong(1,user.getId());
                resultadoPedido = stmPedido.executeQuery();
                while(resultadoPedido.next()) {//salva o resultado no carrinho
                    Carrinho carrinho = new Carrinho();
                    carrinho.setId(resultadoPedido.getLong("id"));
                    carrinho.setStatus(resultadoPedido.getString("status"));
                    carrinho.setDtInicio(resultadoPedido.getString("dt_inicio"));
                    carrinho.setDtConfirmacao(resultadoPedido.getString("dt_confirmacao"));
                    carrinho.setUsuario(user);
                    carrinho.setEndereco(enderecoDao.getById(resultadoPedido.getString("endereco_cobranca")));
                    carrinho.setPagamento(pagamentoDao.getById(resultadoPedido.getString("pagamento")));
                    
                    stmItem = con.prepareStatement("select i.id, i.qtd, i.personagem \n" +
                                             "from item i, item_pedido ip\n" +
                                             "where ip.pedido = "+carrinho.getId()+" and i.id=ip.item;");
                    resultadoItem = stmItem.executeQuery();
                    while(resultadoItem.next()) {
                        Item item = new Item();
                        item.setId(resultadoItem.getLong("id"));
                        item.setQtd(resultadoItem.getInt("qtd"));
                        Personagem persona = personaDao.getById(resultadoItem.getString("personagem"));
                        item.setPersonagem(persona);
                        carrinho.insereItemLista(item);
                    }
                    carrinhoList.add(carrinho);
                } 
        }catch (SQLException ex) {
            System.out.println("Driver não pôde ser carregado!");
        } 
        finally{
            Conexao.closeConnection(con, null, resultadoPedido);
        }                
        return carrinhoList;
    }
    
    public void atualizaItem(String idItem, Integer valor){//atualiza a quantidade de itens pedidos
        Connection con = Conexao.getConnection(); //cria uma conexao
        PreparedStatement stm; //cria uma variavel para execução de SQL
        ResultSet resultado = null; //interface utilizada pra guardar dados vindos de um banco de dados
        try{
            stm = con.prepareStatement("UPDATE item SET qtd=? WHERE id=?");
            stm.setInt(1, valor);
            stm.setString(2, idItem);
            stm.executeUpdate();
        } 
        catch (SQLException ex) {
            System.out.println("Driver nao pode ser carregado!");
        } 
        finally{
            Conexao.closeConnection(con, null, resultado);
        } 
    }

}
