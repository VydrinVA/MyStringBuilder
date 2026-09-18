package ru.vydrin.work.combined;


import java.nio.charset.StandardCharsets;
import java.util.Arrays;

// Реализация с объединением Originator + Caretaker
public class MyStringBuilder {
    char[] value;
    int count;
    Snapshot snapshot;

    public MyStringBuilder() {
        value = new char[16];
        count = 0;
        snapshot = null;
    }

    public MyStringBuilder(String string) {
        char[] chars = string.toCharArray();
        value = new char[Math.max(16, value.length * 2)];
        System.arraycopy(value, 0, chars, 0, value.length);

        count = value.length;
        snapshot = new Snapshot(Arrays.copyOf(value, value.length), count, null);
    }

    public void append(String string) {
        snapshot = new Snapshot(
                Arrays.copyOf(value, value.length), count, snapshot
        );
        char[] stringInChars = string.toCharArray();

        ensureCapacity(count + stringInChars.length);

        int stringCount = 0;

        while(stringCount < stringInChars.length) {
            value[count] = stringInChars[stringCount];
            count++;
            stringCount++;
        }
    }

    public void undo() {
        if (snapshot == null)
            return;
        this.value = snapshot.value;
        this.count = snapshot.count;
        this.snapshot = snapshot.previous;
    }

    @Override
    public String toString() {
        return new String(value, 0, count);
    }

    private void ensureCapacity(int length) {
        if (length >= value.length) {
            char[] temp = new char[length * 2 + 2];
            for (int i = 0; i < count; i++) {
                temp[i] = value[i];
            }
            value = temp;
        }
    }

    private static class Snapshot {
        private final char[] value;
        private final int count;
        private final Snapshot previous;

        private Snapshot(char[] value, int count, Snapshot previous) {
            this.value = value;
            this.count = count;
            this.previous = previous;
        }
    }
}
