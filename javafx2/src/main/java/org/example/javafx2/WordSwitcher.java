package org.example.javafx2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class WordSwitcher extends Application {
    private boolean isFirstToSecond = true;

    @Override
    public void start(Stage primaryStage) {
        TextField inputField = new TextField();
        TextField outputField = new TextField();
        outputField.setEditable(false);

        Button switchButton = new Button("→");
        switchButton.setOnAction(e -> {
            if (isFirstToSecond) {
                outputField.setText(inputField.getText());
                inputField.clear(); // Очищаем первое поле
                switchButton.setText("←");
            } else {
                inputField.setText(outputField.getText());
                outputField.clear(); // Очищаем второе поле
                switchButton.setText("→");
            }
            isFirstToSecond = !isFirstToSecond;
        });

        VBox vbox = new VBox(inputField, outputField, switchButton);
        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setTitle("Word Switcher");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}