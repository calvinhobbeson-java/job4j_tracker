package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MatrixToListTest {
    @Test
    public void whenMatrixToListThanList() {
        MatrixToList matrixToList = new MatrixToList();
        Integer[][] matrix = {{3, 4}, {1, 10}};
        List<Integer> rsl = matrixToList.collect(matrix);
        List<Integer> expected = List.of(3, 4, 1, 10);
        assertThat(expected, is(rsl));
}
}