class Caminhonete extends Veiculo {
  // Construtor
  public Caminhonete(double peso) {
    super(peso);
    this.tipo = "Caminhonete";
    this.volume = 0.0;
  }

  // Métodos
  @Override
  public double calcularTarifa() {
    if (peso <= 3000.00) {
      return 25.00;
    } else {
      return 50.00;
    }
  }
}