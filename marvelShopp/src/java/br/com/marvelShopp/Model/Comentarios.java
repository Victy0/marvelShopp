/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author victo
 */
package br.com.marvelShopp.model;
public class Comentarios {
     long id;
    long usuario;
    long personagem;
    String descricao;
    int nota;

 public long getId(){
     return this.id;
 } 
 public void setID(int id){
     this.id=id;
 }
public String getDescricao(){
  return this.descricao;
}

public int getNota(){
    return this.nota;
    }

public void setDescricao(String descricao){
     this.descricao=descricao;
}

public void setNota (int nota){
   this.nota=nota;
}
public long getUsuario(){
   return this.usuario;
}

public long getPersonagem(){
   return this.personagem;
}

public void  setPersonagem(long perso){
    this.personagem=perso;
}
public void setUsuario(long usu){
    this.usuario=usu;
}
}


