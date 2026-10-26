package com.dsa.demo;

import com.dsa.datastructures.linear.DynamicArray;

/** Runnable example for DynamicArray. */
public final class DynamicArrayDemo {
    private DynamicArrayDemo() {}

    public static void main(String[] args) {
        DynamicArray<Integer> values = new DynamicArray<>();
        values.add(10);
        values.add(20);
        values.insert(1, 15);
        values.set(0, 5);

        System.out.println("Values:");
        for (Integer value : values) System.out.println(value);

        System.out.println("Contains 15: " + values.contains(15));
        System.out.println("Removed at index 1: " + values.removeAt(1));
        System.out.println("Size: " + values.size());
    }
}
