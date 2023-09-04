package com.yuanrui.leetcode;


/**
 *
 */
public class MinSteps {

    public static void main(String[] args) {
        System.out.println(minSteps("bab", "aba"));
        System.out.println(minSteps("leetcode", "practice"));
        System.out.println(minSteps("anagram", "mangaar"));
        System.out.println(minSteps("xxyyzz", "xxyyzz"));
        System.out.println(minSteps("friend", "family"));
    }


    public static int minSteps(String s, String t) {
        int[] sCnt = new int[27];
        int[] tCnt = new int[27];
        int ans = 0;
        for (int i = 0; i < s.length(); ++i) {
            sCnt[s.charAt(i) - 'a']++;
            tCnt[t.charAt(i) - 'a']++;
        }
        for (int i = 0; i < sCnt.length; ++i)
            ans += Math.abs(sCnt[i] - tCnt[i]);

        return ans/2;
    }
}
