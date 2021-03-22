package com.company.ds;

public class ArrayQueue<E> {
    private Object[] array;
    private int read=-1,write=-1;
    private int count = 0;

    public ArrayQueue(int size){
        if(size<1){
            throw new IllegalArgumentException();
        }
        array = new Object[size];
    }

    public void enqueue(E elem) throws Exception{
        if(isFull()){
            Object[] scaledArray = new Object[count*2];
            System.arraycopy(array,0,scaledArray,0,count);
            this.array = scaledArray;
        }

        write = (write+1) % array.length;
        array[write] = elem;
        count++;
    }

    public E dequeue(){
        if(isEmpty()){
            throw new RuntimeException("Queue is empty");
        }

        E data = (E) array[read];

        if(read == write){
            read = write = -1;
            count--;
            return data;
        }

        read=(read+1) % array.length;
        count--;
        return data;
    }

    public boolean isEmpty(){
        return read == -1 && write == -1;
    }

    public  boolean isFull(){
        return read == (write+1) % array.length;
    }

    public int getCount(){
        return count;
    }
}
