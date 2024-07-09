package ru.job4j.tracker;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                Arrays.asList("0", "Item name", "1"));
                MemTracker memTracker = new MemTracker();
        UserAction[] actions = {
                new CreateAction(out),
                new Exit()};
        new StartUI(out).init(in, memTracker, Arrays.asList(actions));
        assertThat(memTracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item item = memTracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                Arrays.asList("0", String.valueOf(item.getId()), replacedName, "1"));
        UserAction[] actions = {
                new ReplaceAction(out),
                new Exit()};
        new StartUI(out).init(in, memTracker, Arrays.asList(actions));
        assertThat(memTracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item item = memTracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                Arrays.asList("0", String.valueOf(item.getId()), "1"));
        UserAction[] actions = {
                new DeleteAction(out),
                new Exit()};
        new StartUI(out).init(in, memTracker, Arrays.asList(actions));
        assertThat(memTracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                Arrays.asList("0"));
        MemTracker memTracker = new MemTracker();
        UserAction[] actions = {
                new Exit()};
        new StartUI(out).init(in, memTracker, Arrays.asList(actions));
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Exit" + System.lineSeparator())); }

    @Test
    public void whenFindAll() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Input in = new StubInput(
                Arrays.asList("0", "1"));
        UserAction[] actions = {
                new ShowAllAction(out),
                new Exit()};
        new StartUI(out).init(in, memTracker, Arrays.asList(actions));
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
        MemTracker memTracker = new MemTracker();
        Item item = memTracker.add(new Item("Item name"));
        Input in = new StubInput(
                Arrays.asList("0", String.valueOf(item.getId()), "1"));
        UserAction[] actions = {
                new FindByIdAction(out),
                new Exit()};
        new StartUI(out).init(in, memTracker, Arrays.asList(actions));
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
        MemTracker memTracker = new MemTracker();
        Item item = memTracker.add(new Item("Item name"));
        Input in = new StubInput(
                Arrays.asList("0", item.getName(), "1"));
        UserAction[] actions = {
                new FindByNameAction(out),
                new Exit()};
        new StartUI(out).init(in, memTracker, Arrays.asList(actions));
        assertThat(out.toString(), is("Menu." + System.lineSeparator()
                + "0. Find item by name" + System.lineSeparator()
                + "1. Exit" + System.lineSeparator()
                + "=== Find item by name ====" + System.lineSeparator()
                + memTracker.findByName("Item name") + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0. Find item by name" + System.lineSeparator()
                + "1. Exit" + System.lineSeparator()));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                Arrays.asList("10", "0"));
        MemTracker memTracker = new MemTracker();
        UserAction[] actions = new UserAction[]{
                new Exit()
        };
        new StartUI(out).init(in, memTracker, Arrays.asList(actions));
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

    @Test
    public void whenItemWasReplacedSuccessfully() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        ReplaceAction replaceAction = new ReplaceAction(output);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);
        when(input.askStr(any(String.class))).thenReturn(replacedName);

        replaceAction.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(output.toString(), is(
                "=== Edit item ====" + ln
                        + "Successfull operation" + ln
        )
        );
    }

    @Test
    public void whenItemWasReplacedUnsuccessfully() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        ReplaceAction replaceAction = new ReplaceAction(output);

        Input input = mock(Input.class);

        replaceAction.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(output.toString(), is(
                        "=== Edit item ====" + ln
                                + "Operation was not successfull" + ln
                )
        );
    }

    @Test
    public void whenItemWasDeletedSuccessfully() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("Deleted item"));
        DeleteAction deleteAction = new DeleteAction(output);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);

        deleteAction.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(output.toString(), is(
                        "=== Delete item ====" + ln
                                + "Successfull operation" + ln
                )
        );
    }

    @Test
    public void whenItemWasDeletedUnsuccessfully() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("Deleted item"));
        DeleteAction deleteAction = new DeleteAction(output);

        Input input = mock(Input.class);

        deleteAction.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(output.toString(), is(
                        "=== Delete item ====" + ln
                                + "Operation was not successfull" + ln
                )
        );
    }

    @Test
    public void whenItemFindedByIdSuccessfully() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("An item"));
        FindByIdAction findByIdAction = new FindByIdAction(output);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);

        findByIdAction.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(output.toString(), is(
                        "=== Find item by Id ====" + ln
                                + tracker.findById(1) + ln
                )
        );
    }

    @Test
    public void whenItemFindedByIdUnsuccessfully() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("An item"));
        FindByIdAction findByIdAction = new FindByIdAction(output);

        Input input = mock(Input.class);

        findByIdAction.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(output.toString(), is(
                        "=== Find item by Id ====" + ln
                                + "Operation was not successfull" + ln
                )
        );
    }

    @Test
    public void whenItemFindedByNameSuccessfully() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("An item"));
        String name = "An item";
        FindByNameAction findByNameAction = new FindByNameAction(output);

        Input input = mock(Input.class);

        when(input.askStr(any(String.class))).thenReturn(name);

        findByNameAction.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(output.toString(), is(
                        "=== Find item by name ====" + ln
                                + tracker.findByName(name) + ln
                )
        );
    }

    @Test
    public void whenItemFindedByNameUnsuccessfully() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("An item"));
        String name = "An item";
        FindByNameAction findByNameAction = new FindByNameAction(output);

        Input input = mock(Input.class);

        findByNameAction.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(output.toString(), is(
                        "=== Find item by name ====" + ln
                                + "Operation was not successfull" + ln
                )
        );
    }
}