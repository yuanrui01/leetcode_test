package com.yuanrui.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 2734. 执行子串操作后的字典序最小字符串
 * @author: yuanrui
 */
public class SmallestString {

    public String smallestString(String s) {
        List<Integer> aIdx = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a')
                aIdx.add(i);
        }
        int left = -1;
        int right = s.length();
        if (!aIdx.isEmpty()) {
            if (aIdx.get(0) != 0)
                right = aIdx.get(0);
            else {
                int k = 0;
                while(k < aIdx.size() && aIdx.get(k) == k)
                    k++;
                left = k - 1;
                if (k < aIdx.size())
                    right = aIdx.get(k);
            }
        }
        if (aIdx.size() == s.length())
            return s.substring(0, s.length() - 1) + 'z';
        else
            return shift(s, left, right);
    }

    private String shift(String s, int left, int right) {
        char[] charArray = s.toCharArray();
        for (int i = left + 1; i < right; ++i)
            charArray[i] = (char)('a' + (charArray[i] - 'a' - 1));
        return String.valueOf(charArray);
    }

    public static void main(String[] args) {

        SmallestString smallestString = new SmallestString();

        System.out.println(smallestString.smallestString("aab"));
    }
}
