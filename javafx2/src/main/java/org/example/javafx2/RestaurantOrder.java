package org.example.javafx2;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class RestaurantOrder extends Application {
    private static class Dish {
        String name;
        double price;

        Dish(String name, double price) {
            this.name = name;
            this.price = price;
        }
    }

    private List<Dish> menu = List.of(
            new Dish("Паста", 250),
            new Dish("Пицца", 300),
            new Dish("Салат", 150)
    );

    @Override
    public void start(Stage primaryStage) {
        VBox vbox = new VBox(10);
        List<CheckBox> dishCheckBoxes = new ArrayList<>();
        List<TextField> quantityFields = new ArrayList<>();

        // Создаем интерфейс для выбора блюд
        for (Dish dish : menu) {
            CheckBox checkBox = new CheckBox(dish.name + " - " + dish.price + "₽");
            TextField quantityField = new TextField("1");
            quantityField.setPrefWidth(50);
            quantityFields.add(quantityField);
            dishCheckBoxes.add(checkBox);
            vbox.getChildren().addAll(checkBox, quantityField);
        }

        Button orderButton = new Button("Оформить заказ");
        orderButton.setOnAction(e -> showReceipt(dishCheckBoxes, quantityFields));

        vbox.getChildren().add(orderButton);
        Scene scene = new Scene(vbox, 300, 300);
        primaryStage.setTitle("Заказ в ресторане");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showReceipt(List<CheckBox> dishCheckBoxes, List<TextField> quantityFields) {
        StringBuilder receipt = new StringBuilder("Чек:\n");
        double totalCost = 0;

        for (int i = 0; i < dishCheckBoxes.size(); i++) {
            if (dishCheckBoxes.get(i).isSelected()) {
                int quantity = Integer.parseInt(quantityFields.get(i).getText());
                double price = menu.get(i).price;
                double cost = quantity * price;
                receipt.append(dishCheckBoxes.get(i).getText()).append(" x").append(quantity)
                        .append(" = ").append(cost).append("₽\n");
                totalCost += cost;
            }
        }

        receipt.append("Итого: ").append(String.format("%.2f", totalCost)).append("₽");

        // Создаем модальное окно для отображения чека
        Stage receiptStage = new Stage();
        receiptStage.initModality(Modality.APPLICATION_MODAL);
        receiptStage.setTitle("Чек");
        TextArea receiptArea = new TextArea(receipt.toString());
        receiptArea.setEditable(false);
        Scene receiptScene = new Scene(receiptArea, 300, 200);
        receiptStage.setScene(receiptScene);
        receiptStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}