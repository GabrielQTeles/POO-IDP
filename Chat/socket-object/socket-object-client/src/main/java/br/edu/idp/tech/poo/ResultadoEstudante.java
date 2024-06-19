package br.edu.idp.tech.poo;


import java.io.Serializable;


public class ResultadoEstudante implements Serializable {

    private NotasEstudante notasEstudante;
    private String resultado;

    public ResultadoEstudante(NotasEstudante notas) {
        this.notasEstudante = notas;
        double media = this.calcularMedia();
        if (media >= 8) {
            this.resultado = "Aprovado";
        } else if (media >= 6) {
            this.resultado = "Em recuperação";
        } else {
            this.resultado = "Reprovado";
        }
    }

    private double calcularMedia() {
        return (this.notasEstudante.getNota1() +
                this.notasEstudante.getNota2() +
                this.notasEstudante.getNota3() +
                this.notasEstudante.getNota4() ) / 4;
    }

    @Override
    public String toString() {
        return "ResultadoEstudante{" +
                "estudante=" + notasEstudante.getNome() +
                ", resultado='" + resultado + '\'' +
                '}';
    }

}
