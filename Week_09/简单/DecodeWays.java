package com.demo;

public class DecodeWays {

    public int numDecodings(String s) {
        return help(s, 0);
    }

    private int help(String s, int start) {
        if (start == s.length()) {
            return 1;
        }
        if (s.charAt(start) == '0') {
            return 0;
        }
        int res1 = help(s, start + 1);
        int res2 = 0;
        if (start < s.length() - 1) {
            int ten = (s.charAt(start) - '0') * 10;
            int one = s.charAt(start + 1) - '0';
            if (ten + one <= 26) {
               res2 = help(s, start + 2);
            }
        }
        return res1 + res2;
    }
}
