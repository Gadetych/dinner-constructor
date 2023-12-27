package ru.practicum.dinner;

import java.util.*;

public class DinnerConstructor {

    private final Map<String, List<String>> menuRestaurant = new HashMap<>();
    private final Random random = new Random();

    public Map<String, List<String>> getMenuRestaurant() {
        return menuRestaurant;
    }

    public void addNewDish(String dishType, String dishName) {
        List<String> arrayDishes = menuRestaurant.get(dishType);
        if (arrayDishes == null) {
            arrayDishes = new ArrayList<>();
            arrayDishes.add(dishName);
            menuRestaurant.put(dishType, arrayDishes);
        } else {
            arrayDishes.add(dishName);
        }

    }

    public List<List<String>> generateComboLunch(List<String> typesDishes, int numberOfCombos) {
        List<List<String>> listOfCombos = new ArrayList<>(numberOfCombos);
        for (int i = 0; i < numberOfCombos; i++) {
            List<String> combo = new ArrayList<>();
            for (String type : typesDishes) {
                List<String> listOfDishesByType = menuRestaurant.get(type);
                int index = random.nextInt(listOfDishesByType.size());
                combo.add(listOfDishesByType.get(index));
            }
            listOfCombos.add(combo);
        }

        return listOfCombos;
    }
}
