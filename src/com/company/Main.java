package com.company;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(numSquares(88));
    }

    public static int numSquares(int n) {
        int [] mem = new int[n+1];
        for(int i=0;i<=n;i++)
            mem[i] = i;

        for(int i=1;i<=n;i++)
        {
            int biggestSquareRoot = (int) Math.sqrt(i);
            for(int j=1;j<=biggestSquareRoot;j++)
            {
                if(j*j<=i)
                    dp[i] = Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        return dp[n];
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