package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MatrixToList {
    public List<Integer> collect(Integer[][] numbers) {
        return Stream.of(numbers).flatMap(e -> e.stream()).collect(Collectors.toList());
    }
}