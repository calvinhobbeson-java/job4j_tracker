package ru.job4j.inheritance;

public class Engineer extends Profession {

    private int calculation;

    public Engineer(String name, String surname,
                    String education, String birthday,
                    int calculation) {
        super(name, surname, education, birthday);
        this.calculation = calculation;
    }

    public int doMath() {
        return calculation;
    }
}
