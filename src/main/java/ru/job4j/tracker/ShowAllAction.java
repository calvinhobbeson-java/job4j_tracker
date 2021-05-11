package ru.job4j.tracker;

public class ShowAllAction implements UserAction {

    private final Output out;

    public ShowAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Showing all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Show all items ====");
        Item[] result = tracker.findAll();
        if (result.length > 0) {
            for (Item item : result) {
                out.println(item);
            }
        } else {
            out.println("Заявки с таким именем не найдены");
        }
        return true;
    }
}