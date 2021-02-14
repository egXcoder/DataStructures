package com.company.test;

import com.company.ds.ArrayBlockingQueue;
import com.company.ds.ArrayBlockingStack;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArrayBlockingStackTest {
    @Test
    public void pushElements(){
        ArrayBlockingStack<String> s = new ArrayBlockingStack<String>(10);
        try{
            s.push("test");
            s.push("test2");
            s.push("test3");
        }catch (Exception ex){

        }
        assertEquals(s.getCount(),3);
    }

    @Test
    public void popElements(){
        ArrayBlockingStack<String> s = new ArrayBlockingStack<String>(10);
        String poped = "";
        try{
            s.push("test");
            s.push("test2");
            s.push("test3");
            poped = s.pop();
        }catch (Exception ex){

        }
        assertEquals(s.getCount(),2);
        assertEquals(poped,"test3");
    }
}
