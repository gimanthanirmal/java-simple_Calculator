package com.example.calculatorv2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CalculatorApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CalculatorApplication.class.getResource("calculator-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load()); // Adjust size to fit your design
        stage.setTitle("Simple Calculator v2");
        stage.setScene(scene);
        stage.setResizable(false);

        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}