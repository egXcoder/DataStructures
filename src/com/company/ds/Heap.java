package com.company.ds;

import java.util.Comparator;

/**
 * It’s a type of tree, in which we are always have the
 * - ability to reach the maximum value of all the elements with O(1) complexity .. MAX HEAP
 * - ability to reach the minimum value of all elements with O(1) complexity .. Min Heap
 *
 * add to a tree is O(logn)
 * poll from a tree is O(logn)
 *
 * if given comparator it will use it to sort the elements, if not given, Heap will use the default
 * elements comparator method
 */
public class Heap<E extends Comparable<E>> {
    private final E[] hArray;
    private int nextPosition;
    private int numberOfElementsInHeap;
    private static final int DEFAULT_Capacity = 11;
    private Comparator<E> comparator;

    public Heap(){
        this(DEFAULT_Capacity);
    }

    public Heap(int size, Comparator<E> comparator) {
        this(size);
        this.comparator = comparator;
    }

    public Heap(int size){
        if(size<=1){
            throw new IllegalArgumentException("size must be greater than 1");
        }

        numberOfElementsInHeap = 0;
        nextPosition = 0;
        hArray = (E[]) new Comparable[size];
    }

    public void add(E element){
        if(nextPosition>=hArray.length){
            throw new RuntimeException("Heap is full");
        }

        hArray[nextPosition] = element;
        trickleUp(nextPosition);
        nextPosition++;
        numberOfElementsInHeap++;
    }

    private void trickleUp(int childIndex){
        if(isRoot(childIndex)){
            return;
        }

        int parentIndex =  (childIndex-1)/2;
        if(compareTwoElements(childIndex,parentIndex) < 0){
            swap(childIndex,parentIndex);
            trickleUp(parentIndex);
        }
    }

    private int compareTwoElements(int firstIndex,int secondIndex){
        if(comparator==null){
            return hArray[firstIndex].compareTo(hArray[secondIndex]);
        }else{
            return comparator.compare(hArray[firstIndex],hArray[secondIndex]);
        }
    }

    private boolean isRoot(int index){
        return index==0;
    }

    public E poll(){
        if(numberOfElementsInHeap == 0){
            throw new RuntimeException("Heap is empty");
        }

        E rootElement = hArray[0];
        hArray[0] = null;
        swap(--nextPosition,0);
        trickleDown(0);
        numberOfElementsInHeap--;
        return rootElement;
    }

    private void trickleDown(int parentIndex){
        int leftIndex = 2*parentIndex+1;
        int rightIndex = 2*parentIndex+2;

        if(isParentHaveOnlyLeftChild(parentIndex)){
            if(compareTwoElements(parentIndex,leftIndex)>0){
                swap(parentIndex,leftIndex);
            }
            return;
        }

        if(isParentDontHaveAnyChildren(parentIndex)){
            return;
        }

        if(compareLeftAndRightChildren(parentIndex)<0){
            swap(parentIndex,leftIndex);
            trickleDown(leftIndex);
        }else{
            swap(parentIndex,rightIndex);
            trickleDown(rightIndex);
        }
    }

    private boolean isParentHaveOnlyLeftChild(int parentIndex){
        int rightIndex = 2*parentIndex+2;
        return rightIndex==nextPosition;
    }

    private boolean isParentDontHaveAnyChildren(int parentIndex){
        int leftIndex = 2*parentIndex+1;
        return leftIndex>=nextPosition;
    }

    private int compareLeftAndRightChildren(int parentIndex){
        if(isParentDontHaveAnyChildren(parentIndex)){
            throw new RuntimeException("Parent Index Dont have any children");
        }

        int leftIndex = 2*parentIndex+1;
        int rightIndex = 2*parentIndex+2;
        return compareTwoElements(leftIndex,rightIndex);
    }

    public int getSize(){
        return numberOfElementsInHeap;
    }

    private void swap(int firstIndex,int secondIndex){
        E firstElement = hArray[firstIndex];
        hArray[firstIndex] = hArray[secondIndex];
        hArray[secondIndex] = firstElement;
    }

    public E peek(){
        if(numberOfElementsInHeap==0){
            throw new RuntimeException("Heap is empty");
        }

        return hArray[0];
    }
}
