package com.yuanrui.leetcode;

public class ReverseWords {
    public String reverseWords(String s) {
        String[] s1 = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < s1.length; ++i){
            char[] temps = s1[i].toCharArray();
            reverseString(temps);
            stringBuilder.append(temps);
            stringBuilder.append(" ");
        }

        String res = stringBuilder.toString();
        return res.substring(0, res.length() - 1);
    }

    public void reverseString(char[] s) {
        char t = 'c';

        for(int i = 0,j = s.length-1; i<j; ++i,--j){
            t = s[i];
            s[i] = s[j];
            s[j] = t;
        }
    }
}
