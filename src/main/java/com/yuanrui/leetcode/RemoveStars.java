package com.yuanrui.leetcode;

import java.util.Stack;

/**
 * 2390. 从字符串中移除星号
 * @author: yuanrui
 */
public class RemoveStars {

    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray())
            if (c == '*' && !stack.isEmpty()) {
                stack.pop();
            } else {
                stack.push(c);
            }

        return stack.stream()
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }
}
