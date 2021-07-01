package ru.job4j.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Functions {
   static List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> result = new ArrayList<>();
        for (double index = start; index < end; index++) {
            result.add(func.apply(index));
        }
        return result;
    }
}
