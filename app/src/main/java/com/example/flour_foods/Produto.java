package com.example.flour_foods;

public class Produto {

    private int id_produto;
    private String nome;
    private String preco;

    public Produto(int id_produto, String nome, String preco) {
        this.id_produto = id_produto;
        this.nome = nome;
        this.preco = preco;
    }

    public Produto() {
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }
}
