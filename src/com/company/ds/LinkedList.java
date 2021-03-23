package com.company.ds;

import com.company.ds.Contracts.List;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E extends Comparable<E>> implements List<E> {
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

    public void add(E obj){
        addLast(obj);
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
        return getSize() == 0;
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
        if(isEmpty()){
            return null;
        }

        E tmp = head.data;

        if(isOnlySingleElementExist()){
            head = tail = null;
        }else {
            head = head.next;
        }

        currentSize--;
        return tmp;
    }

    private boolean isOnlySingleElementExist(){
        return getSize() == 1;
    }

    /**
     * remove From The end of linkedlist, O(N) operation as this linkedlist is implementation of single L.L
     * Doubley L.L will have in each node, next, prev pointers which can take more memory but its going to improve this operation
     * @return
     */
    public E removeLast(){
        if(isEmpty()){
            return null;
        }

        if(isOnlySingleElementExist()){
            return removeFirst();
        }

        Node<E> tmp1 = head;
        Node<E> tmp2 = head.next;
        while(tmp2!=tail){
            tmp1 = tmp1.next;
            tmp2 = tmp2.next;
        }

        //reaching here means
        //tmp1==index of(tail-1)
        //tmp2 = tail
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
    public boolean remove(E obj){
        if(isEmpty()){
            return false;
        }

        if(obj.compareTo(head.data) == 0){
            removeFirst();
            return true;
        }

        Node<E> tmp1 = head;
        Node<E> tmp2 = head.next;
        while(tmp2!=null){
            if((obj).compareTo(tmp2.data) == 0){
                //we found a match
                E foundMatch = tmp2.data;
                tmp1.next = tmp2.next;
                currentSize--;
                return true;
            }
            tmp1=tmp1.next;
            tmp2=tmp2.next;
        }

        return false;
    }

    /**
     * return the first element on linkedlist, without removing,O(1) operation
     * @return
     */
    public E peekFirst(){
        if(isEmpty()){
            return null;
        }
        return head.data;
    }

    /**
     * return the last element on linkedlist,without removing , O(1) operation
     * @return
     */
    public E peekLast(){
        if(isEmpty()){
            return null;
        }
        return tail.data;
    }

    public boolean contains(E data){
        for(E el:this){
            if(el.compareTo(data) == 0){
                return true;
            }
        }
        return false;
    }

    public int getSize(){
        return currentSize;
    }

    @Override
    public Iterator<E> iterator() {
        return new DataIterator<E>();
    }

    private class DataIterator<T> implements Iterator<T>{
        private Node<E> node;

        public DataIterator(){
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
