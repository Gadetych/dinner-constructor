package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LunchGeneratorApp {

    final static String ADD_NEW_DISH = "1";
    final static String GENERATE_COMBO_OF_DISHES = "2";
    final static String EXIT = "3";

    private final Scanner scanner;
    private final DinnerConstructor dc;

    LunchGeneratorApp(DinnerConstructor dc) {
        this.scanner = new Scanner(System.in);
        this.dc = dc;
    }

    public void run() {
        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case ADD_NEW_DISH -> addNewDish();
                case GENERATE_COMBO_OF_DISHES -> generateDishCombo();
                case EXIT -> {
                    scanner.close();
                    return;
                }
                default -> System.out.println("Неверная команда!");
            }
        }
    }

    private void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();
        if (dishType.equals("") || dishName.equals("")) {
            System.out.println("Введены некорректные данные!");
        } else {
            dc.addNewDish(dishType, dishName);
        }
    }

    private void generateDishCombo() {
        System.out.println("Начинаем конструировать обед...");
        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = setNumberOfCombos();
        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
        List<String> typesDishes = setTypesDishes();
        List<List<String>> listOfCombo = dc.generateComboLunch(typesDishes, numberOfCombos);

        for (int i = 0; i < listOfCombo.size(); i++) {
            System.out.println("Комбо " + (i + 1));
            System.out.println(listOfCombo.get(i).toString());
        }

    }

    private int setNumberOfCombos() {
        boolean flag = true;
        int numberOfCombos = 1;
        while (flag) {
            numberOfCombos = Integer.parseInt(scanner.nextLine());
            if (numberOfCombos > 0) {
                flag = false;
            } else {
                System.out.println("Количество наборов должно быть больше 0");
            }
        }
        return numberOfCombos;
    }

    private List<String> setTypesDishes() {
        List<String> typesDishes = new ArrayList<>();
        String nextItem;
        boolean flag = true;

        while (flag) {
            nextItem = scanner.nextLine();
            if (nextItem.isEmpty()) {
                flag = false;
            } else if (dc.getMenuRestaurant().get(nextItem) == null) {
                System.out.println("Несуществующий тип блюда.");
                System.out.print("Выберете из списка: ");
                for (String type : dc.getMenuRestaurant().keySet()) {
                    System.out.print(type + " ");
                }
                System.out.println();
            } else {
                typesDishes.add(nextItem);
            }
        }
        return typesDishes;

    }
}
