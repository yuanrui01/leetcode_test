package com.yuanrui.leetcode;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1002. 查找共用字符
 * 给你一个字符串数组 words ，
 * 请你找出所有在 words 的每个字符串中都出现的共用字符（ 包括重复字符），并以数组形式返回。你可以按 任意顺序 返回答案。
 */
public class CommonChars {

    public static void main(String[] args) {
        String[] words = new String[]{"cool","lock","cook"};

        System.out.println(commonChars(words));
    }
    public static List<String> commonChars(String[] words) {
        List<Map<Character, Integer>> mapList = new ArrayList<>();
        List<String> result = new ArrayList<>();
        if (words.length == 0) {
            return result;
        }

        for (String word : words) {
            Map<Character, Integer> ciMap = new HashMap<>();
            if (word != null) {
                for (char c : word.toCharArray()) {
                    ciMap.putIfAbsent(c, 0);
                    ciMap.put(c, ciMap.get(c) + 1);
                }
            } else {
                return new ArrayList<>();
            }
            mapList.add(ciMap);
        }

        //以第一个字符串为准绳
        String std = words[0];

        for (char c : mapList.get(0).keySet()) {
            int cnt = Integer.MAX_VALUE;
            boolean notAll = false;
            for (Map<Character, Integer> ciMap : mapList) {
                Integer cCount = ciMap.get(c);
                if (cCount == null) {
                    notAll = true;
                    break;
                } else {
                    if (cCount < cnt) {
                        cnt = cCount;
                    }
                }
            }

            if (!notAll) {
                if (cnt != Integer.MAX_VALUE) {
                    for (int i = 0; i < cnt; ++i) {
                        result.add(c + "");
                    }
                }
            }
        }

        return result;
    }
}
