package com.company.test;

import com.company.ds.ArrayQueue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayQueueTest {
    @Test
    public void checkEnqueue(){
        ArrayQueue<Integer> q = new ArrayQueue<Integer>(10);
        for(int i=0;i<100;i++){
            q.enqueue(i);
        }

        assertEquals(q.getCount(),100);
    }

    @Test
    public void checkDequeue(){
        ArrayQueue<Integer> q = new ArrayQueue<Integer>(10);
        q.enqueue(11);
        q.enqueue(22);
        q.enqueue(33);
        assertEquals(11,q.dequeue());
        assertEquals(22,q.dequeue());
        assertEquals(33,q.dequeue());
    }

    @Test
    public void isEmpty(){
        ArrayQueue<Integer> q = new ArrayQueue<Integer>(10);
        assertTrue(q.isEmpty());
    }

    @Test
    public void isNotEmpty(){
        ArrayQueue<Integer> q = new ArrayQueue<Integer>(10);
        q.enqueue(2);
        assertFalse(q.isEmpty());
    }

    @Test
    public void isEmptyAfterOperation(){
        ArrayQueue<Integer> q = new ArrayQueue<Integer>(10);
        q.enqueue(22);
        q.dequeue();
        assertTrue(q.isEmpty());
    }

    @Test
    public void isFull(){
        ArrayQueue<Integer> q = new ArrayQueue<Integer>(2);
        q.enqueue(1);
        q.enqueue(2);
        assertTrue(q.isFull());
    }

    @Test
    public void isNotFull(){
        ArrayQueue<Integer> q = new ArrayQueue<Integer>(2);
        q.enqueue(1);
        q.enqueue(2);
        q.dequeue();
        assertFalse(q.isFull());
    }
}
