/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.marvelShopp.model;

import java.util.ArrayList;

/**
 *
 * @author Gleison
 */
public class Carrinho {
    private Usuario usuario;
    private String status;
    private String dtInicio;
    private ArrayList<Item> itens = new ArrayList();

    public void insereItemLista (Item item){
        itens.add(item);
    }
    
    public Item retornaItem(long id){
        Item itemPedido = null;
        for(Item item : itens){
            if(item.getIdPedido()==id){
                itemPedido = item;
            }
        }
        return itemPedido;
    }

    public String getDtInicio() {
        return dtInicio;
    }

    public void setDtInicio(String dtInicio) {
        this.dtInicio = dtInicio;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
