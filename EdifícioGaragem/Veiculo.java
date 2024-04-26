public abstract class Veiculo {
  // Atributos
  protected String tipo = "";
  protected double peso;
  protected double volume = 0.0;

  // Construtor
  public Veiculo(double peso) {
    this.peso = peso;
  }

  // Métodos
  public abstract double calcularTarifa();

  public String getTipo() {
    return this.tipo;
  }

  public boolean podeEstacionar() {
    // Tratar casos em que o veículo não pode estacionar
    if ((tipo == "Caminhonete" || tipo == "Carro de Passeio" || tipo == "Furgão") && (peso > 6000.00 || volume > 18)) {
      return false;
    }

    else if (tipo == "Motocicleta" && peso > 300) {
      return false;
    }

    return true;
  }

}