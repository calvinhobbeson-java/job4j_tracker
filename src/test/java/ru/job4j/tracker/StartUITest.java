package ru.job4j.tracker;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                Arrays.asList("0", "Item name", "1"));
                Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new Exit()};
        new StartUI(out).init(in, tracker, Arrays.asList(actions));
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                Arrays.asList("0", String.valueOf(item.getId()), replacedName, "1"));
        UserAction[] actions = {
                new ReplaceAction(out),
                new Exit()};
        new StartUI(out).init(in, tracker, Arrays.asList(actions));
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                Arrays.asList("0", String.valueOf(item.getId()), "1"));
        UserAction[] actions = {
                new DeleteAction(out),
                new Exit()};
        new StartUI(out).init(in, tracker, Arrays.asList(actions));
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                Arrays.asList("0"));
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new Exit()};
        new StartUI(out).init(in, tracker, Arrays.asList(actions));
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Exit" + System.lineSeparator())); }

    @Test
    public void whenFindAll() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Input in = new StubInput(
                Arrays.asList("0", "1"));
        UserAction[] actions = {
                new ShowAllAction(out),
                new Exit()};
        new StartUI(out).init(in, tracker, Arrays.asList(actions));
        assertThat(out.toString(), is("Menu." + System.lineSeparator()
                + "0. Showing all items" + System.lineSeparator()
                + "1. Exit" + System.lineSeparator()
                + "=== Show all items ====" + System.lineSeparator()
                + "Заявки с таким именем не найдены" + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0. Showing all items" + System.lineSeparator()
                + "1. Exit" + System.lineSeparator()));
    }

    @Test
    public void whenFindById() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Item name"));
        Input in = new StubInput(
                Arrays.asList("0", String.valueOf(item.getId()), "1"));
        UserAction[] actions = {
                new FindByIdAction(out),
                new Exit()};
        new StartUI(out).init(in, tracker, Arrays.asList(actions));
        assertThat(out.toString(), is("Menu." + System.lineSeparator()
                + "0. Find item by id" + System.lineSeparator()
                + "1. Exit" + System.lineSeparator()
                + "=== Find item by Id ====" + System.lineSeparator()
                + item + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0. Find item by id" + System.lineSeparator()
                + "1. Exit" + System.lineSeparator()));
    }

    @Test
    public void whenFindByName() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Item name"));
        Input in = new StubInput(
                Arrays.asList("0", item.getName(), "1"));
        UserAction[] actions = {
                new FindByNameAction(out),
                new Exit()};
        new StartUI(out).init(in, tracker, Arrays.asList(actions));
        assertThat(out.toString(), is("Menu." + System.lineSeparator()
                + "0. Find item by name" + System.lineSeparator()
                + "1. Exit" + System.lineSeparator()
                + "=== Find item by name ====" + System.lineSeparator()
                + item + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0. Find item by name" + System.lineSeparator()
                + "1. Exit" + System.lineSeparator()));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                Arrays.asList("10", "0"));
        Tracker tracker = new Tracker();
        UserAction[] actions = new UserAction[]{
                new Exit()
        };
        new StartUI(out).init(in, tracker, Arrays.asList(actions));
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. Exit" + ln
                        + "Wrong input, you can select: 0 .. 0" + ln
                        + "Menu." + ln
                        + "0. Exit" + ln
                )
        );
    }
}