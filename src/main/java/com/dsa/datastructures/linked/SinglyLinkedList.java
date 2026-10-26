package com.dsa.datastructures.linked;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/** A generic singly linked list. */
public final class SinglyLinkedList<E> implements Iterable<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    private static final class Node<E> {
        private E value;
        private Node<E> next;
        private Node(E value) { this.value = value; }
    }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    /** Adds an element to the front in O(1). */
    public void addFirst(E value) {
        Node<E> node = new Node<>(value);
        node.next = head;
        head = node;
        if (tail == null) tail = node;
        size++;
    }

    /** Adds an element to the end in O(1). */
    public void addLast(E value) {
        Node<E> node = new Node<>(value);
        if (tail == null) head = tail = node;
        else { tail.next = node; tail = node; }
        size++;
    }

    public E get(int index) {
        checkElementIndex(index);
        return nodeAt(index).value;
    }

    public void insert(int index, E value) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("Index: " + index);
        if (index == 0) { addFirst(value); return; }
        if (index == size) { addLast(value); return; }
        Node<E> previous = nodeAt(index - 1);
        Node<E> node = new Node<>(value);
        node.next = previous.next;
        previous.next = node;
        size++;
    }

    public E removeFirst() {
        if (head == null) throw new NoSuchElementException("List is empty");
        E value = head.value;
        head = head.next;
        if (head == null) tail = null;
        size--;
        return value;
    }

    public E removeAt(int index) {
        checkElementIndex(index);
        if (index == 0) return removeFirst();
        Node<E> previous = nodeAt(index - 1);
        Node<E> removed = previous.next;
        previous.next = removed.next;
        if (removed == tail) tail = previous;
        size--;
        return removed.value;
    }

    public int indexOf(E value) {
        int index = 0;
        for (Node<E> node = head; node != null; node = node.next, index++) {
            if (Objects.equals(node.value, value)) return index;
        }
        return -1;
    }

    public boolean contains(E value) { return indexOf(value) >= 0; }

    public void clear() { head = tail = null; size = 0; }

    @Override public Iterator<E> iterator() {
        return new Iterator<>() {
            private Node<E> cursor = head;
            public boolean hasNext() { return cursor != null; }
            public E next() {
                if (cursor == null) throw new NoSuchElementException();
                E value = cursor.value;
                cursor = cursor.next;
                return value;
            }
        };
    }

    private Node<E> nodeAt(int index) {
        Node<E> current = head;
        for (int i = 0; i < index; i++) current = current.next;
        return current;
    }

    private void checkElementIndex(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index: " + index + ", size: " + size);
    }
}
