package ru.job4j.tracker;

import java.util.Comparator;

public class SortZA implements Comparator<Item> {

    public int compare(Item first, Item second) {
        return second.getName().compareTo(first.getName());
    }
}