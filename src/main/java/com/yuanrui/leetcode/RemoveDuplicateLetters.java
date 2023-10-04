package com.yuanrui.leetcode;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 316. 去除重复字母
 */
public class RemoveDuplicateLetters {

    public String removeDuplicateLetters(String s) {
        int[] count = new int[26]; // 计数，用于判断后续是否还有相同的字符
        boolean[] inStack = new boolean[26]; // 判断字符是否在栈中
        for (int i = 0; i < s.length(); i++)
            count[s.charAt(i) - 'a']++;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); ++i) {
            int charIdx = s.charAt(i) - 'a';
            if (!inStack[charIdx]) {
                while (!deque.isEmpty() && s.charAt(i) < s.charAt(deque.peek()) && count[s.charAt(deque.peek()) - 'a'] > 0)
                    inStack[s.charAt(deque.pop()) - 'a'] = false;
                deque.push(i);
                inStack[charIdx] = true;
            }
            count[charIdx]--; // 不管是否在栈中，当前元素都已成过客，减之！
        }
        StringBuilder sb = new StringBuilder();
        for (Integer i : deque)
            sb.append(s.charAt(i));
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "bbcaac";

        RemoveDuplicateLetters removeDuplicateLetters = new RemoveDuplicateLetters();

        System.out.println(removeDuplicateLetters.removeDuplicateLetters(s));
    }
}
