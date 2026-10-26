package com.dsa.datastructures.stack;

import java.util.NoSuchElementException;

/** A generic LIFO stack backed by a dynamically growing array. */
public final class ArrayStack<E> {
    private Object[] elements = new Object[8];
    private int size;

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    public void push(E value) {
        if (size == elements.length) {
            Object[] grown = new Object[elements.length * 2];
            System.arraycopy(elements, 0, grown, 0, size);
            elements = grown;
        }
        elements[size++] = value;
    }

    public E peek() {
        ensureNotEmpty();
        return elementAt(size - 1);
    }

    public E pop() {
        ensureNotEmpty();
        E value = elementAt(--size);
        elements[size] = null;
        return value;
    }

    public void clear() {
        for (int i = 0; i < size; i++) elements[i] = null;
        size = 0;
    }

    private void ensureNotEmpty() {
        if (isEmpty()) throw new NoSuchElementException("Stack is empty");
    }

    @SuppressWarnings("unchecked")
    private E elementAt(int index) { return (E) elements[index]; }
}
