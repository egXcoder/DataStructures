package com.company;


import java.util.*;

public class Main {
    public static void main(String[] args) {
    }


    private static void test(int[] x){
        x[0] = 123;
    }

    public static int openLock(String[] deadends, String target) {
        Queue<String> q = new LinkedList<String>();
        HashSet<String> set = new HashSet<String>();

        int step = 0;
        q.add("0000");

        while(!q.isEmpty()){
            step++;

            int size = q.size();
            for(int i=0;i<size;i++){
                String x = q.peek();
                set.add(x);

                if(x.equals(target)){
                    return step-1;
                }

                System.out.println(x);
                for(int j=0;j<x.length();j++){
                    char[] charArray = x.toCharArray();
                    if(charArray[j]+1 > 57){
                        charArray[j] = (char) ((int) x.charAt(j)+1-10);
                    }else{
                        charArray[j] = (char) ((int) x.charAt(j)+1);
                    }
                    String xx = String.valueOf(charArray);
                    if(!Arrays.stream(deadends).anyMatch(xx::equals) && !set.contains(xx)){
                        q.add(xx);
                    }


                    charArray = x.toCharArray();
                    if(charArray[j]-1 < 48){
                        charArray[j] = (char) ((int) x.charAt(j)-1+10);
                    }else{
                        charArray[j] = (char) ((int) x.charAt(j)-1);
                    }

                    xx = String.valueOf(charArray);
                    if(!Arrays.stream(deadends).anyMatch(xx::equals)  && !set.contains(xx)){
                        q.add(xx);
                    }
                }


                q.poll();
            }

        }

        return -1;
    }
}