package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int index = 0;
        String[] leftArray = left.split(". ");
        String[] rightArray = right.split(". ");
        int leftInt = Integer.parseInt(leftArray[index]);
        int rightInt = Integer.parseInt(rightArray[index]);
        return Integer.compare(leftInt, rightInt);
    }
}