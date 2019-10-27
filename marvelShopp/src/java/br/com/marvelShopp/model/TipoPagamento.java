package br.com.marvelShopp.model;

/**
 * @author Victor
 */
//Classe referente a entidade "tipo_sexo"
public class TipoPagamento {
    //@field id
    private Long id;
    
    //@field nome
    private String nome;
    
    //@return nome
    public String getNome(){
        return this.nome;
    }
    
    //@return id
    public Long getId(){
        return this.id;
    }
    
    //nome to sset
    public void setNome(String nome){
        this.nome=nome;
    }
    
    //id to set
    public void setId(Long id){
        this.id = id;
    }
}

