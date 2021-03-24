package com.company.ds;

import java.util.ArrayDeque;

public class ArrayDequeue<E> {
    private Object[] array;
    private int read=-1,write=-1;
    private int count = 0;

    public ArrayDequeue(int size){
        if(size<1){
            throw new IllegalArgumentException();
        }
        array = new Object[size];
    }

    public void addLast(E elem){
        if(isFull()){
            throw new RuntimeException("Full Dequeue");
        }

        if(read == -1){
            read = 0;
        }

        write = (write+1) % array.length;
        array[write] = elem;
        count++;
    }

    public E removeLast(){
        if(isEmpty()){
            throw new RuntimeException("Dequeue is empty");
        }

        E data = (E) array[write];
        count--;

        if(read==write){
            read = write = -1;
        }else{
            if(write<=0){
                write = write + array.length;
            }
            write = (write-1) % array.length;
        }

        return data;
    }

    public void addFirst(E elem){
        if(isFull()){
            throw new RuntimeException("Full Dequeue");
        }

        if(read<=0){
            read= read + array.length;
        }

        read = read-1;
        array[read] = elem;
        count++;
    }

    public E removeFirst(){
        if(isEmpty()){
            throw new RuntimeException("Empty Dequeue");
        }

        E data = (E) array[read];

        if(read==write){
            read = write = -1;
        }else{
            read = read+1 % array.length;
        }

        count--;
        return data;
    }

    public boolean isEmpty(){
        return read==-1 && write==-1;
    }

    public boolean isFull(){
        return read == (write+1)%array.length;
    }

    public int getCount(){
        return count;
    }
}
