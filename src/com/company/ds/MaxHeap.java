package com.company.ds;

/**
 * It’s a type of tree, in which we are always have the
 * - ability to reach the maximum value of all the elements with O(1) complexity .. MAX HEAP
 * - ability to reach the minimum value of all elements with O(1) complexity .. Min Heap
 *
 * add to a tree is O(logn)
 * poll from a tree is O(logn) , its always going to remove the maximum priority and resort the heap
 * Heap sort operation is to get all elements sorted O(nlog(n))
 * @param <E>
 */
public class MaxHeap<E extends Comparable<E>> {
    private E[] hArray;
    private int nextPosition;
    private int numberOfElementsInHeap;
    private static final int DEFAULT_Capacity = 11;

    public MaxHeap(){
        this(DEFAULT_Capacity);
    }

    public MaxHeap(int size){
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
        if((hArray[childIndex]).compareTo(hArray[parentIndex]) > 0){
            swap(childIndex,parentIndex);
            trickleUp(parentIndex);
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
            if(hArray[parentIndex].compareTo(hArray[leftIndex])<0){
                swap(parentIndex,leftIndex);
                return;
            }
        }

        if(isParentDontHaveAnyChildren(parentIndex)){
            return;
        }

        if(isLeftChildBiggerThanRightChild(parentIndex)){
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

    private boolean isLeftChildBiggerThanRightChild(int parentIndex){
        if(isParentDontHaveAnyChildren(parentIndex)){
            throw new RuntimeException("Parent Index Dont have any children");
        }

        int leftIndex = 2*parentIndex+1;
        int rightIndex = 2*parentIndex+2;
        return (hArray[leftIndex].compareTo(hArray[rightIndex])>0);
    }

    public int getSize(){
        return numberOfElementsInHeap;
    }

    private void swap(int firstIndex,int secondIndex){
        E firstElement = hArray[firstIndex];
        hArray[firstIndex] = hArray[secondIndex];
        hArray[secondIndex] = firstElement;
    }
}
