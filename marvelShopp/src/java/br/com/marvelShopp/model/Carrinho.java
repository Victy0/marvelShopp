/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.marvelShopp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Gleison
 */
public class Carrinho {
    private Long id;
    private Usuario usuario;
    private String status;
    private String dtInicio;
    private List<Item> itens = new ArrayList();

    public Carrinho(){
        this.status = "aberto";
    }
    
    public void insereItemLista (Item item){
        itens.add(item);
    }
    
    public void removeItem (Long idItem){
        for(Item item : itens){
            if(Objects.equals(item.getId(), idItem)){
                this.itens.remove(item);
            }
        }
    }
//    public Item retornaItem(long id){
//        Item itemPedido = null;
//        for(Item item : itens){
//            if(item.getIdPedido()==id){
//                itemPedido = item;
//            }
//        }
//        return itemPedido;
//    }

    public List<Item> getItens(){
        return this.itens;
    }
    
    public String getDtInicio() {
        return dtInicio;
    }

    public void setDtInicio(String dtInicio) {
        this.dtInicio = dtInicio;
    }

    public void setId(Long id){
        this.id = id;
    }
    
    public Long getId(){
        return this.id;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }
    
    public Usuario getUsuario(){
        return this.usuario;
    }
}
