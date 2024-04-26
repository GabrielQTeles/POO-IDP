import java.util.Scanner;

public class BombaEtanol {
  // Atributos
  private double valorLitro;
  private double quantidadeCombustivel;

  // Construtor
  public BombaEtanol(double valorLitro, double quantidadeCombustivel) {
    this.valorLitro = valorLitro;
    this.quantidadeCombustivel = quantidadeCombustivel;
  }

  // Métodos

  // método onde é informado o valor a ser abastecido e mostra a quantidade de
  // litros que foi colocada no veículo;
  public void abastecerPorValor() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Informe o valor a ser abastecido: ");

    double valor = scanner.nextDouble();

    scanner.close();

    double litros = valor / valorLitro;

    if (litros > quantidadeCombustivel) {
      System.out.println("Não há Etanol suficiente na bomba para este valor.");
      System.out.println("Lamentamos o inconveniente.");
    } else {
      System.out.printf("A quantidade de litros que foi colocada no veículo é: %.2f", litros);
      System.out.println();
      alterarQuantidadeCombustivel(litros);
    }
  }

  // método onde é informado a quantidade em litros de combustível e mostra o
  // valor a ser pago pelo cliente;
  public void abastecerPorLitro() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Informe a quantidade em litros a ser abastecida: ");

    double litros = scanner.nextDouble();
    scanner.close();

    if (litros > quantidadeCombustivel) {
      System.out.println("Não há Etanol suficiente na bomba.");
      System.out.println("Lamentamos o inconveniente.");
    } else {
      double valor = litros * valorLitro;
      System.out.printf("O valor a ser pago é: %.2f", valor);
      System.out.println();
      alterarQuantidadeCombustivel(litros);
    }
  }

  // altera o valor do litro do combustível;
  public void alterarValor(double valorLitro) {
    this.valorLitro = valorLitro;
  }

  // altera a quantidade de combustível restante na bomba.
  public void alterarQuantidadeCombustivel(double abasteceuCarro) {
    this.quantidadeCombustivel -= abasteceuCarro;
  }

  // resgatar quantidade de combustível restante na bomba.
  public double getQuantidadeCombustivel() {
    return this.quantidadeCombustivel;
  }

}