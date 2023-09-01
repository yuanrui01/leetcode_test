package com.yuanrui.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 */
public class LetterCombinations {
    private static final String[] MAPPING = new String[]{
            "","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
    };
    private final List<String> ans = new ArrayList<>();
    private char[] digits, path;

    public List<String> letterCombinations(String digits){
        int length = digits.length();
        if (length == 0) {
            return List.of();
        }
        this.digits = digits.toCharArray();
        path = new char[length];
        dfs(0);
        return ans;
    }

    private void dfs(int n){
        if (n == digits.length) {
            ans.add(new String(path));
            return;
        }
        for (char c : MAPPING[digits[n] - '0'].toCharArray()) {
            path[n] = c;
            dfs(n+1);
        }
    }
}
