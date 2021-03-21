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
        LinkedList l = new LinkedList();
        l.addFirst("test");
        assertEquals(l.getCurrentSize(),1);
        assertEquals(l.peekFirst(),"test");
    }

    @Test
    void addFirstOnSingleElementLinkedList() {
        LinkedList l = new LinkedList();
        l.addFirst("test");
        l.addFirst("test2");
        assertEquals(l.getCurrentSize(),2);
        assertEquals(l.peekFirst(),"test2");
    }

    @Test
    void addFirstOnManyElementsLinkedList() {
        LinkedList l = new LinkedList();
        l.addFirst("test");
        l.addFirst("test2");
        l.addFirst("test3");
        assertEquals(l.getCurrentSize(),3);
        assertEquals(l.peekFirst(),"test3");
    }

    @Test
    void addLastOnEmptyLinkedList() {
        LinkedList l = new LinkedList();
        l.addLast("test");
        assertEquals(l.getCurrentSize(),1);
        assertEquals(l.peekLast(),"test");
    }

    @Test
    void addLastOnSingleLinkedList() {
        LinkedList l = new LinkedList();
        l.addLast("test");
        l.addLast("test2");
        assertEquals(l.getCurrentSize(),2);
        assertEquals(l.peekLast(),"test2");
    }

    @Test
    void addLastOnManyLinkedList() {
        LinkedList l = new LinkedList();
        l.addLast("test");
        l.addLast("test2");
        l.addLast("test3");
        assertEquals(l.getCurrentSize(),3);
        assertEquals(l.peekLast(),"test3");
    }

    @Test
    void removeFirstOnEmptyLinkedList() {
        LinkedList l = new LinkedList();
        assertNull(l.removeFirst());
    }

    @Test
    void removeFirstOnSingleLinkedList() {
        LinkedList l = new LinkedList();
        l.addFirst("test");
        assertEquals(l.removeFirst(),"test");
        assertEquals(l.getCurrentSize(),0);
    }

    @Test
    void removeFirstOnManyLinkedList() {
        LinkedList l = new LinkedList();
        l.addFirst("test");
        l.addFirst("test2");
        assertEquals(l.removeFirst(),"test2");
        assertEquals(l.getCurrentSize(),1);
    }

    @org.junit.jupiter.api.Test
    void removeLast() {
        LinkedList l = new LinkedList();
        for (int i=0;i<100;i++){
            l.addFirst(Math.random());
        }
        l.removeLast();
        assertEquals(l.getCurrentSize(),99);
    }

    @Test
    void removeObjectWhichExistOnFirst() {
        LinkedList l = new LinkedList();
        l.addLast("test");
        l.addLast("test2");
        l.addLast("test3");
        assertEquals("test",l.remove("test"));
    }

    @Test
    void removeObjectWhichExistOnLast() {
        LinkedList l = new LinkedList();
        l.addLast("test");
        l.addLast("test2");
        l.addLast("test3");
        assertEquals(l.remove("test3"),"test3");
    }

    @Test
    void removeObjectWhichExistOnMiddle() {
        LinkedList l = new LinkedList();
        l.addLast("test");
        l.addLast("test2");
        l.addLast("test3");
        assertEquals(l.remove("test2"),"test2");
    }

    @Test
    void removeObjectWithNoMatchesInLinkedlist() {
        LinkedList l = new LinkedList();
        l.addLast("test");
        l.addLast("test2");
        l.addLast("test3");
        assertNull(l.remove("test4"));
    }

    @Test
    void removeObjectFromEmptyLinkedlist() {
        LinkedList l = new LinkedList();
        assertNull(l.remove("test4"));
    }

    @Test
    void peekFirst() {
        LinkedList l = new LinkedList();
        l.addLast("test");
        l.addLast("test2");
        l.addLast("test3");
        assertEquals(l.peekFirst(),"test");
    }

    @Test
    void peekFirstOnEmptyLinkedList() {
        LinkedList l = new LinkedList();
        assertNull(l.peekFirst());
    }


    @Test
    void peekLast() {
        LinkedList l = new LinkedList();
        l.addLast("test");
        l.addLast("test2");
        l.addLast("test3");
        assertEquals(l.peekLast(),"test3");
    }

    @Test
    void peekLastOnEmptyLinkedList() {
        LinkedList l = new LinkedList();
        assertNull(l.peekLast());
    }

    @Test
    void iterateOverLinkedList() {
        LinkedList l = new LinkedList();
        l.addLast("test1");
        l.addLast("test2");
        l.addLast("test3");
        l.addLast("test4");
        int counter=0;
        for(Object E:l){
            counter++;
        }
        assertEquals(counter,3);
    }
}