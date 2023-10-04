package com.yuanrui.leetcode;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 316. 去除重复字母
 */
public class RemoveDuplicateLetters {

    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        boolean[] visited = new boolean[26];
        for (int i = 0; i < s.length(); i++)
            count[s.charAt(i) - 'a']++;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); ++i) {
            if (!visited[s.charAt(i) - 'a']) {
                while (!deque.isEmpty() && s.charAt(i) < s.charAt(deque.peek()) && count[s.charAt(deque.peek()) - 'a'] > 0) {
                    Integer pop = deque.pop();
                    visited[s.charAt(pop) - 'a'] = false;
                }
                deque.push(i);
                visited[s.charAt(i) - 'a'] = true;
            }
            count[s.charAt(i) - 'a']--;
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
