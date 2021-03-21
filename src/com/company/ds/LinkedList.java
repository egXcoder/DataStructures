package com.company.ds;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E extends Comparable<E>> implements Iterable<E> {
    private static class Node<E>{
        E data;
        Node<E> next;

        public Node(E data) {
            this.data=data;
            next=null;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int currentSize;

    public LinkedList(){
        head=null;
        tail=null;
        currentSize=0;
    }

    /**
     * Adding to the beginning of linkedlist , O(1) Operation
     * @param obj
     */
    public void addFirst(E obj){
        Node<E> node = new Node<E>(obj);

        if(isEmpty()){
            addNodeToEmptyLinkedList(node);
            return;
        }

        addNodeToFirstPosition(node);
    }

    public boolean isEmpty(){
        return getCurrentSize() == 0;
    }

    private void addNodeToEmptyLinkedList(Node<E> node){
        if(!isEmpty()){
            throw new RuntimeException("LinkedList is not empty");
        }

        head=tail=node;
        currentSize++;
    }

    private void addNodeToFirstPosition(Node<E> node){
        node.next = head;
        head=node;
        currentSize++;
    }

    /**
     * Adding to the end of linkedlist, O(1) operation
     * @param obj
     */
    public void addLast(E obj){
        Node<E> node = new Node<E>(obj);

        if(isEmpty()){
            addNodeToEmptyLinkedList(node);
            return;
        }

        addNodeToLastPosition(node);
    }

    private void addNodeToLastPosition(Node<E> node){
        tail.next=node;
        tail=node;
        currentSize++;
    }

    /**
     * Removing from the beginning of linkedlist, O(1) operation
     * @return
     */
    public E removeFirst(){
        //empty linkedlist
        if(head==null){
            return null;
        }

        E tmp = head.data;

        if(head==tail){
            //only single Element exist
            head = tail = null;
        }else {
            //multiple elements exist
            head = head.next;
        }

        currentSize--;
        return tmp;
    }

    /**
     * remove From The end of linkedlist, O(N) operation as this linkedlist is implementation of single L.L
     * Doubley L.L will have in each node, next, prev pointers which can take more memory but its going to improve this operation
     * @return
     */
    public E removeLast(){
        //empty linkedlist
        if(head==null){
            return null;
        }

        //single linkedlist
        if(head == tail){
            E lastData = head.data;
            head=tail=null;
            currentSize--;
            return lastData;
        }

        Node<E> tmp1 = head;
        Node<E> tmp2 = head.next;
        while(tmp2!=tail){
            tmp1 = tmp1.next;
            tmp2 = tmp2.next;
        }

        //reaching here means tmp1==index of(tail-1) , tmp2 = tail
        E lastData = tmp2.data;
        tmp1.next=null;
        tail=tmp1;
        currentSize--;
        return lastData;
    }

    /**
     * remove object from linkedlist,O(n) operation as it has to search first
     * @param obj
     * @return E
     */
    public E remove(E obj){
        if(head==null){
            return null;
        }

        Node<E> tmp1 = null;
        Node<E> tmp2 = head;
        while (tmp1!=tail){
            //we are still looping through the linkedlist
            if(((Comparable<E>) obj).compareTo(tmp2.data) == 0){
                //we found a match
                if(tmp2==head){
                    return removeFirst();
                }
                if(tmp2==tail){
                    return removeLast();
                }
                E foundMatch = tmp2.data;
                tmp1.next = tmp2.next;
                currentSize--;
                return foundMatch;
            }
            tmp1=tmp2;
            tmp2=tmp2.next;
        }

        //if we reached here, this will mean we couldn't find a match
        return null;
    }

    /**
     * return the first element on linkedlist, without removing,O(1) operation
     * @return
     */
    public E peekFirst(){
        if(head==null){
            return null;
        }
        return head.data;
    }

    /**
     * return the last element on linkedlist,without removing , O(1) operation
     * @return
     */
    public E peekLast(){
        if(tail==null){
            return null;
        }
        return tail.data;
    }

    public E find(E data){
        for(E el:this){
            if(((Comparable<E>) el).compareTo(data) == 0){
                return el;
            }
        }
        return null;
    }

    /**
     * get current size of linkedlist
     * @return
     */
    public int getCurrentSize(){
        return currentSize;
    }

    @Override
    public Iterator<E> iterator() {
        return new IteratorHelper<E>();
    }

    private class IteratorHelper<T> implements Iterator<T>{
        private Node<E> node;

        public IteratorHelper(){
            node = head;
        }

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E data = node.data;
            node = node.next;
            return (T) data;
        }
    }

}
