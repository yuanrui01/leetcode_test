package com.yuanrui.leetcode;

import java.util.Stack;

/**
 * 1614. 括号的最大嵌套深度
 * @author: yuanrui
 */
public class MaxDepth {


    public int maxDepth(String s) {
        Stack<Character> stack = new Stack<>();
        int ans = 0;
        int depth = 0;

        for (char c : s.toCharArray()) {
            if (c != ')') {
                stack.push(c);
                if (c == '(') {
                    depth++;
                    ans = Math.max(ans, depth);
                }
            } else {
                while (!stack.isEmpty() && stack.peek() != '(')
                    stack.pop();
                if (!stack.isEmpty())
                    stack.pop();
                depth--;
            }
        }

        return stack.isEmpty()? ans:0;
    }
}
