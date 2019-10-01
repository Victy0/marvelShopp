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
public class TipoSexo {
    
    private Long id;
    
    private String nome;
    
    public String getNome(){
        return this.nome;
    }
    
    public Long getId(){
        return this.id;
    }
    
    public void setNome(String nome){
        this.nome=nome;
    }
    
    public void setId(Long id){
        this.id = id;
    }
}
