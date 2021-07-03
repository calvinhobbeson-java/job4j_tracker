package ru.job4j.stream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamUsage {
    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>();
        ints.add(-1);
        ints.add(-4);
        ints.add(2);
        ints.add(-1);
        ints.add(1);
        List<Integer> positive = ints.stream()
                .filter(i -> i > 0)
                .collect(Collectors.toList());
        positive.forEach(System.out::println);
    }
}
