package ru.job4j.stream;

public class RandomModel {

    private String name;

    private String surname;

    private byte age;

    private int prettiness;

    private String gender;

    static class Builder {
        private String name;
        private String surname;
        private byte age;
        private int prettiness;
        private String gender;

        Builder buildName(String name) {
            this.name = name;
            return this;
        }

        Builder buildSurname(String surname) {
            this.surname = surname;
            return this;
        }

        Builder buildAge(byte age) {
            this.age = age;
            return this;
        }

        Builder buildPrettiness(int prettiness) {
            this.prettiness = prettiness;
            return this;
        }

        Builder buildGender(String gender) {
            this.gender = gender;
            return this;
        }

        RandomModel build() {
            RandomModel model = new RandomModel();
            model.name = name;
            model.surname = surname;
            model.age = age;
            model.prettiness = prettiness;
            model.gender = gender;
            return model;
        }
    }

    public static void main(String[] args) {
        RandomModel model = new Builder().buildName("name")
                .buildSurname("surname")
                .buildAge((byte) 21)
                .buildPrettiness(8)
                .buildGender("female")
                .build();
        System.out.println(model);
    }
}
