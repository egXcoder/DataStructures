package com.company.ds;

public class QueueCircularArray<E> {
    private Object[] array;
    private int read=0,write=0;
    private int usedSize = 0;

    public QueueCircularArray(int size){
        array = new Object[size];
    }

    public void enqueue(E elem) throws Exception{
        if(read == (write+1)%array.length){
            throw new Exception("Queue is full");
        }

        array[write] = elem;
        write = (write+1) % array.length;
        usedSize++;
    }

    public E dequeue() throws Exception{
        if(read == write){
            throw new Exception("Queue is empty");
        }

        E data = (E) array[read];
        read=(read+1) % array.length;
        usedSize--;
        return data;
    }

    public int getUsedSize(){
        return usedSize;
    }

}
