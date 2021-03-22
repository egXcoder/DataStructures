package com.company.test;

import com.company.ds.LinkedList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {

    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @Test
    void addFirstOnEmptyLinkedList() {
        LinkedList<String> l = new LinkedList<String>();
        l.addFirst("test");
        assertEquals(l.getCurrentSize(),1);
    }

    @Test
    void addFirstOnSingleElementLinkedList() {
        LinkedList<String> l = new LinkedList<String>();
        l.addFirst("test");
        l.addFirst("test2");
        assertEquals(l.getCurrentSize(),2);
    }

    @Test
    void addFirstOnManyElementsLinkedList() {
        LinkedList<String> l = new LinkedList<String>();
        l.addFirst("test");
        l.addFirst("test2");
        l.addFirst("test3");
        assertEquals(l.getCurrentSize(),3);
    }

    @Test
    void addLastOnEmptyLinkedList() {
        LinkedList<String> l = new LinkedList<String>();
        l.addLast("test");
        assertEquals(l.getCurrentSize(),1);
    }

    @Test
    void addLastOnSingleLinkedList() {
        LinkedList<String> l = new LinkedList<String>();
        l.addLast("test");
        l.addLast("test2");
        assertEquals(l.getCurrentSize(),2);
    }

    @Test
    void addLastOnManyLinkedList() {
        LinkedList<String> l = new LinkedList<String>();
        l.addLast("test");
        l.addLast("test2");
        l.addLast("test3");
        assertEquals(l.getCurrentSize(),3);
    }

    @Test
    void removeFirstOnEmptyLinkedList() {
        LinkedList<String> l = new LinkedList<String>();
        assertNull(l.removeFirst());
    }

    @Test
    void removeFirstOnSingleLinkedList() {
        LinkedList<String> l = new LinkedList<String>();
        l.addFirst("test");
        assertEquals(l.removeFirst(),"test");
    }

    @Test
    void removeFirstOnManyLinkedList() {
        LinkedList<String> l = new LinkedList<String>();
        l.addFirst("test");
        l.addFirst("test2");
        assertEquals(l.removeFirst(),"test2");
    }

    @org.junit.jupiter.api.Test
    void removeLast() {
        LinkedList<Double> l = new LinkedList<Double>();
        for (int i=0;i<100;i++){
            l.addFirst(Math.random());
        }
        l.removeLast();
        assertEquals(l.getCurrentSize(),99);
    }

    @Test
    void removeObjectWhichExistOnFirst() {
        LinkedList<String> l = new LinkedList<String>();
        l.addLast("test");
        l.addLast("test2");
        l.addLast("test3");
        assertTrue(l.remove("test"));
    }

    @Test
    void removeObjectWhichExistOnLast() {
        LinkedList<String> l = new LinkedList<String>();
        l.addLast("test");
        l.addLast("test2");
        l.addLast("test3");
        assertTrue(l.remove("test3"));
    }

    @Test
    void removeObjectWhichExistOnMiddle() {
        LinkedList<String> l = new LinkedList<String>();
        l.addLast("test");
        l.addLast("test2");
        l.addLast("test3");
        assertTrue(l.remove("test2"));
    }

    @Test
    void removeObjectWithNoMatchesInLinkedlist() {
        LinkedList<String> l = new LinkedList<String>();
        l.addLast("test");
        l.addLast("test2");
        l.addLast("test3");
        assertFalse(l.remove("test4"));
    }

    @Test
    void removeObjectFromEmptyLinkedlist() {
        LinkedList<String> l = new LinkedList<String>();
        assertFalse(l.remove("test4"));
    }

    @Test
    void peekFirst() {
        LinkedList<String> l = new LinkedList<String>();
        l.addLast("test");
        l.addLast("test2");
        l.addLast("test3");
        assertEquals(l.peekFirst(),"test");
    }

    @Test
    void peekFirstOnEmptyLinkedList() {
        LinkedList<String> l = new LinkedList<String>();
        assertNull(l.peekFirst());
    }


    @Test
    void peekLast() {
        LinkedList<String> l = new LinkedList<String>();
        l.addLast("test");
        l.addLast("test2");
        l.addLast("test3");
        assertEquals(l.peekLast(),"test3");
    }

    @Test
    void peekLastOnEmptyLinkedList() {
        LinkedList<String> l = new LinkedList<String>();
        assertNull(l.peekLast());
    }

    @Test
    void iterateOverLinkedList() {
        LinkedList<String> l = new LinkedList<String>();
        l.addLast("test1");
        l.addLast("test2");
        l.addLast("test3");
        l.addLast("test4");
        int counter=0;
        for(Object E:l){
            counter++;
        }
        assertEquals(4,counter);
    }

    @Test
    void isEmpty(){
        LinkedList<String> l = new LinkedList<String>();
        assertTrue(l.isEmpty());
    }

    @Test
    void isNotEmpty(){
        LinkedList<String> l = new LinkedList<String>();
        l.addFirst("hello");
        assertFalse(l.isEmpty());
    }
}