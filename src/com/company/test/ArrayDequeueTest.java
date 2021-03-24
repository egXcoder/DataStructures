package com.company.test;

import com.company.ds.ArrayDequeue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayDequeueTest {
    @Test
    public void checkAddFirst(){
        ArrayDequeue<Integer> d = new ArrayDequeue<Integer>(10);
        d.addFirst(11);
        d.addFirst(22);
        assertEquals(d.getCount(),2);
    }

    @Test
    public void checkRemoveFirst() {
        ArrayDequeue<Integer> d = new ArrayDequeue<Integer>(10);
        d.addFirst(11);
        d.addFirst(22);

        assertEquals(22,d.removeFirst());
        assertEquals(11,d.removeFirst());
    }

    @Test
    public void addLast() {
        ArrayDequeue<Integer> d = new ArrayDequeue<Integer>(10);
        d.addLast(11);
        d.addLast(22);

        assertEquals(2,d.getCount());
    }

    @Test
    public void removeLast() {
        ArrayDequeue<Integer> d = new ArrayDequeue<Integer>(10);
        d.addLast(11);
        d.addLast(22);

        assertEquals(22,d.removeLast());
        assertEquals(11,d.removeLast());
    }

    @Test
    public void isEmpty(){
        ArrayDequeue<Integer> d = new ArrayDequeue<Integer>(10);
        assertTrue(d.isEmpty());
    }

    @Test
    public void isNotEmpty(){
        ArrayDequeue<Integer> d = new ArrayDequeue<Integer>(10);
        d.addLast(11);
        assertFalse(d.isEmpty());
    }

    @Test
    public void isFull(){
        ArrayDequeue<Integer> d = new ArrayDequeue<Integer>(1);
        d.addLast(11);
        assertTrue(d.isFull());
    }

    @Test
    public void isNotFull(){
        ArrayDequeue<Integer> d = new ArrayDequeue<Integer>(1);
        assertFalse(d.isFull());
    }
}
