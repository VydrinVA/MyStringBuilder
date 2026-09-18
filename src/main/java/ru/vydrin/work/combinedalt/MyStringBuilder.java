package ru.vydrin.work.combinedalt;

import java.util.Arrays;

public class MyStringBuilder {
    private char[] value;
    private int count;

    public MyStringBuilder() {
        value = new char[16];
        count = 0;
    }

    public MyStringBuilder(String string) {
        char[] chars = string.toCharArray();
        value = new char[Math.max(16, value.length * 2)];
        System.arraycopy(value, 0, chars, 0, value.length);

        count = value.length;
    }

    public void append(String string) {
        char[] stringInChars = string.toCharArray();

        ensureCapacity(count + stringInChars.length);

        int stringCount = 0;

        while(stringCount < stringInChars.length) {
            value[count] = stringInChars[stringCount];
            count++;
            stringCount++;
        }
    }

    public Memento createMemento() {
        return new Snapshot(
                Arrays.copyOf(value, value.length),
                count
        );
    }

    public void restore(Memento memento) {
        Snapshot snapshot = (Snapshot) memento;

        this.value = Arrays.copyOf(
                snapshot.value,
                snapshot.value.length
        );

        this.count = snapshot.count;
    }

    @Override
    public String toString() {
        return new String(value, 0, count);
    }

    private static final class Snapshot implements Memento {
        private final char[] value;
        private final int count;

        private Snapshot(char[] value, int count) {
            this.value = value;
            this.count = count;
        }
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
}