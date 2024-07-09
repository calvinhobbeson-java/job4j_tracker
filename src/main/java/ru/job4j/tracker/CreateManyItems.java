package ru.job4j.tracker;

public class CreateManyItems implements UserAction {
    private final Output out;

    public CreateManyItems(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Add many new Items";
    }

    @Override
    public boolean execute(Input input, Store memTracker) {
        out.println("=== Create a lot of new Items ====");
        String name = input.askStr("Enter  name");
        int count = input.askInt("Enter count ");
        for (int index = 0; index < count; index++) {
            Item item = new Item(name);
            memTracker.add(item);
        }
        return true;
    }
}