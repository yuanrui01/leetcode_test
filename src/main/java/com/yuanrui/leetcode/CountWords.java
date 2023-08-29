package com.yuanrui.leetcode;


import java.util.*;

/**
 * 2085. 统计出现过一次的公共字符串
 */
public class CountWords {

    public static void main(String[] args) {
        String[] words1 = {"leetcode","is","amazing","as","is"};
        String[] words2 = {"amazing","leetcode","is"};
        countWords(words1, words2);
    }

    public static int countWords(String[] words1, String[] words2) {
        Map<String,Integer> map1 = new HashMap<>();
        Map<String,Integer> map2 = new HashMap<>();
        for (String s : words1)
            if (map1.get(s) != null)
                map1.put(s, 2);
            else
                map1.put(s, 1);
        map1.entrySet().removeIf(entry -> entry.getValue() != 1);
        for (String s : words2)
            if (map2.get(s) != null)
                map2.put(s, 2);
            else
                map2.put(s, 1);
        map2.entrySet().removeIf(entry -> entry.getValue() != 1);
        Set<String> key1 = map1.keySet();
        key1.retainAll(map2.keySet());
        return key1.size();
    }
}
