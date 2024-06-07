/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.financeirorest.Model;

import br.unipar.financeirorest.dto.TransacaoRequest;
import java.util.Date;

/**
 *
 * @author victo
 */
public class Transacao {
    private int id;
    private String descricao;
    private Double valor;
    private Date data;
    private Categoria categoria;

    public Transacao() {
    }

    public Transacao(int id, String descricao, Double valor, Date data, Categoria categoria) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
        this.categoria = categoria;
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

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    public static Transacao transacaoToRequest(TransacaoRequest dto){
        return new Transacao(0, dto.getDescricao(), dto.getValor(), dto.getData(), dto.getCategoria());
    }
    
}
