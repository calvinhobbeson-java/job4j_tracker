package ru.job4j.stream;

import org.junit.Test;
import java.util.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StudentMapTest {

    @Test
    public void whenListToMapThenMap() {
        Student student1 = new Student(10, "Pahomov");
        Student student2 = new Student(100, "Olegov");
        Student student3 = new Student(90, "Vasiliev");
        Student student4 = new Student(10, "Pahomov");
        List<Student> students = Arrays.asList(student1, student2, student3, student4);

        StudentMap studentmap = new StudentMap();
        Map<String, Student> rsl = studentmap.collect(students);
        Map<String, Student> expected = new HashMap<>();
        expected.put(student1.getSurname(), student1);
        expected.put(student2.getSurname(), student2);
        expected.put(student3.getSurname(), student3);

        assertThat(rsl, is(expected));
    }
}