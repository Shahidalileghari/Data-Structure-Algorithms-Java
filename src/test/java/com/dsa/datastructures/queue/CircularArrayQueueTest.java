package com.dsa.datastructures.queue;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CircularArrayQueueTest {
    @Test void followsFifoOrderAndGrows() {
        CircularArrayQueue<Integer> queue = new CircularArrayQueue<>();
        for (int i = 0; i < 20; i++) queue.enqueue(i);
        for (int i = 0; i < 20; i++) assertEquals(i, queue.dequeue());
        assertTrue(queue.isEmpty());
    }
}
