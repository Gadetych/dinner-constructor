package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Scanner;

public class LunchGeneratorApp {

    final static String ADD_NEW_DISH = "1";
    final static String GENERATE_COMBO_OF_DISHES = "2";
    final static String EXIT = "3";

    private Scanner scanner;
    private DinnerConstructor dc;

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
        int numberOfCombos = Integer.parseInt(scanner.nextLine());
        String nextItem;
        boolean flag = true;
        ArrayList<String> typesDishes = new ArrayList<>();

//        dc.testing("первое", "суп гороховый", "борщ", "щи");
//        dc.testing("гарнир", "гречка", "рис", "пюре");
//        dc.testing("салат", "фруктовый", "капустный", "свекольный с чесноком");
        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");

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

        ArrayList<ArrayList<String>> listOfCombo = dc.generateComboLunch(typesDishes, numberOfCombos);

        for (int i = 0; i < listOfCombo.size(); i++) {
            System.out.println("Комбо " + (i + 1));
            System.out.println(listOfCombo.get(i).toString());
        }

    }
}
