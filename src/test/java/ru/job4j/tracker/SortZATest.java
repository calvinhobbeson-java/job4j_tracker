package ru.job4j.tracker;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@Ignore
public class SortZATest {
    @Test
    public void whenThreeItemsThenNaturalOrder() {
        Item first = new Item(1, "A");
        Item second = new Item(2, "B");
        Item third = new Item(3, "C");
        List<Item> items = Arrays.asList(first, second, third);
        List<Item> expect = Arrays.asList(third, second, first);
        items.sort(new SortZA());
        assertThat(items, is(expect));
    }
}