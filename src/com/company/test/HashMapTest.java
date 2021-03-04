package com.company.test;

import com.company.ds.HashMap;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HashMapTest {
    @Test
    public void checkifHashMapCanBeInitialized(){
        HashMap<String , Integer> map = new HashMap<String,Integer>();
        assertEquals(0,map.getNumOfElements());
    }

    @Test
    public void addElementsToHashMap(){
        HashMap<String , Integer> map = new HashMap<String,Integer>();
        map.add("first",1);
        map.add("second",2);
        map.add("third",3);
        assertEquals(3,map.getNumOfElements());
    }
}
