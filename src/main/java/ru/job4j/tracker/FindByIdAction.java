package ru.job4j.tracker;

public class FindByIdAction implements UserAction {

    private final Output out;

    public FindByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find item by id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find item by Id ====");
        int id = input.askInt("Enter id: ");
        Item result = tracker.findById(id);
        if (result != null) {
            out.println(result);
        } else {
            out.println("Заявка с таким id не найдена");
        }
        return true;
    }
}
