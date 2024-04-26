class Motocicleta extends Veiculo {
  // Construtor
  public Motocicleta(double peso) {
    super(peso);
    this.tipo = "Motocicleta";
    this.volume = 0.0;
  }

  // Métodos
  @Override
  public double calcularTarifa() {
    if (peso <= 100.00) {
      return 2.00;
    }

    else if (peso > 100.00 && peso < 300.00) {
      return 4.00;
    }

    else {
      return 10.00;
    }
  }
}