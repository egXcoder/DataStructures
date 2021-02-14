package com.company.test;

import com.company.ds.QueueCircularArray;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QueueCircularArrayTest {
    @Test
    public void checkEnqueue(){
        QueueCircularArray q = new QueueCircularArray(10);
        try {
            q.enqueue(10);
        }catch (Exception ex){

        }

        assertEquals(q.getUsedSize(),1);
    }

    @Test
    public void checkEnqueueOnFullList(){
        QueueCircularArray q = new QueueCircularArray(2);
        try {
            q.enqueue(10);
        }catch (Exception ex){
            System.out.println("hello");
        }

        assertThrows(Exception.class,()->{
            q.enqueue(22);
        });

        assertEquals(q.getUsedSize(),1);
    }

    @Test
    public void checkDequeue(){
        QueueCircularArray<Integer> q = new QueueCircularArray(10);
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
        QueueCircularArray q = new QueueCircularArray(2);

        assertThrows(Exception.class,()->{
            q.dequeue();
        });
    }
}
