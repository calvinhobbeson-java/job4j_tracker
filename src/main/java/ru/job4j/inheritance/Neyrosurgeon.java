package ru.job4j.inheritance;

public class Neyrosurgeon extends Doctor {

    public Neyrosurgeon(String name, String surname, String education, String birthday, String diagnosis) {
        super(name, surname, education, birthday, diagnosis);
        diagnosis = "Brain damage, gonna make a lobotomy or smth";
    }

    public  String healSomeSeriousBrainShit() {
        return "-1";
    }
}
