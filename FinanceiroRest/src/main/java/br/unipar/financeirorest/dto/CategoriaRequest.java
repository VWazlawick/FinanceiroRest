/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.financeirorest.dto;

import br.unipar.financeirorest.Model.TipoCategoriaEnum;

/**
 *
 * @author victo
 */
public class CategoriaRequest {
    private String descricao;
    private TipoCategoriaEnum tipo;

    public CategoriaRequest() {
    }

    public CategoriaRequest(String descricao, TipoCategoriaEnum tipo) {
        this.descricao = descricao;
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoCategoriaEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoCategoriaEnum tipo) {
        this.tipo = tipo;
    }
    
    
}
