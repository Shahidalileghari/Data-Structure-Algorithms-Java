package com.dsa.algorithms.sorting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SortingTest {
    @Test void insertionSortHandlesTypicalCases() {
        int[] values = {5, -1, 3, 3, 0};
        InsertionSort.sort(values);
        assertArrayEquals(new int[]{-1, 0, 3, 3, 5}, values);
    }

    @Test void mergeSortHandlesEmptyAndDuplicates() {
        int[] values = {8, 2, 5, 2, -3};
        MergeSort.sort(values);
        assertArrayEquals(new int[]{-3, 2, 2, 5, 8}, values);
        int[] empty = {};
        MergeSort.sort(empty);
        assertArrayEquals(new int[]{}, empty);
    }
}
