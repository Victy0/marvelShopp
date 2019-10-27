package br.com.marvelShopp.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gleison
 */
public class Carrinho {
    private Long id;
    private Usuario usuario;
    private String status;
    private String dtInicio;
    private List<Item> itens = new ArrayList();
    private Endereco endereco;
    private TipoPagamento pagamento;

    public Carrinho(){
        this.status = "aberto";
    }
    
    public void setPagamento(TipoPagamento pagamento){
        this.pagamento = pagamento;
    }
    
    public TipoPagamento getPagamento(){
        return this.pagamento;
    }
    
    public void setEndereco(Endereco endereco){
        this.endereco = endereco;
    }
    
    public Endereco getEndereco(){
        return this.endereco;
    }
    
    public void insereItemLista (Item item){
        itens.add(item);
    }
    
    public void removeItem (Long idItem){
        for(int i=0; i<this.itens.size(); i++){
            Item item = this.itens.get(i);
            if(item.getId() == idItem){
                this.itens.remove(i);
            }
        }
    }
//    public Item retornaItem(long id){
//        Item itemPedido = null;
//        for(Item item : itens){
//            if(item.getIdPedido()==id){
//                itemPedido = item;
//            }
//        }
//        return itemPedido;
//    }

    public List<Item> getItens(){
        return this.itens;
    }
    
    public String getDtInicio() {
        return dtInicio;
    }

    public void setDtInicio(String dtInicio) {
        this.dtInicio = dtInicio;
    }

    public void setId(Long id){
        this.id = id;
    }
    
    public Long getId(){
        return this.id;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }
    
    public Usuario getUsuario(){
        return this.usuario;
    }
}
