package com.company;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        boolean var;
        long startTime = System.nanoTime();
        for(int i=0;i<100000;i++){
            var = (2131412311>0);
        }
        System.out.println(System.nanoTime()-startTime);
        startTime = System.nanoTime();
        for(int i=0;i<100000;i++){
            var = ((2131412311&1)>0);
        }
        System.out.println(System.nanoTime()-startTime);
    }

    private static void test(int[] x){
        x[0] = 123;
    }
}