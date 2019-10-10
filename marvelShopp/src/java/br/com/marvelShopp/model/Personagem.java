/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.marvelShopp.model;

/**
 *
 * @author Victor
 */
public class Personagem {

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the preco
     */
    public Double getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(Double preco) {
        this.preco = preco;
    }

    /**
     * @return the ocupacao
     */
    public TipoOcupacao getOcupacao() {
        return ocupacao;
    }

    /**
     * @param ocupacao the ocupacao to set
     */
    public void setOcupacao(TipoOcupacao ocupacao) {
        this.ocupacao = ocupacao;
    }

    /**
     * @return the sexo
     */
    public TipoSexo getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(TipoSexo sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the qtdEstoque
     */
    public Integer getQtdEstoque() {
        return qtdEstoque;
    }

    /**
     * @param qtdEstoque the qtdEstoque to set
     */
    public void setQtdEstoque(Integer qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    /**
     * @return the lugar
     */
    public String getLugar() {
        return lugar;
    }

    /**
     * @param lugar the lugar to set
     */
    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    /**
     * @return the imagemRef
     */
    public String getImagemRef() {
        return imagemRef;
    }

    /**
     * @param imagemRef the imagemRef to set
     */
    public void setImagemRef(String imagemRef) {
        this.imagemRef = imagemRef;
    }

    /**
     * @return the nomeReal
     */
    public String getNomeReal() {
        return nomeReal;
    }

    /**
     * @param nomeReal the nomeReal to set
     */
    public void setNomeReal(String nomeReal) {
        this.nomeReal = nomeReal;
    }

    /**
     * @return the identidade
     */
    public String getIdentidade() {
        return identidade;
    }

    /**
     * @param identidade the identidade to set
     */
    public void setIdentidade(String identidade) {
        this.identidade = identidade;
    }

    /**
     * @return the categoria
     */
    public TipoCategoria getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(TipoCategoria categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     * @field id
     */
    private Long id;
    
    /**
     * @field nome_real
     */
    private String nomeReal;
    
    /**
     * @field identidade
     */
    private String identidade;
    
    /**
     * @field categoria
     */
    private TipoCategoria categoria;
    
    /**
     * @field descricao
     */
    private String descricao;
    
    /**
     * @field preco
     */
    private Double preco;
    
    /**
     * @field ocupacao
     */
    private TipoOcupacao ocupacao;
            
    /**
     * @field sexo
     */
    private TipoSexo sexo;
    
    /**
     * @field qtd_estoque
     */
    private Integer qtdEstoque;        
    
    /**
     * @field lugar
     */
    private String lugar;
    
    /**
     * @field imagem_ref
     */
    private String imagemRef;
    
}
