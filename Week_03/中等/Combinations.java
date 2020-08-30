package com.demo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result =new ArrayList<>();
        if (n <= 0 || k <= 0 || n < k) {
            return result;
        }
        LinkedList<Integer> currentList = new LinkedList<>();
        helper(currentList,n,k,1,result);
        return result;
    }
    public void helper(LinkedList<Integer> currentList, int n, int k, int begin, List<List<Integer>> result){
        if(currentList.size()==k){
            result.add(new LinkedList(currentList));
            return;
        }
        for (int i = begin; i <=n; i++) {
            currentList.add(i);
            helper(currentList,n, k, i + 1, result);
            currentList.removeLast();
        }
    }
}
