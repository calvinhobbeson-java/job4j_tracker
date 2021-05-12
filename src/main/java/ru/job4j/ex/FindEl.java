package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int index = 0; index < value.length; index++) {
            if (value[index].equals(key)) {
                rsl = index;
            }
        }
            if (rsl == -1) {
                throw new ElementNotFoundException("Cannot find the element");
            }
        return rsl;
    }

    public static void main(String[] args) {
        try {
            String[] value = {"1", "2", "3"};
            FindEl.indexOf(value, "4");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}