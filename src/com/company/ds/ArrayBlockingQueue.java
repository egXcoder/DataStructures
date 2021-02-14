package com.company.ds;

public class ArrayBlockingQueue<E> {
    private Object[] array;
    private int read=0,write=0;
    private int count = 0;

    public ArrayBlockingQueue(int size){
        if(size<=1){
            throw new IllegalArgumentException();
        }
        array = new Object[size];
    }

    public void enqueue(E elem) throws Exception{
        if(read == (write+1)%array.length){
            throw new Exception("Queue is full");
        }

        array[write] = elem;
        write = (write+1) % array.length;
        count++;
    }

    public E dequeue() throws Exception{
        if(read == write){
            throw new Exception("Queue is empty");
        }

        E data = (E) array[read];
        read=(read+1) % array.length;
        count--;
        return data;
    }

    public int getCount(){
        return count;
    }

}
