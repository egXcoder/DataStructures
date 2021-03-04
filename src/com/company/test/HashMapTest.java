package com.company.test;

import com.company.ds.HashMap;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HashMapTest {
    @Test
    public void checkCanBeInitialized(){
        HashMap<String , Integer> map = new HashMap<String,Integer>();
        assertEquals(0,map.getNumOfElements());
    }

    @Test
    public void addElements(){
        HashMap<String , Integer> map = new HashMap<String,Integer>();
        map.put("first",1);
        map.put("second",2);
        map.put("third",3);
        assertEquals(3,map.getNumOfElements());
    }

    @Test
    public void checkContainsElements(){
        HashMap<String , Integer> map = new HashMap<String,Integer>();
        map.put("first",1);
        map.put("second",2);
        map.put("third",3);
        assertTrue(map.contains("first"));
        assertFalse(map.contains("fourth"));
    }

    @Test
    public void removeElements(){
        HashMap<String , Integer> map = new HashMap<String,Integer>();
        map.put("first",1);
        map.put("second",2);
        map.put("third",3);
        assertTrue(map.remove("first"));
        assertFalse(map.remove("first"));
    }

    @Test
    public void getValue(){
        HashMap<String , Integer> map = new HashMap<String,Integer>();
        map.put("first",1);
        map.put("second",2);
        map.put("third",3);
        assertEquals(1,map.getValue("first"));
        assertEquals(2,map.getValue("second"));
        assertNull(map.getValue("fourth"));
    }

    @Test
    public void noDuplicationKeys(){
        HashMap<String , Integer> map = new HashMap<String,Integer>();
        map.put("first",1);
        map.put("first",2);
        assertEquals(2,map.getValue("first"));
        assertTrue(map.remove("first"));
        assertFalse(map.remove("first"));
    }

    @Test
    public void loopThroughKeys(){
        HashMap<String , Integer> map = new HashMap<String,Integer>();
        map.put("first",1);
        map.put("second",2);
        map.put("third",3);

        HashMap<String , Integer> bucketMap = new HashMap<String,Integer>();
        for(String key : map.keySet()){
            bucketMap.put(key,1);
        }

        assertTrue(bucketMap.contains("first"));
        assertTrue(bucketMap.contains("second"));
        assertTrue(bucketMap.contains("third"));
    }

    @Test
    public void loopThroughValues(){
        HashMap<String , Integer> map = new HashMap<String,Integer>();
        map.put("first",1);
        map.put("second",2);
        map.put("third",3);

        HashMap<Integer,String> bucketMap = new HashMap<Integer,String>();
        for(Integer value : map.valueSet()){
            bucketMap.put(value,"1");
        }

        assertTrue(bucketMap.contains(1));
        assertTrue(bucketMap.contains(2));
        assertTrue(bucketMap.contains(3));
    }
}
