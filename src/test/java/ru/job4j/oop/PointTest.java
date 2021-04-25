package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {
    @Test
    public void when00to20then2() {
        int expected = 2;
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        double out = a.distance(b);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when00to30then3() {
        int expected = 3;
        Point a = new Point(0, 0);
        Point b = new Point(3, 0);
        double out = a.distance(b);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when000to300then3() {
        int expected = 3;
        Point a = new Point(0, 0, 0);
        Point b = new Point(3, 0, 0);
        double out = a.distance(b);
        Assert.assertEquals(expected, out, 0.01);
    }
}