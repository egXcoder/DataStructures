package com.company.test;

import com.company.ds.Heap;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

public class HeapTest {
    @Test
    public void checkElementCounter(){
        Heap<Integer> mx = new Heap<Integer>(8);
        mx.add(2);
        mx.add(3);
        mx.add(21);
        assertEquals(mx.getSize(),3);
    }

    @Test
    public void checkFullHeapException(){
        Heap<Integer> mx = new Heap<Integer>(2);
        mx.add(2);
        mx.add(3);
        assertThrows(Exception.class,()->{
            mx.add(213);
        });
    }

    @Test
    public void pollTheRootOfMaxHeap(){
        Heap<Integer> mx = new Heap<Integer>(8, Collections.reverseOrder());
        mx.add(2);
        mx.add(3);
        mx.add(21);
        mx.add(4);
        mx.add(1);
        mx.add(3);
        mx.add(9);
        mx.add(13);
       assertEquals(21,mx.poll());
       assertEquals(13,mx.poll());
       assertEquals(9,mx.poll());
       assertEquals(4,mx.poll());
    }

    @Test
    public void pollTheRootOfMinHeap(){
        Heap<Integer> mx = new Heap<Integer>(8);
        mx.add(2);
        mx.add(3);
        mx.add(21);
        mx.add(4);
        mx.add(1);
        mx.add(3);
        mx.add(9);
        mx.add(13);
        assertEquals(1,mx.poll());
        assertEquals(2,mx.poll());
        assertEquals(3,mx.poll());
        assertEquals(3,mx.poll());
    }

    @Test
    public void peekTheRootOfMinHeap(){
        Heap<Integer> mx = new Heap<Integer>(8);
        mx.add(2);
        mx.add(3);
        mx.add(21);
        mx.add(4);
        mx.add(1);
        mx.add(3);
        mx.add(9);
        mx.add(13);
        assertEquals(1,mx.peek());
    }

    @Test
    public void useCustomComperator() {
        Heap<Integer> mx = new Heap<Integer>(8, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        mx.add(5);
        mx.add(3);
        mx.add(11);
        mx.add(9);
        assertEquals(11,mx.poll());
        assertEquals(9,mx.poll());
        assertEquals(5,mx.poll());
    }
}
