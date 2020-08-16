package com.demo;

import java.util.HashMap;
import java.util.Map;

public class Twosum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            int minusResult = target-nums[i];
            if(map.containsKey(minusResult)&&map.get(minusResult)!=i){
                return new int[]{i,map.get(minusResult)};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No Result!");
    }
}
