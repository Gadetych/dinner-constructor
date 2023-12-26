package ru.practicum.dinner;

public class Main {
    public static void main(String[] args) {
        DinnerConstructor dc = new DinnerConstructor();
        LunchGeneratorApp app = new LunchGeneratorApp(dc);
        app.run();
    }
}
