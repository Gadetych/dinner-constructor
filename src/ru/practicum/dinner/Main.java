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
        String nextItem;
        boolean flag = true;

//        dc.testing("первое", "суп гороховый", "борщ", "щи");
//        dc.testing("гарнир", "гречка", "рис", "пюре");
//        dc.testing("салат", "фруктовый", "капустный", "свекольный с чесноком");
        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
        ArrayList<String> typesDishes = new ArrayList<>();

        while (flag) {
            nextItem = scanner.nextLine();
            if (nextItem.isEmpty()) {
                flag = false;
            } else if (dc.getMenuRestaurant().get(nextItem) == null) {
                System.out.println("Несуществующий тип блюда.");
            } else {
                typesDishes.add(nextItem);
            }
        }
        ArrayList<ArrayList<String>> listOfCombo = dc.generateDishCombo(typesDishes, numberOfCombos);
        for (int i = 0; i < listOfCombo.size(); i++) {
            System.out.println("Комбо " + (i + 1));
            System.out.println(listOfCombo.get(i).toString());
        }

    }
}
