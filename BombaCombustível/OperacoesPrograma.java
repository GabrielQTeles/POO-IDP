public class OperacoesPrograma {

  Bombas bomba = new Bombas();

  public void escolhas(int opcao1, int opcao2) {

    switch (opcao1) {
      case 1: // Se for Gasolina Comum
        switch (opcao2) {
          case 1: // Se for por valor
            bomba.bombaGC.abastecerPorValor();
            break;

          case 2: // Se for por litro
            bomba.bombaGC.abastecerPorLitro();
            break;

          default:
            System.out.println("Opção inválida");
            return;
        }
        break;

      case 2: // Se for Gasolina Aditivada
        switch (opcao2) {
          case 1: // Se for por valor
            bomba.bombaGA.abastecerPorValor();
            break;

          case 2: // Se for por litro
            bomba.bombaGA.abastecerPorLitro();
            break;

          default:
            System.out.println("Opção inválida");
            return;
        }
        break;

      case 3: // Se for Etanol
        switch (opcao2) {
          case 1: // Se for por valor
            bomba.bombaE.abastecerPorValor();
            break;

          case 2: // Se for por litro
            bomba.bombaE.abastecerPorLitro();
            break;

          default:
            System.out.println("Opção inválida");
            return;
        }
        break;

      case 4: // Se for Diesel
        switch (opcao2) {
          case 1: // Se for por valor
            bomba.bombaD.abastecerPorValor();
            break;

          case 2: // Se for por litro
            bomba.bombaD.abastecerPorLitro();
            break;

          default:
            System.out.println("Opção inválida");
            return;
        }
        break;

      default:
        System.out.println("Opção inválida");
        return;

    }

  }

  public void operacaoFinal() {

    // Exibir quantidade de gasolina em cada bomba no final do programa
    System.out.println();
    System.out.println("Obrigado por usar nossos serviços!");
    System.out.printf("Total Bomba Gasolina Comum: %.2f", bomba.bombaGC.getQuantidadeCombustivel());
    System.out.println();
    System.out.printf("Total Bomba Gasolina Aditivada: %.2f", bomba.bombaGA.getQuantidadeCombustivel());
    System.out.println();
    System.out.printf("Total Bomba Etanol: %.2f", bomba.bombaE.getQuantidadeCombustivel());
    System.out.println();
    System.out.printf("Total Bomba Diesel: %.2f", bomba.bombaD.getQuantidadeCombustivel());
    System.out.println();
  }

}