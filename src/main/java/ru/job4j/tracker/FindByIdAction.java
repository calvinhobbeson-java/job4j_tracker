package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    @Override
    public String name() {
        return "Find item by id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Find item by Id ====");
        int id = input.askInt("Enter id: ");
        Item result = tracker.findById(id);
        if (result != null) {
            System.out.println(result);
        } else {
            System.out.println("Заявка с таким id не найдена");
        }
        return true;
    }
}
