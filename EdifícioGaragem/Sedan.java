class Sedan extends Veiculo {
  // Construtor
  public Sedan(double peso) {
    super(peso);
    this.tipo = "Carro de Passeio";
    this.volume = 0.0;
  }

  // Métodos
  @Override
  public double calcularTarifa() {
    if (peso <= 2000.00) {
      return 15.00;
    } else if (peso > 2000.00 && peso <= 3000.00) {
      return 25.00;
    } else {
      return 50.00;
    }
  }
}