package com.yuanrui.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 */
public class LengthOfLongestSubstring {


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abba"));
    }

    /**
     * 正常对象哈希
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int begin = 0;
        for(int i = 0; i < s.length(); ++i){
            if(map.containsKey(s.charAt(i))){
                begin = Math.max(begin,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i - begin + 1);
        }

        return max;
    }


    /**
     * 朴素哈希提速版
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring2(String s) {
        int[] idxArr = new int[256];
        Arrays.fill(idxArr, -1);
        int max = 0;
        int begin = 0;
        char[] charArray = s.toCharArray();
        for(int i = 0; i < s.length(); ++i){
            if (idxArr[charArray[i]] != -1)
                begin = Math.max(begin, idxArr[charArray[i]] + 1);
            idxArr[charArray[i]] = i;
            max = Math.max(max, i - begin + 1);
        }

        return max;
    }
}
