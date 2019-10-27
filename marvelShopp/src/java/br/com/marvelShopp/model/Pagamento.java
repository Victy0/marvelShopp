/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.marvelShopp.model;

public class Pagamento {
    private Usuario user;
    private Endereco endereco;
    private String status;
    private String formaPag;
    private String dataPag;

    public String getFormaPag() {
        return formaPag;
    }

    public void setFormaPag(String formaPag) {
        this.formaPag = formaPag;
    }

    public String getDataPag() {
        return dataPag;
    }

    public void setDataPag(String dataPag) {
        this.dataPag = dataPag;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
