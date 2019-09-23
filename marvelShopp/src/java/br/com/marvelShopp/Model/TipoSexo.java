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
    
    private Integer id;
    
    private String nome;
    
    public String getNome(){
        return this.nome;
    }
    
    public Integer getId(){
        return this.id;
    }
    
    public void setNome(String nome){
        this.nome=nome;
    }
    
    public void setId(Integer id){
        this.id = id;
    }
}
