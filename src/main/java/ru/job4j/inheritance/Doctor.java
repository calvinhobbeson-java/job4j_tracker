package ru.job4j.inheritance;

public class Doctor extends Profession {

    private String diagnosis = "Some sickness, idk, go get some vitamins maybe";

    public String heal() {
        return diagnosis;
    }
}