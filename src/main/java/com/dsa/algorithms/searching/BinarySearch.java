package com.dsa.algorithms.searching;

/** Binary search utilities for sorted arrays. */
public final class BinarySearch {
    private BinarySearch() {}

    /**
     * Returns the index of target in ascending sorted values, or -1.
     * O(log n) time and O(1) auxiliary space.
     */
    public static int indexOf(int[] values, int target) {
        int low = 0, high = values.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >>> 1);
            if (values[mid] == target) return mid;
            if (values[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
}
