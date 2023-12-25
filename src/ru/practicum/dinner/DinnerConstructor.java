package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> dataBaseDishes;

    public void addDish (String dishType, String dishName) {
        ArrayList<String> arrayDishes = dataBaseDishes.get(dishType);
        if (arrayDishes == null) {
            arrayDishes = new ArrayList<>();
            arrayDishes.add(dishName);
            dataBaseDishes.put(dishType, arrayDishes);
        } else {
            arrayDishes.add(dishName);
        }

    }



}
