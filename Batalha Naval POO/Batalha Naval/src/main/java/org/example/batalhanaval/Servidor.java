package org.example.batalhanaval;

import java.io.*;
import java.net.*;

public class Servidor {

    private ServerSocket servidorSocket;

    public Servidor(int porta) {
        try {
            servidorSocket = new ServerSocket(porta);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void iniciar() {
        System.out.println("Servidor iniciado e esperando por conexões...");
        try {
            while (true) {
                Socket clienteSocket = servidorSocket.accept();
                System.out.println("Cliente conectado!");
                new ManipuladorDeCliente(clienteSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ManipuladorDeCliente extends Thread {
        private Socket clienteSocket;
        private ObjectOutputStream saida;
        private ObjectInputStream entrada;

        public ManipuladorDeCliente(Socket socket) {
            this.clienteSocket = socket;
        }

        public void run() {
            try {
                saida = new ObjectOutputStream(clienteSocket.getOutputStream());
                entrada = new ObjectInputStream(clienteSocket.getInputStream());

                Object objetoEntrada;
                while ((objetoEntrada = entrada.readObject()) != null) {
                    if (objetoEntrada instanceof Posicao) {
                        Posicao posicao = (Posicao) objetoEntrada;
                        System.out.println("Recebido do cliente: " + posicao);
                        // Aqui você pode adicionar lógica de jogo
                        saida.writeObject("Ataque registrado em: " + posicao);
                    }
                }

                entrada.close();
                saida.close();
                clienteSocket.close();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

}
