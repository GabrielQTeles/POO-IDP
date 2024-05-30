package org.example;

import java.util.Scanner;

public class ProdutoService {
    private ControleDeProdutos controle;
    private Scanner scanner;

    public ProdutoService() {
        controle = new ControleDeProdutos();
        scanner = new Scanner(System.in);
    }

    public void iniciar() {
        int opcao;

        do {
            System.out.println("\n============================");
            System.out.println("******  EcommerceApp  ******");
            System.out.println("============================");
            System.out.println("\n1. Cadastrar produto");
            System.out.println("2. Pesquisar produto");
            System.out.println("3. Alterar produto");
            System.out.println("4. Excluir produto");
            System.out.println("5. Listar todos os produtos");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarProduto();
                    break;
                case 2:
                    pesquisarProduto();
                    break;
                case 3:
                    alterarProduto();
                    break;
                case 4:
                    excluirProduto();
                    break;
                case 5:
                    listarProdutos();
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opcao != 6);

        scanner.close();
    }

    private void cadastrarProduto() {
        System.out.print("Digite o tipo do produto: ");
        String tipo = scanner.nextLine();
        System.out.print("Digite a descrição do produto: ");
        String descricao = scanner.nextLine();
        System.out.print("Digite o peso do produto (kg / Utilize ',' como separador decimal): ");
        double peso = scanner.nextDouble();
        System.out.print("Digite a quantidade em estoque: ");
        int quantidade = scanner.nextInt();
        System.out.print("Digite a unidade de medida para quantificação (1 - METRO, 2 - METRO_QUADRADO, 3 - LITRO, 4 - KG): ");
        int unidadeEscolhida = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha

        UnidadeDeMedida unidadeDeMedida = null;
        switch (unidadeEscolhida) {
            case 1:
                unidadeDeMedida = UnidadeDeMedida.METRO;
                break;
            case 2:
                unidadeDeMedida = UnidadeDeMedida.METRO_QUADRADO;
                break;
            case 3:
                unidadeDeMedida = UnidadeDeMedida.LITRO;
                break;
            case 4:
                unidadeDeMedida = UnidadeDeMedida.KG;
                break;
            default:
                System.out.println("Unidade de medida inválida.");
                return;
        }

        Produto produto = new Produto(tipo, descricao, peso, quantidade, unidadeDeMedida);
        controle.cadastrarProduto(produto);
    }

    private void pesquisarProduto() {
        System.out.print("Digite a descrição do produto a ser pesquisado: ");
        String descricao = scanner.nextLine();
        Produto produto = controle.pesquisarProduto(descricao);
        if (produto != null) {
            System.out.println(produto);
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    private void alterarProduto() {
        System.out.print("Digite a descrição do produto a ser alterado: ");
        String descricao = scanner.nextLine();
        System.out.print("Digite o novo tipo do produto: ");
        String novoTipo = scanner.nextLine();
        System.out.print("Digite a nova descrição do produto: ");
        String novaDescricao = scanner.nextLine();
        System.out.print("Digite o novo peso do produto (kg / Utilize ',' como separador decimal): ");
        double novoPeso = scanner.nextDouble();
        System.out.print("Digite a nova quantidade em estoque: ");
        int novaQuantidade = scanner.nextInt();
        System.out.print("Digite a nova unidade de medida (1 - METRO, 2 - METRO_QUADRADO, 3 - LITRO, 4 - KG): ");
        int novaUnidadeEscolhida = scanner.nextInt();
        scanner.nextLine();

        UnidadeDeMedida novaUnidadeDeMedida = null;
        switch (novaUnidadeEscolhida) {
            case 1:
                novaUnidadeDeMedida = UnidadeDeMedida.METRO;
                break;
            case 2:
                novaUnidadeDeMedida = UnidadeDeMedida.METRO_QUADRADO;
                break;
            case 3:
                novaUnidadeDeMedida = UnidadeDeMedida.LITRO;
                break;
            case 4:
                novaUnidadeDeMedida = UnidadeDeMedida.KG;
                break;
            default:
                System.out.println("Unidade de medida inválida.");
                return;
        }

        Produto produtoAlterado = new Produto(novoTipo, novaDescricao, novoPeso, novaQuantidade, novaUnidadeDeMedida);
        controle.alterarProduto(descricao, produtoAlterado);
    }

    private void excluirProduto() {
        System.out.print("Digite a descrição do produto a ser excluído: ");
        String descricao = scanner.nextLine();
        controle.excluirProduto(descricao);
    }

    private void listarProdutos() {
        controle.listarProdutos();
    }
}
