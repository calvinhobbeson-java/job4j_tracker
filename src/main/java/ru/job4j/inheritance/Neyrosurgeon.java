package ru.job4j.inheritance;

public class Neyrosurgeon extends Doctor {

    public Neyrosurgeon(String name, String surname,
                        String education, String birthday,
                        String diagnosis) {
        super(name, surname, education, birthday, diagnosis);
    }

    public  String healSomeSeriousBrainShit() {
        return "-1";
    }
}
