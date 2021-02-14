package com.company.ds;

import java.util.ArrayDeque;

public class ArrayBlockingDequeue<E> {
    private Object[] array;
    private int front=0,rear=0;
    private int count = 0;

    public ArrayBlockingDequeue(int size){
        if(size<1){
            throw new IllegalArgumentException();
        }
        array = new Object[size+1];
    }

    public void addLast(E elem) throws Exception{
        if((rear+1)%array.length == front){
            throw new Exception("Full Dequeue");
        }
        rear = (rear+1)%array.length;
        array[rear] = elem;
        count++;
    }

    public E removeLast() throws Exception{
        if(rear == front){
            throw new Exception("Empty Dequeue");
        }

        Object data = array[rear];
        rear = (rear-1)%array.length;
        count--;
        return (E) data;
    }

    public void addFirst(E elem) throws Exception{
        //set the new front position
        int tmp = front-1;
        if(tmp<0){
            tmp = array.length-1;
        }

        if(tmp==rear){
            throw new Exception("Dequeue is full");
        }
        front = tmp;

        array[front] = elem;
        count++;
    }

    public E removeFirst() throws Exception{
        if(front==rear){
            throw new Exception("Empty Dequeue");
        }

        Object data = array[front];

        //set the new front position
        int tmp = front+1;
        if(tmp>array.length-1){
            tmp=0;
        }
        front=tmp;

        count--;

        return (E) data;
    }

    public int getCount(){
        return count;
    }
}
