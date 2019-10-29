
package br.com.marvelShopp.model;
//cria uma classe referente a entidade "endereço"
public class Endereco {
    private long id;
    private String rua;
    private String bairro;
    private String numeroCasa;
    private String complemento;
    private String cep;
    private String userId;//Variavel que recebe o id do usuário
     private String cidade;

    public String getUserId() {//retorna o id do usuario
        return this.userId;
    }

    public void setUserId(String userId) {//altera o id do usuario
        this.userId = userId;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRua() {
        return this.rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return this.bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNumeroCasa() {
        return this.numeroCasa;
    }

    public void setNumeroCasa(String numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    public String getComplemento() {
        return this.complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return this.cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return this.cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
   
}
