package br.com.marvelShopp.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gleison
 */
public class Carrinho { //cria uma classe referente a entidade "carrinho"
    private Long id;
    private Usuario usuario;//usuario ao qual pertence o carrinho
    private String status;//status da compra
    private String dtInicio;//data de início da compra
    private String dtConfirmacao;//data de finalização da compra
    private List<Item> itens = new ArrayList(); //Array que recebe os item do carrinho
    private Endereco endereco;
    private TipoPagamento pagamento; //qual a forma de pagamento (boleto, cartão, etc)

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
    
    public void removeItem (Long idItem){ //remove um item do carrinho
        for(int i=0; i<this.itens.size(); i++){
            Item item = this.itens.get(i);
            if(item.getId() == idItem){
                this.itens.remove(i);
            }
        }
    }

    public List<Item> getItens(){
        return this.itens;
    }
    
    public String getDtInicio() {
        return this.dtInicio;
    }

    public void setDtInicio(String dtInicio) {
        this.dtInicio = dtInicio;
    }

    public String getDtConfirmacao() {
        return this.dtConfirmacao;
    }

    public void setDtConfirmacao(String dtConfirmacao) {
        this.dtConfirmacao = dtConfirmacao;
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
