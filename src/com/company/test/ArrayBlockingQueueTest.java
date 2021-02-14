package com.company.test;

import com.company.ds.ArrayBlockingQueue;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayBlockingQueueTest {
    @Test
    public void checkEnqueue(){
        ArrayBlockingQueue q = new ArrayBlockingQueue(10);
        try {
            q.enqueue(10);
        }catch (Exception ex){

        }

        assertEquals(q.getCount(),1);
    }

    @Test
    public void checkEnqueueOnFullList(){
        ArrayBlockingQueue q = new ArrayBlockingQueue(2);
        try {
            q.enqueue(10);
        }catch (Exception ex){
            System.out.println("hello");
        }

        assertThrows(Exception.class,()->{
            q.enqueue(22);
        });

        assertEquals(q.getCount(),1);
    }

    @Test
    public void checkDequeue(){
        ArrayBlockingQueue<Integer> q = new ArrayBlockingQueue(10);
        int data =0;
        try {
            q.enqueue(1);
            q.enqueue(2);
            q.enqueue(3);
            data = q.dequeue();
        }catch (Exception ex){
            System.out.println("hello");
        }

        assertEquals(data,1);
    }

    @Test
    public void checkDequeueOnEmptyList(){
        ArrayBlockingQueue q = new ArrayBlockingQueue(2);

        assertThrows(Exception.class,()->{
            q.dequeue();
        });
    }
}
