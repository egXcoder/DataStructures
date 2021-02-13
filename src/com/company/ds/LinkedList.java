package com.company.ds;

public class LinkedList<E> {
    private class Node<E>{
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

        //if empty linkedlist
        if(head==null){
            head=tail=node;
            currentSize++;
            return;
        }

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

        //if empty linkedlist
        if(head==null){
            head=tail=node;
            currentSize++;
            return;
        }

        tail.next=node;
        tail=node;
        currentSize++;
    }
}
