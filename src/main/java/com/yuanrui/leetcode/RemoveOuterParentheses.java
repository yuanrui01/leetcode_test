package com.yuanrui.leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * 1021. 删除最外层的括号
 */
public class RemoveOuterParentheses {

    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("()()"));
    }

    public static String removeOuterParentheses(String s) {
        int parentheses = 0;
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (parentheses > 0)
                    res.append(c);
                parentheses++;
            } else if (c == ')') {
                parentheses--;
                if (parentheses > 0)
                    res.append(c);
            }
        }
        return res.toString();
    }
}
