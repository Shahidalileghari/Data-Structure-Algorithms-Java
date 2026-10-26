package com.dsa.datastructures.stack;

import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;

class ArrayStackTest {
    @Test void followsLifoOrder() {
        ArrayStack<Integer> stack = new ArrayStack<>();
        stack.push(1); stack.push(2);
        assertEquals(2, stack.pop());
        assertEquals(1, stack.peek());
    }

    @Test void rejectsPopFromEmptyStack() {
        assertThrows(NoSuchElementException.class, () -> new ArrayStack<>().pop());
    }
}
