package br.edu.idp.tech.poo;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cliente {

    public void iniciar(String endereco, int porta) {
        ObjectOutputStream saida;
        ObjectInputStream entrada;
        Socket conexao;
        Scanner ler = new Scanner(System.in);

        List<NotasEstudante> dados = carregarDadosNotasEstudantes();
        try {
            conexao = new Socket(endereco, porta);
            System.out.println("Conectado ao servidor " + endereco + ", na porta: " + porta);
            System.out.println("Digite: FIM para encerrar a conexao");

            // ligando as conexoes de saida e de entrada
            saida = new ObjectOutputStream(conexao.getOutputStream());
            saida.flush();
            entrada = new ObjectInputStream(conexao.getInputStream());

            String mensagem = "";
            //lendo a mensagem enviada pelo servidor
            mensagem = (String) entrada.readObject();
            System.out.println("Servidor>> "+mensagem);

            int opcao;
            do {
                System.out.print("1 a 3 ..: ");
                opcao = ler.nextInt();
                NotasEstudante notasParaEnviar = dados.get(opcao-1);
                saida.writeObject(notasParaEnviar);
                saida.flush();
                //lendo a mensagem enviada pelo servidor
                ResultadoEstudante retorno = (ResultadoEstudante) entrada.readObject();
                System.out.println("Servidor>> "+retorno);
            } while (opcao > 0);

            saida.close();
            entrada.close();
            conexao.close();
        } catch (Exception e) {
            System.err.println("erro: " + e.toString());
        }

    }

    private List<NotasEstudante> carregarDadosNotasEstudantes() {
        List<NotasEstudante> dadosNotas = new ArrayList<>();
        dadosNotas.add(new NotasEstudante("Rodrigo", 3.0, 7.1, 4.7, 6.1));
        dadosNotas.add(new NotasEstudante("Joana", 9.0, 6.4, 9.6, 8.2));
        dadosNotas.add(new NotasEstudante("Altair", 6.0, 5.3, 6.2, 7.3));
        return dadosNotas;
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Uso: java tcp.Cliente <endereco-IP> <porta>");
            System.exit(1);
        }

        Cliente c = new Cliente();
        c.iniciar(args[0], Integer.parseInt(args[1]));
    }

}
