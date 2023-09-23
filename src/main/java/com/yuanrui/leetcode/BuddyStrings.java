package com.yuanrui.leetcode;


/**
 * 859. 亲密字符串
 */
public class BuddyStrings {

    public static void main(String[] args) {
        System.out.println(buddyStrings("a", "a"));
    }

    public static boolean buddyStrings(String s, String goal) {
        // 0. 不必多说
        if (s.length() != goal.length())
            return false;
        int[] sArr = new int[26];
        // 1. 字符串相等，仅当有重复元素时才为真
        if (s.equals(goal)) {
            for (int i = 0; i < s.length(); ++i)
                if (++sArr[s.charAt(i) - 'a'] > 1)
                    return true;
            return false;
        } else {
            // 2. 字符串不相等，那么仅当字符差距为2，且交叉相等才为真
            int diff = 0;
            int first = -1;
            int second = -1;
            for (int i = 0; i < s.length(); ++i)
                if (s.charAt(i) != goal.charAt(i)) {
                    diff++;
                    second = first;
                    first = i;
                    if (diff > 2)
                        return false;
                }
            return diff == 2 &&
                    s.charAt(first) == goal.charAt(second) && s.charAt(second) == goal.charAt(first);
        }
    }
}
