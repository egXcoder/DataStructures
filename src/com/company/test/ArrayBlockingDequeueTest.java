package com.company.test;

import com.company.ds.ArrayBlockingDequeue;
import com.company.ds.ArrayBlockingQueue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArrayBlockingDequeueTest {
    @Test
    public void checkAddFirstRemoveFirst(){
        ArrayBlockingDequeue<Integer> d = new ArrayBlockingDequeue<Integer>(10);
        try {
            d.addFirst(11);
            d.addFirst(22);
        }catch (Exception ex){

        }

        assertEquals(d.getCount(),2);

        try {
            int data = d.removeFirst();
            assertEquals(data,22);

            int data2 = d.removeFirst();
            assertEquals(data2,11);
        }catch (Exception ex){

        }

        //it should throw empty dequeue exception
        assertThrows(Exception.class, d::removeFirst);
    }

    @Test
    public void checkAddLastRemoveLast(){
        ArrayBlockingDequeue<Integer> d = new ArrayBlockingDequeue<Integer>(10);
        try {
            d.addLast(11);
            d.addLast(22);
        }catch (Exception ex){

        }

        assertEquals(d.getCount(),2);

        try {
            int data = d.removeLast();
            assertEquals(data,22);

            int data2 = d.removeLast();
            assertEquals(data2,11);
        }catch (Exception ex){

        }

        //it should throw empty dequeue exception
        assertThrows(Exception.class, d::removeLast);
    }
}
