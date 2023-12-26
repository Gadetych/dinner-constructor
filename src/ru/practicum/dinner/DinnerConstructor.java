package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {

    private HashMap<String, ArrayList<String>> menuRestaurant = new HashMap<>();
    private Random random = new Random();

    public HashMap<String, ArrayList<String>> getMenuRestaurant() {
        return menuRestaurant;
    }

    public void addNewDish(String dishType, String dishName) {
        ArrayList<String> arrayDishes = menuRestaurant.get(dishType);
        if (arrayDishes == null) {
            arrayDishes = new ArrayList<>();
            arrayDishes.add(dishName);
            menuRestaurant.put(dishType, arrayDishes);
        } else {
            arrayDishes.add(dishName);
        }

    }

    public ArrayList<ArrayList<String>> generateComboLunch(ArrayList<String> typesDishes, int numberOfCombos) {
        ArrayList<ArrayList<String>> listOfCombos = new ArrayList<>(numberOfCombos);
        for (int i = 0; i < numberOfCombos; i++) {
            ArrayList<String> combo = new ArrayList<>();
            for (String type : typesDishes) {
                ArrayList<String> listOfDishesByType = menuRestaurant.get(type);
                int index = random.nextInt(listOfDishesByType.size());
                combo.add(listOfDishesByType.get(index));
            }
            listOfCombos.add(combo);
        }

        return listOfCombos;
    }

    public void testing(String type, String dish1, String dish2, String dish3) {
        ArrayList<String> dishes = new ArrayList<>();
        dishes.add(dish1);
        dishes.add(dish2);
        dishes.add(dish3);
        menuRestaurant.put(type, dishes);
    }

}
