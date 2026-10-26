package com.dsa.datastructures.queue;

import java.util.NoSuchElementException;

/** A FIFO queue using a circular, dynamically growing array. */
public final class CircularArrayQueue<E> {
    private Object[] elements = new Object[8];
    private int head;
    private int size;

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    public void enqueue(E value) {
        ensureCapacity(size + 1);
        int tail = (head + size) % elements.length;
        elements[tail] = value;
        size++;
    }

    public E peek() {
        ensureNotEmpty();
        return elementAt(head);
    }

    public E dequeue() {
        ensureNotEmpty();
        E value = elementAt(head);
        elements[head] = null;
        head = (head + 1) % elements.length;
        size--;
        if (size == 0) head = 0;
        return value;
    }

    public void clear() {
        while (size > 0) {
            elements[head] = null;
            head = (head + 1) % elements.length;
            size--;
        }
        head = 0;
    }

    private void ensureCapacity(int required) {
        if (required <= elements.length) return;
        Object[] grown = new Object[Math.max(required, elements.length * 2)];
        for (int i = 0; i < size; i++) grown[i] = elements[(head + i) % elements.length];
        elements = grown;
        head = 0;
    }

    private void ensureNotEmpty() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");
    }

    @SuppressWarnings("unchecked")
    private E elementAt(int index) { return (E) elements[index]; }
}
