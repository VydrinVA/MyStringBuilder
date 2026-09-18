package ru.vydrin.work.classic;

import java.util.ArrayDeque;
import java.util.Deque;

public class History {
    private final Deque<Memento> snapshots =
            new ArrayDeque<>();

    public void save(MyStringBuilder builder) {
        snapshots.push(builder.createSnapshot());
    }

    public void undo(MyStringBuilder builder) {
        if (snapshots.isEmpty()) {
            return;
        }

        builder.restore(snapshots.pop());
    }
}