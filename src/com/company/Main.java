package com.company;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList l = new ArrayList(2);
        l.add("asd");
        l.add("qwe");
        l.add("ewq");
        l.remove("qwe");
        System.out.println(l.get(0));
        System.out.println(l.get(1));
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