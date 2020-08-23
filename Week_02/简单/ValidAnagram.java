package com.demo;

import java.util.Arrays;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(s!=null&&t!=null&&s.length()==t.length()){
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                int index = t.indexOf(String.valueOf(c));
                if(index==-1){
                    return false;
                }
                t = t.substring(0,index)+t.substring(index+1);
            }
            return true;
        }
        return false;
    }
    public boolean isAnagram2(String s, String t) {
        if(s!=null&&t!=null&&s.length()==t.length()){
            char[] sChars = s.toCharArray();
            char[] tChars = t.toCharArray();
            Arrays.sort(sChars);
            Arrays.sort(tChars);
            return Arrays.equals(sChars,tChars);
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(new ValidAnagram().isAnagram2("anagraq","nagaram"));
    }
}
