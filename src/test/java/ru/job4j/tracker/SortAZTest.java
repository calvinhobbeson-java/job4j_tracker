package ru.job4j.tracker;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@Ignore
public class SortAZTest {
    @Test
    public void whenThreeItemsThenNaturalOrder() {
        Item first = new Item(1, "A");
        Item second = new Item(2, "B");
        Item third = new Item(3, "C");
        List<Item> items = Arrays.asList(third, first, second);
        List<Item> expect = Arrays.asList(first, second, third);
        items.sort(new SortAZ());
        assertThat(items, is(expect));
    }
}