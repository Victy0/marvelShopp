/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.marvelShopp.model;

/**
 *
 * @author Gleison
 */
public class Item {
    long pedidoId;
    public Personagem personagem;
    int qtd;

    public long getIdPedido() {
        return pedidoId;
    }

    public void setIdPedido(long id) {
        this.pedidoId = id;
    }

    public Personagem getPersonagem() {
        return personagem;
    }

    public void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
}
