package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFio("Olegov Oleg Olegovich");
        student.setGroup("first group");
        student.setDate("25.10.2023");
        System.out.println(student.getFio() + " " + student.getGroup() + " " + student.getDate());
    }
}
