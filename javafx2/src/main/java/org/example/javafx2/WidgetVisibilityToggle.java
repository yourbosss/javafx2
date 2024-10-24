package org.example.javafx2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WidgetVisibilityToggle extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Создаем текстовые поля
        TextField widget1 = new TextField("Widget 1");
        TextField widget2 = new TextField("Widget 2");
        TextField widget3 = new TextField("Widget 3");

        // Создаем чекбоксы
        CheckBox checkBox1 = new CheckBox("Show Widget 1");
        CheckBox checkBox2 = new CheckBox("Show Widget 2");
        CheckBox checkBox3 = new CheckBox("Show Widget 3");

        // Обработчики для чекбоксов
        checkBox1.setOnAction(e -> widget1.setVisible(checkBox1.isSelected()));
        checkBox2.setOnAction(e -> widget2.setVisible(checkBox2.isSelected()));
        checkBox3.setOnAction(e -> widget3.setVisible(checkBox3.isSelected()));

        // Устанавливаем начальное состояние видимости
        widget1.setVisible(checkBox1.isSelected());
        widget2.setVisible(checkBox2.isSelected());
        widget3.setVisible(checkBox3.isSelected());

        // Создаем VBox и добавляем виджеты и чекбоксы
        VBox vbox = new VBox(widget1, checkBox1, widget2, checkBox2, widget3, checkBox3);
        Scene scene = new Scene(vbox, 300, 200);

        primaryStage.setTitle("Widget Visibility Toggle");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}