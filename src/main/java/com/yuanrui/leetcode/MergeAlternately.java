package com.yuanrui.leetcode;

/**
 * @description:
 * @author: yuanrui
 * @email: xdyrfree@gmail.com
 * @date: 2023/8/24-21:11
 */
public class MergeAlternately {
    public String mergeAlternately(String word1, String word2) {
        if (word1 == null || word1.isEmpty())
            return word2;
        if (word2 == null || word2.isEmpty())
            return word1;

        StringBuilder stringBuilder = new StringBuilder();

        int word1Length = word1.length();
        int word2Length = word2.length();

        int i = 0;
        int k = 0;
        boolean flag = true;
        while (i < word1Length && k < word2Length) {
            if (flag) {
                stringBuilder.append(word1.charAt(i++));
                flag = false;
            } else {
                stringBuilder.append(word2.charAt(k++));
                flag = true;
            }
        }

        while (i < word1Length)
            stringBuilder.append(word1.charAt(i++));
        while (k < word2Length)
            stringBuilder.append(word2.charAt(k++));

        return stringBuilder.toString();
    }

}
