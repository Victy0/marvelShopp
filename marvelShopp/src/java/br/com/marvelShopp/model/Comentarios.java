package br.com.marvelShopp.model;

/**
 * @author victo
 */
//Classe referente a entidade "comentario"
public class Comentarios {
    
    //@field id
    long id;
    
    //@field usuario
    Usuario usuario;
    
    //@field personagem
    Personagem personagem;
    
    //@field descricao
    String descricao;
    
    //@field nota
    int nota;

    //@return id
    public long getId() {
        return this.id;
    }

    //id to set
    public void setId(long id) {
        this.id = id;
    }

    //@return usuario
    public Usuario getUsuario() {
        return this.usuario;
    }

    //usuario to set
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    //@return personagem
    public Personagem getPersonagem() {
        return this.personagem;
    }

    //personagem to set
    public void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
    }

    //@return descricao
    public String getDescricao() {
        return this.descricao;
    }

    //descricao to set
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    //@return nota
    public int getNota() {
        return this.nota;
    }

    //nota to set
    public void setNota(int nota) {
        this.nota = nota;
    }
}



