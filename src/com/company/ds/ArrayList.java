package com.company.ds;

import com.company.ds.Contracts.List;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayList<E extends Comparable<E>> implements List<E> {
    private E[] array;
    private int currentSize;

    public ArrayList(int size){
        this.array = (E[]) new Comparable[size];
        this.currentSize=0;
    }

    @Override
    public void add(E element) {
        if(isFull()){
            array = Arrays.copyOf(array,array.length*2);
        }
        array[currentSize++] = element;
    }

    private boolean isFull(){
        return currentSize==array.length;
    }

    @Override
    public boolean remove(E element) {
        if(isEmpty()){
            return false;
        }

        if(getSize()==1){
            if(array[0].compareTo(element)==0){
                array = (E[]) new Comparable[array.length];
                currentSize=0;
                return true;
            }

            return false;
        }

        for(int i=0;i<currentSize;i++){
            if(element.compareTo(array[i])==0){
                E[] newArray = (E[]) new Comparable[array.length];
                for(int j=0;j<currentSize-1;j++){
                    if(j<i){
                        newArray[j] = array[j];
                    }
                    if(j>=i){
                        newArray[j] = array[j+1];
                    }
                }
                array = newArray;
                currentSize--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(E element) {
        for(int i=0;i<array.length;i++) {
            if (element.compareTo(array[i]) == 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public E get(int index){
        if(index<0){
            throw new RuntimeException("Index is not valid");
        }
        if(index>=getSize()){
            throw new RuntimeException("Index is out of bound exception");
        }
        return array[index];
    }

    @Override
    public int getSize() {
        return currentSize;
    }

    @Override
    public boolean isEmpty() {
        return currentSize==0;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayListIterator<E>();
    }

    public class ArrayListIterator<T> implements Iterator<T>{
        private final E[] iteratorArray;
        private final int pointer = 0;
        public ArrayListIterator(){
            iteratorArray = array;
        }

        @Override
        public boolean hasNext() {
            return pointer<iteratorArray.length;
        }

        @Override
        public T next() {
            return (T) iteratorArray[pointer];
        }
    }
}
