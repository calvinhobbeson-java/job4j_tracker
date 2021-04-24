package ru.job4j.oop;

public class Error {

   private boolean active;
   private int status;
   private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Activity " + active);
        System.out.println("Status " + status);
        System.out.println("Message " + message);
    }

    public static void main(String[] args) {
        Error error = new Error();
        Error errorTwo = new Error(true, 1, "Nominal");
        Error errorThree = new Error(false, 2, "Active");
        error.printInfo();
        errorTwo.printInfo();
        errorThree.printInfo();
    }
}
