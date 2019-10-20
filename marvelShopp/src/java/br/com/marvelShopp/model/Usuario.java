/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.marvelShopp.model;


/**
 *
 * @author victo
 */
public class Usuario {
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private String sexo;
    private String dt_nascimento;
    private String cpf;
    private boolean recebeEmail;
    private boolean hasAdm;
    
    public boolean getRecebeEmail(){
        return this.recebeEmail;
    }
    
    public void setRecebeEmail(boolean recebeEmail){
        this.recebeEmail= recebeEmail;
    }
    
    public boolean getHasAdm(){
        return this.hasAdm;
    }
    
    public void setHasAdm(boolean hasAdm){
        this.hasAdm= hasAdm;
    }
    
    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSexo() {
        return this.sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDt_nascimento() {
        return this.dt_nascimento;
    }

    public void setDt_nascimento(String dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
    }
    
}
