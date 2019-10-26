package br.com.marvelShopp.model;

/**
 * @author Victor
 */
//Classe referente a entidade "tipo_ocupacao"
public class TipoOcupacao {

    //@return id
    public Long getId() {
        return this.id;
    }

    //id to set
    public void setId(Long id) {
        this.id = id;
    }

    //@return nome
    public String getNome() {
        return this.nome;
    }

    //nome to set
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    //@field id
    private Long id;
    
    //@field nome
    private String nome;
}
