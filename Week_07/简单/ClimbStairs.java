package com.demo;

public class ClimbStairs {

    public int climbStairs(int n) {
        if(n<2){
            return n;
        }
        int[] dept = new int[n];
        dept[0]=1;
        dept[1]=2;
        for(int i=2;i<dept.length;i++){
            dept[i] = dept[i-1]+dept[i-2];
        }
        return dept[n-1];
    }
}
