package com.dsa.datastructures.linked;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedListTest {
    @Test void insertsSearchesAndRemoves() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addLast(1);
        list.addLast(3);
        list.insert(1, 2);
        assertEquals(2, list.get(1));
        assertTrue(list.contains(3));
        assertEquals(2, list.removeAt(1));
        assertEquals(1, list.removeFirst());
        assertEquals(1, list.size());
    }
}
