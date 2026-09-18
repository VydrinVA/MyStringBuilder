package ru.vydrin.work;

import ru.vydrin.work.classic.StringBuilderEditor;
import ru.vydrin.work.combinedalt.UndoableStringBuilder;
import ru.vydrin.work.combined.MyStringBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args )
    {
        fastCheckCombined();
        System.out.println("-----------");
        fastCheckClassic();
        System.out.println("-----------");
        fastCheckCombinedAlt();
    }

    private static void fastCheckCombined() {
        MyStringBuilder sb = new MyStringBuilder();
        sb.append("Hello ");
        sb.append("world!");
        sb.append(" And everybody else! Except you >:(");
        System.out.println(sb);
        sb.undo();
        System.out.println(sb);
    }

    private static void fastCheckClassic() {
        StringBuilderEditor sb = new StringBuilderEditor();
        sb.append("Hello ");
        sb.append("world!");
        sb.append(" And everybody else! Except you >:(");
        System.out.println(sb);
        sb.undo();
        System.out.println(sb);
    }

    private static void fastCheckCombinedAlt() {
        UndoableStringBuilder sb = new UndoableStringBuilder();
        sb.append("Hello ");
        sb.append("world!");
        sb.append(" And everybody else! Except you >:(");
        System.out.println(sb);
        sb.undo();
        System.out.println(sb);
    }
}
