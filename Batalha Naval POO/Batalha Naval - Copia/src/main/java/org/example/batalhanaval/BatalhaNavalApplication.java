package org.example.batalhanaval;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BatalhaNavalApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(BatalhaNavalApplication.class.getResource("batalha-naval.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Batalha Naval");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}