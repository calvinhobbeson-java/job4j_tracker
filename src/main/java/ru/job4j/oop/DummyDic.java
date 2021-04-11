package ru.job4j.oop;

public class DummyDic {
    public String engToRus(String eng) {
        return "Неизвестное слово " + eng;
    }

    public static void main(String[] args) {
        DummyDic peppy = new DummyDic();
        String say = peppy.engToRus("Joy");
        System.out.println(say);
    }
}
