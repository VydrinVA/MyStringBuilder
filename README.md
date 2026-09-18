# MyStringBuilder

My simple implementation of JDK StringBuilder

## Description

classic - максимально классическая реализация паттерна Snapshot (Memento) с полным разделением Originator и Caretaker, а также с изоляцией конкретной реализации Snapshot от Caretaker. Объединены под единый интерфейс класса StringBuilderEditor для удобства взаимодействия.

combined - реализация с совмещением Originator и Caretaker в одном классе 

combinedalt - альтернативная реализация с совмещением Originator и Caretaker, вынесена отдельная реализация базового MyStringBuilder - Originator, а UndoableStringBuilder - обёртка с возможностью undo() и одновременно Caretaker.
