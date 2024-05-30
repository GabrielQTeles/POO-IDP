package org.example;

public class Produto {
    private int id;
    private String tipo;
    private String descricao;
    private double peso;
    private int quantidade;
    private UnidadeDeMedida unidadeDeMedida;

    public Produto(int id, String tipo, String descricao, double peso, int quantidade, UnidadeDeMedida unidadeDeMedida) {
        this.id = id;
        this.tipo = tipo;
        this.descricao = descricao;
        this.peso = peso;
        this.quantidade = quantidade;
        this.unidadeDeMedida = unidadeDeMedida;
    }

    public Produto(String tipo, String descricao, double peso, int quantidade, UnidadeDeMedida unidadeDeMedida) {
        this(0, tipo, descricao, peso, quantidade, unidadeDeMedida);
    }

    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPeso() {
        return peso;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public UnidadeDeMedida getUnidadeDeMedida() {
        return unidadeDeMedida;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", peso=" + peso +
                ", quantidade=" + quantidade +
                ", unidadeDeMedida=" + unidadeDeMedida +
                '}';
    }
}
