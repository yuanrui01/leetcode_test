package com.yuanrui.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: yuanrui
 */
public class GenerateParenthesis {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        char[] elem = new char[n*2];
        dfs(n,0, 0, elem, ans);
        return ans;
    }

    private static void dfs(int n, int open, int idx, char[] elem, List<String> ans) {
        if (idx == n*2) {
            if (isValid(elem))
                ans.add(String.copyValueOf(elem));
            return;
        }

        if (open < n) {
            elem[idx] = '(';
            dfs(n, open+1, idx+1, elem, ans);
        }

        if (idx - open < n) {
            elem[idx] = ')';
            dfs(n, open, idx+1, elem, ans);
        }
    }

    private static boolean isValid(char[] elem) {
        Stack<Character> stack = new Stack<>();
        for (char c : elem)
            if (c == '(')
                stack.push('(');
            else {
                if (stack.isEmpty() || stack.peek() != '(')
                    return false;
                stack.pop();
            }
        return stack.isEmpty();
    }
}
