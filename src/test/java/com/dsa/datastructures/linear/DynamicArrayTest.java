package com.dsa.datastructures.linear;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DynamicArrayTest {
    @Test void supportsAddInsertGetSetAndRemove() {
        DynamicArray<Integer> values = new DynamicArray<>(1);
        values.add(10);
        values.add(30);
        values.insert(1, 20);
        assertEquals(3, values.size());
        assertEquals(20, values.get(1));
        assertEquals(10, values.set(0, 5));
        assertEquals(30, values.removeAt(2));
        assertEquals(2, values.size());
    }

    @Test void supportsNullAndSearch() {
        DynamicArray<String> values = new DynamicArray<>();
        values.add(null);
        values.add("java");
        assertTrue(values.contains(null));
        assertEquals(1, values.indexOf("java"));
        assertTrue(values.remove(null));
        assertFalse(values.contains(null));
    }

    @Test void checksIndexes() {
        DynamicArray<Integer> values = new DynamicArray<>();
        assertThrows(IndexOutOfBoundsException.class, () -> values.get(0));
        assertThrows(IndexOutOfBoundsException.class, () -> values.insert(1, 1));
    }

    @Test void convertsToTypedArrayAndClears() {
        DynamicArray<String> values = new DynamicArray<>();
        values.add("A");
        values.add("B");
        assertArrayEquals(new String[]{"A", "B"}, values.toArray(String[]::new));
        values.clear();
        assertTrue(values.isEmpty());
    }
}
