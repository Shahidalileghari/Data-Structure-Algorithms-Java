package com.dsa.datastructures.linked;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/** A generic doubly linked list with constant-time insertion/removal at either end. */
public final class DoublyLinkedList<E> implements Iterable<E> {
    private static final class Node<E> { E value; Node<E> prev, next; Node(E value) { this.value = value; } }
    private Node<E> head, tail;
    private int size;
    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }
    public void addFirst(E value) { Node<E> n = new Node<>(value); if (head == null) head = tail = n; else { n.next = head; head.prev = n; head = n; } size++; }
    public void addLast(E value) { Node<E> n = new Node<>(value); if (tail == null) head = tail = n; else { n.prev = tail; tail.next = n; tail = n; } size++; }
    public E get(int index) { return nodeAt(index).value; }
    public E removeFirst() { if (head == null) throw new NoSuchElementException("List is empty"); return unlink(head); }
    public E removeLast() { if (tail == null) throw new NoSuchElementException("List is empty"); return unlink(tail); }
    public E removeAt(int index) { return unlink(nodeAt(index)); }
    public boolean contains(E value) { for (Node<E> n = head; n != null; n = n.next) if (Objects.equals(n.value, value)) return true; return false; }
    public void clear() { head = tail = null; size = 0; }
    private E unlink(Node<E> n) { if (n.prev == null) head = n.next; else n.prev.next = n.next; if (n.next == null) tail = n.prev; else n.next.prev = n.prev; size--; return n.value; }
    private Node<E> nodeAt(int i) { if (i < 0 || i >= size) throw new IndexOutOfBoundsException("Index: " + i + ", size: " + size); if (i < size / 2) { Node<E> n = head; for (int x=0;x<i;x++) n=n.next; return n; } Node<E> n=tail; for(int x=size-1;x>i;x--) n=n.prev; return n; }
    @Override public Iterator<E> iterator() { return new Iterator<>() { Node<E> n=head; public boolean hasNext(){return n!=null;} public E next(){if(n==null) throw new NoSuchElementException(); E v=n.value; n=n.next; return v;} }; }
}
