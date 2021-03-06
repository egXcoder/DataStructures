package com.company.test;

import com.company.ds.ArrayList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {

    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }
    @Test
    void isEmpty(){
        ArrayList<String> al = new ArrayList<>(3);
        assertTrue(al.isEmpty());
    }

    @Test
    void isNotEmpty(){
        ArrayList<String> al = new ArrayList<String>(3);
        al.add("hello");
        assertFalse(al.isEmpty());
    }

    @Test
    void addToArrayList(){
        ArrayList<String> al = new ArrayList<String>(3);
        al.add("hello");
        assertEquals(1,al.getSize());
    }

    @Test
    void removeFromArrayList(){
        ArrayList<String> al = new ArrayList<String>(3);
        al.add("hello");
        assertTrue(al.remove("hello"));
    }

    @Test
    void getAtIndexOfEmptyAl(){
        ArrayList<String> al = new ArrayList<String>(3);
        assertThrows(RuntimeException.class,()->al.get(0));
    }

    @Test
    void getAtIndexWhenItsOutOfBound(){
        ArrayList<String> al = new ArrayList<String>(3);
        assertThrows(RuntimeException.class,()->al.get(-1));
    }

    @Test
    void getAtIndex(){
        ArrayList<String> al = new ArrayList<String>(3);
        al.add("hello");
        al.add("world");
        assertEquals("hello",al.get(0));
        assertEquals("world",al.get(1));
    }
}