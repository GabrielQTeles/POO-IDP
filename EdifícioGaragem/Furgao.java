class Furgao extends Veiculo {
  // Construtor
  public Furgao(double peso, double volume) {
    super(peso);
    this.volume = volume;
    this.tipo = "Furgão";
  }

  // Métodos
  @Override
  public double calcularTarifa() {
    if (peso <= 2000.00) {
      return 25.00;
    } else {
      return 50.00;
    }
  }
}