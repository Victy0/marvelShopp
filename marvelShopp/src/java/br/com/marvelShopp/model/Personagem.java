package br.com.marvelShopp.model;

/**
 *
 * @author Victor
 */
//Classe referente a entidade "personagem"
public class Personagem {

    //@return descricao
    public String getDescricao() {
        return this.descricao;
    }

    //descricao to set
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    //@return preco
    public Double getPreco() {
        return this.preco;
    }

    //preco to set
    public void setPreco(Double preco) {
        this.preco = preco;
    }

    //@return ocupacao
    public TipoOcupacao getOcupacao() {
        return this.ocupacao;
    }

    //ocupacao to set
    public void setOcupacao(TipoOcupacao ocupacao) {
        this.ocupacao = ocupacao;
    }

    //@return sexo
    public TipoSexo getSexo() {
        return this.sexo;
    }

    //sexo to set
    public void setSexo(TipoSexo sexo) {
        this.sexo = sexo;
    }

    //@return qtdEstoque
    public Integer getQtdEstoque() {
        return this.qtdEstoque;
    }

    //qtdEstoque to set
    public void setQtdEstoque(Integer qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    //@return lugar
    public String getLugar() {
        return this.lugar;
    }

    //lugar to sset
    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    //@return imagemRef
    public String getImagemRef() {
        return this.imagemRef;
    }

    //imagemRef to set
    public void setImagemRef(String imagemRef) {
        this.imagemRef = imagemRef;
    }

    //@return nomeReal
    public String getNomeReal() {
        return this.nomeReal;
    }

    //nomeReal to set
    public void setNomeReal(String nomeReal) {
        this.nomeReal = nomeReal;
    }

    //@return identidade
    public String getIdentidade() {
        return this.identidade;
    }

    //identidade to set
    public void setIdentidade(String identidade) {
        this.identidade = identidade;
    }

    //@return categoria
    public TipoCategoria getCategoria() {
        return this.categoria;
    }

    //categoria to set
    public void setCategoria(TipoCategoria categoria) {
        this.categoria = categoria;
    }

    //@return id
    public Long getId() {
        return this.id;
    }

    //id to set
    public void setId(Long id) {
        this.id = id;
    }
    
    //@field id
    private Long id;
    
    //@field nome_real
    private String nomeReal;
    
    //@field identidade
    private String identidade;
    
    //@field categoria
    private TipoCategoria categoria;
    
    //@field descricao
    private String descricao;
    
    //@field preco
    private Double preco;
    
    //@field ocupacao
    private TipoOcupacao ocupacao;
            
    //@field sexo
    private TipoSexo sexo;
    
    //@field qtd_estoque
    private Integer qtdEstoque;        
    
    //@field lugar
    private String lugar;
    
    //@field imagem_ref
    private String imagemRef;
    
}
