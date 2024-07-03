package org.example.batalhanaval;

import java.io.*;
import java.net.*;

public class Cliente {
    private String ip;
    private int porta;
    private Socket clienteSocket;
    private ObjectOutputStream saida;
    private ObjectInputStream entrada;

    public Cliente(String ip, int porta) {
        this.ip = ip;
        this.porta = porta;
    }

    public void iniciar() {
        try {
            clienteSocket = new Socket(ip, porta);
            saida = new ObjectOutputStream(clienteSocket.getOutputStream());
            entrada = new ObjectInputStream(clienteSocket.getInputStream());

            // Aqui, você pode adicionar a lógica de interação com o usuário.
            Posicao posicao = new Posicao(2, 3); // Exemplo de posição
            saida.writeObject(posicao);
            saida.flush();

            String resposta = (String) entrada.readObject();
            System.out.println("Resposta do servidor: " + resposta);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                entrada.close();
                saida.close();
                clienteSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void enviarJogada(String posicao) {
        try {
            // Supondo que a posição é recebida como uma string "linha,coluna"
            String[] partes = posicao.split(",");
            int linha = Integer.parseInt(partes[0].trim());
            int coluna = Integer.parseInt(partes[1].trim());
            Posicao posicaoObjeto = new Posicao(linha, coluna);
            saida.writeObject(posicaoObjeto);
            saida.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
