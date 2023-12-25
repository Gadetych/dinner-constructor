package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;
    final static String ADD_NEW_DISHES = "1";
    final static String GENERATE_COMBO_OF_DISHES = "2";
    final static String EXIT = "3";

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case ADD_NEW_DISHES:
                    addNewDish();
                    break;
                case GENERATE_COMBO_OF_DISHES:
                    generateDishCombo();
                    break;
                case EXIT:
                    return;
                default:
                    System.out.println("Неверная команда!");
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();
        if (dishType.equals("") || dishName.equals("")) {
            System.out.println("Введены некорректные данные!");
        } else {
            dc.addDish(dishType, dishName);
        }
    }

    private static void generateDishCombo() {
        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
        String nextItem = "type";
        ArrayList<String> typesDishes = new ArrayList<>();

        //реализуйте ввод типов блюд
        while (!nextItem.isEmpty()) {
            nextItem = scanner.nextLine();
            typesDishes.add(nextItem);
        }

        // сгенерируйте комбинации блюд и выведите на экран

    }
}
