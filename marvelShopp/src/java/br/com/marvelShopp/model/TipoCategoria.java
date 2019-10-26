package br.com.marvelShopp.model;

/**
 * @author Victor
 */
//Classe referente a entidade "tipo_categoria"
public class TipoCategoria {

    //@return recebeEmail
    public Long getId() {
        return this.id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    /**
     * @field id 
     */
    private Long id;
    
    /**
     * @field nome
     */
    private String nome;
}
