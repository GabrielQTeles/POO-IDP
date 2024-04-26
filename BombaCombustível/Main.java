import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    // Receber as opções do usuário
    System.out.println("Escolha o tipo de combustível:");
    System.out.println("1) Gasolina comum");
    System.out.println("2) Gasolina aditivada");
    System.out.println("3) Etanol");
    System.out.println("4) Diesel");

    Scanner scanner = new Scanner(System.in);
    int opcao1 = scanner.nextInt();

    System.out.println();
    System.out.println("Escolha a forma de abastecer: ");
    System.out.println("1 - Por valor");
    System.out.println("2 - Por litro");

    int opcao2;
    opcao2 = scanner.nextInt();

    // Realizar as operações que o usuário escolheu
    OperacoesPrograma op = new OperacoesPrograma();
    op.escolhas(opcao1, opcao2);
    op.operacaoFinal();

    scanner.close(); // Fechando o Scanner após a leitura de todas as entradas.

  }

}