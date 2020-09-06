package com.demo;

public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for(int i=0;i<bills.length;i++){
            if(bills[i]==5){
                five=five+1;
            }
            if(bills[i]==10){
                five=five-1;
                if(five<0){
                    return false;
                }
                ten=ten+1;
            }
            if(bills[i]==20){
                ten=ten-1;
                five=five-1;
                if(ten<0){
                    five=five-2;
                    if(five<0){
                        return false;
                    }
                    ten=ten+1;
                }
                if(five<0){
                    return false;
                }
            }
        }
        return true;
    }
}
