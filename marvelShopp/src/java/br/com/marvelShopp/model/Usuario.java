package br.com.marvelShopp.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author victo
 */
//Classe referente a entidade "usuario"
public class Usuario {
    
    //@field id
    private Long id;
    
    //@field nome
    private String nome;
    
    //@field email
    private String email;
    
    //@field senha
    private String senha;
    
    //@field sexo
    private String sexo;
    
    //@field dt_nascimento
    private String dt_nascimento;
    
    //@field cpf
    private String cpf;
    
    //@field recebe_email
    private boolean recebeEmail;
    
    //@field has_adm
    private boolean hasAdm;
    
    //@field relação table personagem_favorito
    private List<Personagem> favoritos = new ArrayList();
    
    //@return favoritos
    public List<Personagem> getFavoritos(){
        return this.favoritos;
    }
    
    //insere novo persnagem favorito
    public void insereFavorito(Personagem personagem){
        this.favoritos.add(personagem);
    }
    
    //favoritos to set
    public void setFavoritos(List<Personagem> favoritos){
        this.favoritos = favoritos;
    }
    
    //confere se possui o favorito pelo 'id' do Persnagem
    public boolean hasThisFavorito(Long idPersonagem){
        for(int i=0; i<this.favoritos.size(); i++){
            Personagem personagem = this.favoritos.get(i);
            if(personagem.getId() == idPersonagem){
                return true;
            }
        }
        return false;
    }
    
    //remove determinado personagem
    public void removeFavorito(Long idPersonagem){
        for(int i=0; i<this.favoritos.size(); i++){
            Personagem p = this.favoritos.get(i);
            if(p.getId() == idPersonagem){
                this.favoritos.remove(i);
            }
        }
    }
    
    //@return recebeEmail
    public boolean getRecebeEmail(){
        return this.recebeEmail;
    }
    
    //recebeEmail to set
    public void setRecebeEmail(boolean recebeEmail){
        this.recebeEmail= recebeEmail;
    }
    
    //@return hasAdm
    public boolean getHasAdm(){
        return this.hasAdm;
    }
    
    //hasAdm to set
    public void setHasAdm(boolean hasAdm){
        this.hasAdm= hasAdm;
    }
    
    //@return cpf
    public String getCpf() {
        return this.cpf;
    }
    
    //cpf to set
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
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

    //@return email
    public String getEmail() {
        return this.email;
    }

    //email to set
    public void setEmail(String email) {
        this.email = email;
    }

    //@return senha
    public String getSenha() {
        return this.senha;
    }

    //senha to set
    public void setSenha(String senha) {
        this.senha = senha;
    }

    //@return sexo
    public String getSexo() {
        return this.sexo;
    }

    //sexo to set
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    //@return dt_nascimento
    public String getDt_nascimento() {
        return this.dt_nascimento;
    }

    //dt_nascimento to set
    public void setDt_nascimento(String dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
    }
    
}
