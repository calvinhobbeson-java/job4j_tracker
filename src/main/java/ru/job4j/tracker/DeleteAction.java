package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Store memTracker) {
        out.println("=== Delete item ====");
        int id = input.askInt("Enter id: ");
        if (memTracker.delete(id)) {
            out.println("Successfull operation");
        } else {
            out.println("Operation was not successfull");
        }
        return true;
    }
}
