package ru.job4j.tracker;

public class StartUI {

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void replaceItem(Input input, Tracker tracker) {
        System.out.println("=== Edit item ====");
        System.out.print("Enter id: ");
        int id = input.askInt("Select: ");
        System.out.print("Enter name: ");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("Successfull operation");
        } else {
            System.out.println("Operation was not successfull");
        }
    }

    public static void showAll(Input input, Tracker tracker) {
        System.out.println("=== Show all items ====");
        Item[] result = tracker.findAll();
        if (result.length > 0) {
            for (Item item : result) {
                System.out.println(item);
            }
        } else {
            System.out.println("Заявки с таким именем не найдены");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete item ====");
        System.out.print("Enter id: ");
        int id = input.askInt("Select: ");
        if (tracker.delete(id)) {
            System.out.println("Заявка удалена");
        } else {
            System.out.println("Заявка не была удалена");
        }
    }

    public static void findById(Input input, Tracker tracker) {
        System.out.println("=== Find item by Id ====");
        System.out.print("Enter id: ");
        int id = input.askInt("Select: ");
        Item result = tracker.findById(id);
        if (result != null) {
            System.out.println(result);
        } else {
            System.out.println("Заявка с таким id не найдена");
        }
    }

    public static void findByName(Input input, Tracker tracker) {
        System.out.println("=== Find item by name ====");
        System.out.print("Enter name: ");
        String key = input.askStr("Enter name: ");
        Item[] result = tracker.findByName(key);
        if (result.length > 0) {
            for (Item item : result) {
                System.out.println(item);
            }
        } else {
            System.out.println("Заявки с таким именем не найдены");
        }
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
                StartUI.showAll(input, tracker);
            } else if (select == 2) {
                StartUI.replaceItem(input, tracker);
            } else if (select == 3) {
                StartUI.deleteItem(input, tracker);
            } else if (select == 4) {
                StartUI.findById(input, tracker);
            } else if (select == 5) {
                StartUI.findByName(input, tracker);
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
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}