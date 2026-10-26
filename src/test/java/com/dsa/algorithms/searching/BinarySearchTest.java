package com.dsa.algorithms.searching;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {
    @Test void findsAndMissesValues() {
        assertEquals(2, BinarySearch.indexOf(new int[]{1, 3, 5, 7}, 5));
        assertEquals(-1, BinarySearch.indexOf(new int[]{1, 3, 5, 7}, 4));
        assertEquals(-1, BinarySearch.indexOf(new int[]{}, 4));
    }
}
