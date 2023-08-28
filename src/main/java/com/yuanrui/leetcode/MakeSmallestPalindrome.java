package com.yuanrui.leetcode;


/**
 * 2697. 字典序最小回文串
 */
public class MakeSmallestPalindrome {

    public String makeSmallestPalindrome(String s) {
        if (s.length() == 1)
            return s;
        char[] charArray = s.toCharArray();
        int length = s.length();

        for (int i = 0; i < s.length()/2; ++i) {
            if (charArray[i] == charArray[length-i-1])
                continue;
            if (charArray[i] < charArray[length-i-1])
                charArray[length-i-1] = charArray[i];
            else if (charArray[i] > charArray[length-i-1])
                charArray[i] = charArray[length-i-1];
        }
        return String.valueOf(charArray);
    }
}
