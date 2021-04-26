package ru.job4j.inheritance;

public class Programmer extends Engineer {


    public Programmer(String name, String surname, String education, String birthday, int calculation) {
        super(name, surname, education, birthday, calculation);
        calculation = 11;
    }

    public int pushButtons() {
        return -1;
    }
}