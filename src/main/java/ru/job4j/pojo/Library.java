package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book firstBook = new Book();
        firstBook.setName("Clean Code");
        Book secondBook = new Book();
        Book thirdBook = new Book();
        Book forthBook = new Book();
        Book[] books = new Book[4];
        books[0] = firstBook;
        books[1] = secondBook;
        books[2] = thirdBook;
        books[3] = forthBook;
        for (Book book : books) {
            System.out.println(book);
        }

        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;

        for (Book book : books) {
            if (book.getName() != null && book.getName().equals("Clean Code")) {
                System.out.println(book);
            }
        }
    }
}
