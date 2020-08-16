package com.demo;

public class AddOne {
    public int[] plusOne(int[] digits) {
        boolean addOne = true;
        int len = digits.length;
        int[] result = new int[len];
        for(int i=len-1;i>=0;i--){
            if(addOne){
                result[i]=(digits[i]+1)>9?0:digits[i]+1;
                if(result[i]!=0){
                    addOne = false;
                }
            }else{
                result[i]=digits[i];
            }
        }
        if(result[0]==0){
            result = new int[len+1];
            result[0]=1;
        }
        return result;
    }
}
