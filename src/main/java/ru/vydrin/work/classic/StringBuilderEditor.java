package ru.vydrin.work.classic;

import java.util.ArrayDeque;
import java.util.Deque;

public class StringBuilderEditor {
    private final MyStringBuilder builder;
    private final Deque<Memento> history = new ArrayDeque<>();

    public StringBuilderEditor() {
        this.builder = new MyStringBuilder();
    }

    public StringBuilderEditor(String string) {
        this.builder = new MyStringBuilder(string);
    }

    public void append(String string) {
        history.push(builder.createSnapshot());
        builder.append(string);
    }

    public void undo() {
        if (history.isEmpty())
            return;

        builder.restore(history.pop());
    }

    @Override
    public String toString() {
        return builder.toString();
    }
}
