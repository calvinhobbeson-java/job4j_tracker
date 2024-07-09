package ru.job4j.tracker;

import java.util.List;

public class FindByNameAction implements UserAction {

    private final Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find item by name";
    }

    @Override
    public boolean execute(Input input, Store memTracker) {
        out.println("=== Find item by name ====");
        String key = input.askStr("Enter name: ");
        List<Item> result = memTracker.findByName(key);
        if (result.size() > 0) {
            for (Item item : result) {
                out.println(result);
            }
        } else {
            out.println("Operation was not successfull");
        }
        return true;
    }
}
