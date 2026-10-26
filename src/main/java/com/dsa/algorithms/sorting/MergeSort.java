package com.dsa.algorithms.sorting;

/** Stable merge sort for ascending integer arrays. */
public final class MergeSort {
    private MergeSort() {}

    /** O(n log n) time and O(n) auxiliary space. Mutates the input array. */
    public static void sort(int[] values) {
        if (values.length < 2) return;
        int[] buffer = new int[values.length];
        sort(values, buffer, 0, values.length - 1);
    }

    private static void sort(int[] values, int[] buffer, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        sort(values, buffer, left, mid);
        sort(values, buffer, mid + 1, right);
        if (values[mid] <= values[mid + 1]) return;
        merge(values, buffer, left, mid, right);
    }

    private static void merge(int[] values, int[] buffer, int left, int mid, int right) {
        System.arraycopy(values, left, buffer, left, right - left + 1);
        int i = left, j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i > mid) values[k] = buffer[j++];
            else if (j > right) values[k] = buffer[i++];
            else if (buffer[i] <= buffer[j]) values[k] = buffer[i++];
            else values[k] = buffer[j++];
        }
    }
}
