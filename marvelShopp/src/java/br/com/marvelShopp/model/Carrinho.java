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
public class Carrinho {
    public Personagem personagem;
    private int qtd;
    private String status;
    private String dtInicio;

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

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
}
