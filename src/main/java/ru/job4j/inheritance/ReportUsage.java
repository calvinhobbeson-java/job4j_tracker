package ru.job4j.inheritance;

public class ReportUsage {
    public static void main(String[] args) {
        TextReport report = new JSONReport();
        String text = report.generate("name", "body");
        System.out.println(text);
    }
}