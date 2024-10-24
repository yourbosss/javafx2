package org.example.javafx2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TextFlagApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Текстовый флаг");

        // Создаем RadioButton для выбора цветов
        ToggleGroup colorGroup1 = new ToggleGroup();
        ToggleGroup colorGroup2 = new ToggleGroup();
        ToggleGroup colorGroup3 = new ToggleGroup();

        RadioButton red1 = new RadioButton("Красный");
        RadioButton green1 = new RadioButton("Зеленый");
        RadioButton blue1 = new RadioButton("Синий");
        red1.setToggleGroup(colorGroup1);
        green1.setToggleGroup(colorGroup1);
        blue1.setToggleGroup(colorGroup1);

        RadioButton red2 = new RadioButton("Красный");
        RadioButton green2 = new RadioButton("Зеленый");
        RadioButton blue2 = new RadioButton("Синий");
        red2.setToggleGroup(colorGroup2);
        green2.setToggleGroup(colorGroup2);
        blue2.setToggleGroup(colorGroup2);

        RadioButton red3 = new RadioButton("Красный");
        RadioButton green3 = new RadioButton("Зеленый");
        RadioButton blue3 = new RadioButton("Синий");
        red3.setToggleGroup(colorGroup3);
        green3.setToggleGroup(colorGroup3);
        blue3.setToggleGroup(colorGroup3);

        // Кнопка для нарисовать флаг
        Button drawButton = new Button("Нарисовать");
        Label resultLabel = new Label();

        drawButton.setOnAction(e -> {
            String color1 = ((RadioButton) colorGroup1.getSelectedToggle()).getText();
            String color2 = ((RadioButton) colorGroup2.getSelectedToggle()).getText();
            String color3 = ((RadioButton) colorGroup3.getSelectedToggle()).getText();
            resultLabel.setText("Выбранные цвета: " + color1 + ", " + color2 + ", " + color3);
        });

        // Создаем VBox для размещения элементов
        VBox vbox = new VBox(10,
                new Label("Выберите цвет для первой полосы:"), red1, green1, blue1,
                new Label("Выберите цвет для второй полосы:"), red2, green2, blue2,
                new Label("Выберите цвет для третьей полосы:"), red3, green3, blue3,
                drawButton, resultLabel
        );

        // Оборачиваем VBox в ScrollPane
        ScrollPane scrollPane = new ScrollPane(vbox);
        scrollPane.setFitToWidth(true); // Устанавливаем ширину ScrollPane

        // Создаем сцену и устанавливаем ее в окно
        Scene scene = new Scene(scrollPane, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false); // Запрет изменения размера окна
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}