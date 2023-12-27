package ru.practicum.dinner;

public class Main {
    public static void main(String[] args) {
//        если реализовывать dependency injection, то классы сканер и рандом мне надо инициировать тут?
//        или нынешняя реализация тоже допустима?
        DinnerConstructor dc = new DinnerConstructor();
        LunchGeneratorApp app = new LunchGeneratorApp(dc);
        app.run();
    }
}
