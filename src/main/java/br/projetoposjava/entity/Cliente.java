/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.projetoposjava.entity;

/**
 *
 * @author brnme
 */
public class Cliente {
    
    private int codigo;
    private String nome;
    private String cidade;

    public Cliente() {
    
    }
    
    public Cliente(int codigo, String nome, String cidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.cidade = cidade;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "Cliente{" + "codigo=" + codigo + ", nome=" + nome + ", cidade=" + cidade + '}';
    }
    
}
