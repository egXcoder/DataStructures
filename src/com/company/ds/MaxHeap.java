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
    private int nextPosition;
    private E[] hArray;
    private int elementsCounter;

    public MaxHeap(int size){
        if(size<=1){
            throw new IllegalArgumentException("size must be greater than 1");
        }

        elementsCounter=0;
        nextPosition = 0;
        hArray = (E[]) new Comparable[size];
    }

    public void add(E element) throws Exception{
        if(nextPosition>=hArray.length){
            throw new Exception("Heap is full");
        }

        hArray[nextPosition] = element;
        trickleUp(nextPosition);
        nextPosition++;
        elementsCounter++;
    }

    private void trickleUp(int childIndex){
        if(childIndex==0){
            //we reached root
            return;
        }

        int parentIndex =  (childIndex-1)/2;
        if((hArray[childIndex]).compareTo(hArray[parentIndex]) > 0){
            swap(childIndex,parentIndex);
            trickleUp(parentIndex);
        }
    }

    public E poll() throws Exception{
        if(elementsCounter==0){
            throw new Exception("Heap is empty");
        }

        E rootElement = hArray[0];
        hArray[0] = null;
        swap(--nextPosition,0);
        trickleDown(0);
        elementsCounter--;
        return rootElement;
    }

    private void trickleDown(int parentIndex){
        int leftIndex = parentIndex*2+1;
        int rightIndex = parentIndex*2+2;

        // edge Cases:
        if(rightIndex==nextPosition){
            //parent doesn't have right child
            if(hArray[parentIndex].compareTo(hArray[leftIndex])<0){
                swap(parentIndex,leftIndex);
                return;
            }
        }

        if(leftIndex==nextPosition){
            //parent doesn't have left or right childs
            return;
        }

        // typical logic:
        int left_right_comparsion = hArray[leftIndex].compareTo(hArray[rightIndex]);
        int largetIndex=-1;
        if(left_right_comparsion>0){
            //left is bigger than right
            largetIndex=leftIndex;
        }else if(left_right_comparsion<0){
            largetIndex=rightIndex;
            //right is bigger than left
        }
        if(largetIndex!=-1){
            if(hArray[parentIndex].compareTo(hArray[largetIndex])<1){
                swap(parentIndex,largetIndex);
                trickleDown(largetIndex);
            }
        }
    }

    public int getCounter(){
        return elementsCounter;
    }

    private void swap(int firstIndex,int secondIndex){
        E firstElement = hArray[firstIndex];
        E secondElement = hArray[secondIndex];

        hArray[firstIndex] = secondElement;
        hArray[secondIndex] = firstElement;
    }
}
