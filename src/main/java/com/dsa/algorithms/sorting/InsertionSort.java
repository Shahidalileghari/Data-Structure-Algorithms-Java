package com.dsa.algorithms.sorting;

/** In-place insertion sort for ascending integer arrays. */
public final class InsertionSort {
    private InsertionSort() {}

    /** O(n^2) worst case, O(n) best case; O(1) extra space. */
    public static void sort(int[] values) {
        for (int i = 1; i < values.length; i++) {
            int current = values[i];
            int j = i - 1;
            while (j >= 0 && values[j] > current) {
                values[j + 1] = values[j];
                j--;
            }
            values[j + 1] = current;
        }
    }
}
