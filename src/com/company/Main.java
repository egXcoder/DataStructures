package com.company;


import java.util.*;

public class Main {
    public static void main(String[] args) {
      PriorityQueue queue = new PriorityQueue();
      queue.add(12);
      queue.add(3);
      queue.add(23);
      queue.add(5);

      System.out.println(queue.poll());
      System.out.println(queue.poll());
      System.out.println(queue.poll());
      System.out.println(queue.poll());
    }

    private static void test(int[] x){
        x[0] = 123;
    }
}