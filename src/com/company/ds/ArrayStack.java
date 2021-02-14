package com.company.ds;

public class ArrayStack<E> {
    private Object[] array;
    private int pointerIndex = -1;

    public ArrayStack(int size){
        if(size<1){
            throw new IllegalArgumentException();
        }
        array = new Object[size];
    }

    public void push(E elem) throws Exception{
        if(pointerIndex + 1 == array.length){
            Object[] scaledArray = new Object[pointerIndex*2];
            System.arraycopy(array,0,scaledArray,0,pointerIndex);
            this.array = scaledArray;
        }

        array[++pointerIndex] = elem;
    }

    public E pop() throws Exception{
        if(pointerIndex == -1){
            throw new Exception("Stack is Empty");
        }

        Object data = array[pointerIndex--];
        return (E) data;

    }

    public int getCount(){
        return pointerIndex+1;
    }
}
