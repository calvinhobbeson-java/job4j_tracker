package ru.job4j.inheritance;

public class Neyrosurgeon extends Doctor {

    private String diagnosis = "Brain damage, gonna make a lobotomy or smth";

    public  String healSomeSeriousBrainShit() {
        return diagnosis;
    }
}
