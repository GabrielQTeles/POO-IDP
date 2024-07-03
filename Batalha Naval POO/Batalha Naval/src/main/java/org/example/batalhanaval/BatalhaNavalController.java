package org.example.batalhanaval;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

public class BatalhaNavalController {

    @FXML
    private Button cServidor;

    @FXML
    private TextField posicaoAtaque;

    @FXML
    private TextField campoPorta;

    @FXML
    private Button fazerJogada;

    @FXML
    private Button aServidor;

    private Servidor servidor;
    private Cliente cliente;

    @FXML
    void fazerJogada(ActionEvent event) {
        String posicao = posicaoAtaque.getText();
        if (posicao.isEmpty()) {
            mostrarAlerta("Erro", "Por favor, digite uma posição.");
            return;
        }
        cliente.enviarJogada(posicao);
    }

    @FXML
    void conectarServidor(ActionEvent event) {
        String textoPorta = campoPorta.getText();
        if (textoPorta.isEmpty()) {
            mostrarAlerta("Erro", "Por favor, digite uma porta.");
            return;
        }
        int porta = Integer.parseInt(textoPorta);
        cliente = new Cliente("127.0.0.1", porta); // Altere para o IP apropriado
        new Thread(() -> {
            cliente.iniciar();
        }).start();
    }

    @FXML
    void abrirServidor(ActionEvent event) {
        int porta = (int) (Math.random() * 65535);
        servidor = new Servidor(porta);
        new Thread(() -> {
            servidor.iniciar();
        }).start();
        mostrarAlerta("Servidor Criado", "Servidor criado na porta: " + porta);
    }

    private void mostrarAlerta(String titulo, String mensagem) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}
