package com.company.ds;

import com.company.ds.Contracts.Queue;

public class ArrayQueue<E> implements Queue<E> {
    private Object[] array;
    private int read=-1,write=-1;
    private int count = 0;
    private static final int DEFAULT_INITIAL_SIZE = 12;

    public ArrayQueue(){
        this(DEFAULT_INITIAL_SIZE);
    }

    public ArrayQueue(int size){
        if(size<1){
            throw new IllegalArgumentException();
        }
        array = new Object[size];
    }

    public void enqueue(E elem){
        if(isFull()){
            Object[] scaledArray = new Object[count*2];
            System.arraycopy(array,0,scaledArray,0,count);
            this.array = scaledArray;
        }

        if(read==-1){
            read = 0;
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

    public int getSize(){
        return count;
    }

    @Override
    public void add(E element) {
        enqueue(element);
    }

    @Override
    public E poll() {
        return dequeue();
    }

    @Override
    public E peek() {
        if(isEmpty()){
            throw new RuntimeException("can't peek from empty queue");
        }
        return (E) array[read];
    }
}
