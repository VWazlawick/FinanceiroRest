/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.financeirorest.Model;

import br.unipar.financeirorest.dto.CategoriaRequest;

/**
 *
 * @author victo
 */
public class Categoria {
    private int id;
    private String descricao;
    private TipoCategoriaEnum tipo;

    public Categoria() {
    }

    public Categoria(int id, String descricao, TipoCategoriaEnum tipo) {
        this.id = id;
        this.descricao = descricao;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    
    public static Categoria requestToCategoria(CategoriaRequest dto){
        return new Categoria(0, dto.getDescricao(), dto.getTipo());
    }
}
