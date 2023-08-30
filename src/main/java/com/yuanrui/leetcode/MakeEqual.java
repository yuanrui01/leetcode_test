package com.yuanrui.leetcode;


/**
 * 1897. 重新分配字符使所有字符串都相等
 * 给你一个字符串数组 words（下标 从 0 开始 计数）。
 * 在一步操作中，需先选出两个 不同 下标 i 和 j，其中 words[i] 是一个非空字符串，接着将 words[i] 中的 任一 字符移动到 words[j] 中的 任一 位置上。
 * 如果执行任意步操作可以使 words 中的每个字符串都相等，返回 true ；否则，返回 false 。
 */
public class MakeEqual {


    public static void main(String[] args) {
        String[] words = {"abc","aabc","bc"};
    }

    /**
     * 输入：words = ["abc","aabc","bc"]
     * 输出：true
     * 解释：将 words[1] 中的第一个 'a' 移动到 words[2] 的最前面。
     * 使 words[1] = "abc" 且 words[2] = "abc" 。
     * 所有字符串都等于 "abc" ，所以返回 true 。
     * @param words
     * @return
     */
    public boolean makeEqual(String[] words) {
        int length = words.length;
        if (length == 1)
            return true;
        int[][] cArr = new int[27][1];
        for (String word : words)
            for (char c : word.toCharArray())
                cArr[c - 'a'][0]++;
        for (int[] ints : cArr)
            if (ints[0] % length != 0)
                return false;
        return true;
    }
}
