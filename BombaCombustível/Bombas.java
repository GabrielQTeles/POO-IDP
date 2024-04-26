public class Bombas {
  // Atributos
  BombaGasolinaComum bombaGC;
  BombaGasolinaAditivada bombaGA;
  BombaEtanol bombaE;
  BombaDiesel bombaD;

  // Construtor
  public Bombas() {
    this.bombaGC = new BombaGasolinaComum(5.00, 2000.00);
    this.bombaGA = new BombaGasolinaAditivada(5.70, 1500.00);
    this.bombaE = new BombaEtanol(3.50, 1000.00);
    this.bombaD = new BombaDiesel(6.00, 500.00);
  }

}