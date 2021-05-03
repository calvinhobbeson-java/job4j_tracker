package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
                } else if (select == 1) {
                        System.out.println("=== Show all items ====");
                        Item[] result = tracker.findAll();
                        for (Item item : result) {
                            System.out.println(item);
                }
                    } else if (select == 2) {
                            System.out.println("=== Edit item ====");
                            System.out.print("Enter id: ");
                            int id = Integer.valueOf(scanner.nextLine());
                            System.out.print("Enter name: ");
                            String name = scanner.nextLine();
                            Item item = new Item(name);
                            if (tracker.replace(id, item)) {
                                System.out.println("Successfull operation");
                            } else {
                                System.out.println("Operation was not successfull");
                            }
                        } else if (select == 3) {
                                System.out.println("=== Delete item ====");
                                System.out.print("Enter id: ");
                                int id = Integer.valueOf(scanner.nextLine());
                                if (tracker.delete(id)) {
                                    System.out.println("Заявка удалена");
                                } else {
                                    System.out.println("Заявка не была удалена");
                                }
                            } else if (select == 4) {
                                    System.out.println("=== Find item by Id ====");
                                    System.out.print("Enter id: ");
                                    int id = Integer.valueOf(scanner.nextLine());
                                    Item result = tracker.findById(id);
                                    if (result != null) {
                                        System.out.println(result);
                                    } else {
                                        System.out.println("Заявка с таким id не найдена");
                                    }
                                } else if (select == 5) {
                                        System.out.println("=== Find item by name ====");
                                        System.out.print("Enter name: ");
                                        String key = scanner.nextLine();
                                        Item[] result = tracker.findByName(key);
                                        if (result.length > 0) {
                                            for (Item item : result) {
                                                System.out.println(item);
                                            }
                                        } else {
                                            System.out.println("Заявки с таким именем не найдены");
                                        }
                            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}