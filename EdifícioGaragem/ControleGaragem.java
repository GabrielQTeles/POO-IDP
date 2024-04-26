import java.util.Scanner;

public class ControleGaragem {
  // Atributos
  private int contadorMotocicleta = 0;
  private int contadorCaminhonete = 0;
  private int contadorFurgao = 0;
  private int contadorCarroPasseio = 0;

  // Métodos
  public void listarVeiculos() {
    System.out.println("==========================================");
    System.out.println();
    System.out.println("Veículos estacionados");
    System.out.println("Motocicletas: " + contadorMotocicleta);
    System.out.println("Carros de Passeio: " + contadorCarroPasseio);
    System.out.println("Caminhonetes: " + contadorCaminhonete);
    System.out.println("Furgões: " + contadorFurgao);
  }

  public void adicionarAoContador(Veiculo veiculo) {
    if (veiculo.getTipo() == "Motocicleta") {
      contadorMotocicleta++;
    } else if (veiculo.getTipo() == "Carro de Passeio") {
      contadorCarroPasseio++;
    } else if (veiculo.getTipo() == "Caminhonete") {
      contadorCaminhonete++;
    } else if (veiculo.getTipo() == "Furgão") {
      contadorFurgao++;
    }
  }

  public void adicionarVeiculo() {
    Scanner scanner = new Scanner(System.in);

    while (true) {
      // Escolher o tipo de veículo

      listarVeiculos();

      System.out.println();
      System.out.println("Escolha o tipo de veículo: ");
      System.out.println("1 - Motocicleta");
      System.out.println("2 - Carro de passeio");
      System.out.println("3 - Caminhonete");
      System.out.println("4 - Furgão");

      int tipo = scanner.nextInt();

      // Definir o peso do veiculo
      System.out.println();
      System.out.println("Digite o peso do veículo em Kg: ");
      double peso = scanner.nextDouble();

      // Volume
      double volume = 0.0;

      // Criar os veículos
      Veiculo veiculo;

      switch (tipo) {
        case 1:
          veiculo = new Motocicleta(peso);
          break;

        case 2:
          // Definir o tipo do carro de passeio
          System.out.println();
          System.out.println("Qual é o modelo do carro: ");
          System.out.println("1 - Hatchback");
          System.out.println("2 - Sedan");
          System.out.println("3 - SUV");

          int modelo = scanner.nextInt();

          switch (modelo) {
            case 1:
              System.out.println(peso);
              veiculo = new Hatchback(peso);
              break;

            case 2:
              System.out.println(peso);
              veiculo = new Sedan(peso);
              break;

            case 3:
              System.out.println(peso);
              veiculo = new SUV(peso);
              break;

            default:
              System.out.println("Modelo inválido!");
              continue;
          }

          break;

        case 3:
          veiculo = new Caminhonete(peso);
          break;

        case 4:
          // Definir o volume do Furgão
          System.out.println("Qual é o volume do furgão em m^3: ");
          volume = scanner.nextDouble();

          veiculo = new Furgao(peso, volume);
          break;

        default:
          System.out.println("Tipo de veículo inválido!");
          continue;
      }

      // Tratar casos em que o veículo não pode estacionar
      if (veiculo.podeEstacionar() == false) {
        System.out.println("O veículo não pode estacionar!");
      }

      // Calcular a tarifa caso o veículo possa estacionar
      else {
        double tarifa = veiculo.calcularTarifa();
        System.out.println("A tarifa que deve ser cobrada por hora é: " + tarifa);
        System.out.println();

        // Adicionar carro ao contador
        adicionarAoContador(veiculo);
      }

      // Ao final da operação perguntar se deseja adicionar algum outro veículo
      System.out.println();
      System.out.println("Deseja adicionar um novo veículo:");
      System.out.println("1- Sim");
      System.out.println("2- Não");
      int op = scanner.nextInt();

      if (op == 2) {
        break;
      }

    }

    scanner.close();
  }
}