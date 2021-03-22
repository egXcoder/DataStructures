package com.company.test;

import com.company.ds.ArrayQueue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArrayQueueTest {
    @Test
    public void checkEnqueue(){
        ArrayQueue q = new ArrayQueue(10);
        try {
            for(int i=0;i<100;i++){
                q.enqueue(i);
            }

        }catch (Exception ex){

        }

        assertEquals(q.getCount(),100);
    }

    @Test
    public void checkDequeue(){
        ArrayQueue<Integer> q = new ArrayQueue(10);
        q.enqueue(11);
        q.enqueue(22);
        q.enqueue(33);
        int data =0;
        try {

            data = q.dequeue();
        }catch (Exception ex){

        }

        assertEquals(11,data);
    }
}
