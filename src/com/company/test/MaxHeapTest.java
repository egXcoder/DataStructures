package com.company.test;

import com.company.ds.MaxHeap;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MaxHeapTest {
    MaxHeap<Integer> mx;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        mx = new MaxHeap<Integer>(8);
        mx.add(2);
        mx.add(3);
        mx.add(21);
        mx.add(4);
        mx.add(1);
        mx.add(3);
        mx.add(9);
        mx.add(13);
    }

    @Test
    public void checkElementCounter(){
        assertEquals(mx.getSize(),8);
    }

    @Test
    public void checkFullHeapException(){
        assertThrows(Exception.class,()->{
            mx.add(213);
        });
    }

    @Test
    public void pollTheRoot(){
       assertEquals(21,mx.poll());
       assertEquals(13,mx.poll());
       assertEquals(9,mx.poll());
       assertEquals(4,mx.poll());
    }
}
