package ru.job4j.tracker;

import java.util.List;

public class DeleteManyAction implements UserAction {
    private final Output out;

    public DeleteManyAction(Output out) {
        this.out = out;
    }


    public String name() {
        return "Delete all items";
    }

    public boolean execute(Input input, Store memTracker) {
        out.println("=== Delete all items ====");
        List<Item> items = memTracker.findAll();
        for (Item item : items) {
            memTracker.delete(item.getId());
        }
        return true;
    }
}
