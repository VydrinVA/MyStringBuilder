package ru.vydrin.work.combinedalt;

import java.util.ArrayDeque;
import java.util.Deque;

/*
    Реализация с объединеним Originator + Caretaker,
    но Caretaker выделен в отдельную структуру
*/
public class UndoableStringBuilder {
    private final MyStringBuilder builder = new MyStringBuilder();

    private final Deque<Memento> history =
            new ArrayDeque<>();

    public void append(String string) {
        save();
        builder.append(string);
    }

    public void undo() {
        if (!history.isEmpty()) {
            builder.restore(history.pop());
        }
    }

    private void save() {
        history.push(builder.createMemento());
    }

    @Override
    public String toString() {
        return builder.toString();
    }
}
