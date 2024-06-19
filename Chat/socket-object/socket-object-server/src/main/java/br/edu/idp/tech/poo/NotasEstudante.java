package br.edu.idp.tech.poo;


import java.io.Serializable;


public class NotasEstudante implements Serializable {

    private String nome;
    private double nota1;
    private double nota2;
    private double nota3;
    private double nota4;

    public String getNome() {
        return nome;
    }
    public double getNota1() {
        return nota1;
    }
    public double getNota2() {
        return nota2;
    }
    public double getNota3() {
        return nota3;
    }
    public double getNota4() {
        return nota4;
    }

    public NotasEstudante(String nome, double nota1, double nota2, double nota3, double nota4) {
        this.nome = nome;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.nota4 = nota4;
    }

    @Override
    public String toString() {
        return "NotasEstudante{" +
                "nome='" + nome + '\'' +
                ", nota1=" + nota1 +
                ", nota2=" + nota2 +
                ", nota3=" + nota3 +
                ", nota4=" + nota4 +
                '}';
    }

}
