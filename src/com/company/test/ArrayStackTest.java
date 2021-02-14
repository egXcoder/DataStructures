package com.company.test;

import com.company.ds.ArrayQueue;
import com.company.ds.ArrayStack;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayStackTest {
    @Test
    public void pushElements(){
        ArrayStack s = new ArrayStack(10);
        for (int i=0;i<100;i++){
            try {
                s.push(i);
            }catch (Exception ex){

            }
        }
        assertEquals(s.getCount(),100);
    }

    @Test
    public void popElements(){
        ArrayStack s = new ArrayStack(10);
        for (int i=0;i<100;i++){
            try {
                s.push(i);
            }catch (Exception ex){

            }
        }

        Integer el = 0 ;
        try{
            el = (Integer) s.pop();
        }catch (Exception ex){

        }

        assertEquals(el,99);

    }
}
