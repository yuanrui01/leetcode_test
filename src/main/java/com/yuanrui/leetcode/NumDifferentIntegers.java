package com.yuanrui.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 1805. 字符串中不同整数的数目
 * @author: yuanrui
 */
public class NumDifferentIntegers {

    public static void main(String[] args) {
        System.out.println(numDifferentIntegers("a123bc34d8ef34"));
    }

    public static int numDifferentIntegers(String word) {
        Set<String> set = new HashSet<>();

        String[] split = word.replaceAll("[a-z]", " ").split(" ");
        for (String s : split) {
            if (!"".equals(s)) {
                String trimmed = s.replaceFirst("^0+(?!$)", "");
                set.add(trimmed);
            }
        }
        return set.size();
    }
}
