package com.dsa.datastructures.linear;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.IntFunction;

/**
 * A resizable array-backed list with amortized constant-time append.
 *
 * @param <E> element type; null elements are supported
 */
public final class DynamicArray<E> implements Iterable<E> {
    private static final int DEFAULT_CAPACITY = 10;

    private Object[] elements;
    private int size;

    /** Creates an empty array with default initial capacity. */
    public DynamicArray() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Creates an empty array with a requested initial capacity.
     *
     * @param initialCapacity initial storage capacity, must be non-negative
     * @throws IllegalArgumentException if initialCapacity is negative
     */
    public DynamicArray(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Initial capacity cannot be negative");
        }
        elements = new Object[Math.max(1, initialCapacity)];
    }

    /** Returns the number of elements. */
    public int size() {
        return size;
    }

    /** Returns whether the array contains no elements. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Returns the current backing storage capacity. */
    public int capacity() {
        return elements.length;
    }

    /** Appends an element. Amortized O(1). */
    public void add(E value) {
        ensureCapacity(size + 1);
        elements[size++] = value;
    }

    /**
     * Inserts an element at an index, shifting following elements right.
     * O(n).
     */
    public void insert(int index, E value) {
        checkPositionIndex(index);
        ensureCapacity(size + 1);
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = value;
        size++;
    }

    /** Returns the element at index in O(1). */
    public E get(int index) {
        checkElementIndex(index);
        return elementAt(index);
    }

    /** Replaces the element at index and returns the previous value. */
    public E set(int index, E value) {
        checkElementIndex(index);
        E previous = elementAt(index);
        elements[index] = value;
        return previous;
    }

    /** Removes and returns the element at index. O(n). */
    public E removeAt(int index) {
        checkElementIndex(index);
        E removed = elementAt(index);
        int moved = size - index - 1;
        if (moved > 0) {
            System.arraycopy(elements, index + 1, elements, index, moved);
        }
        elements[--size] = null;
        return removed;
    }

    /** Removes the first equal value, returning true when found. */
    public boolean remove(E value) {
        int index = indexOf(value);
        if (index < 0) {
            return false;
        }
        removeAt(index);
        return true;
    }

    /** Returns the first matching index, or -1 when absent. */
    public int indexOf(E value) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(elements[i], value)) {
                return i;
            }
        }
        return -1;
    }

    /** Returns true if an equal value is present. */
    public boolean contains(E value) {
        return indexOf(value) >= 0;
    }

    /** Removes all elements but retains the current capacity. */
    public void clear() {
        Arrays.fill(elements, 0, size, null);
        size = 0;
    }

    /** Returns a typed array using the supplied array constructor. */
    public <T> T[] toArray(IntFunction<T[]> generator) {
        Objects.requireNonNull(generator, "generator");
        T[] result = generator.apply(size);
        for (int i = 0; i < size; i++) {
            @SuppressWarnings("unchecked")
            T value = (T) elements[i];
            result[i] = value;
        }
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private int cursor;

            @Override
            public boolean hasNext() {
                return cursor < size;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return elementAt(cursor++);
            }
        };
    }

    private void ensureCapacity(int required) {
        if (required <= elements.length) {
            return;
        }
        int newCapacity = Math.max(required, elements.length + (elements.length >> 1) + 1);
        elements = Arrays.copyOf(elements, newCapacity);
    }

    private void checkElementIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", size: " + size);
        }
    }

    private void checkPositionIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", size: " + size);
        }
    }

    @SuppressWarnings("unchecked")
    private E elementAt(int index) {
        return (E) elements[index];
    }
}
