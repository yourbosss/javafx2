package org.example.javafx2;

import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double result = 0;
        boolean firstOperation = true;

        System.out.println("Простой калькулятор");
        System.out.println("Введите выражение (например: 5 + 3), или 'exit' для выхода:");

        while (true) {
            if (firstOperation) {
                System.out.print("Введите число: ");
                result = scanner.nextDouble();
                firstOperation = false;
            }

            System.out.print("Введите операцию (+, -, *, /) или 'exit' для выхода: ");
            String operation = scanner.next();

            if (operation.equals("exit")) {
                break;
            }

            System.out.print("Введите следующее число: ");
            double nextNumber = scanner.nextDouble();

            switch (operation) {
                case "+":
                    result += nextNumber;
                    break;
                case "-":
                    result -= nextNumber;
                    break;
                case "*":
                    result *= nextNumber;
                    break;
                case "/":
                    if (nextNumber == 0) {
                        System.out.println("Ошибка: деление на ноль!");
                        continue; // Пропускаем итерацию и не обновляем результат
                    }
                    result /= nextNumber;
                    break;
                default:
                    System.out.println("Неверная операция. Пожалуйста, попробуйте снова.");
                    continue; // Пропускаем итерацию и не обновляем результат
            }

            System.out.println("Текущий результат: " + result);
        }

        System.out.println("Выход из калькулятора. Финальный результат: " + result);
        scanner.close();
    }
}