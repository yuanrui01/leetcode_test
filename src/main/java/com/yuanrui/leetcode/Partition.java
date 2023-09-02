package com.yuanrui.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. 分割回文串
 */
public class Partition {

    public static void main(String[] args) {
        System.out.println(partition("aab"));
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> partition = new ArrayList<>();

        dfs(s, 0, partition, ans);
        return ans;
    }

    private static void dfs(String s, int idx, List<String> partition, List<List<String>> ans) {
        if (idx == s.length())
            ans.add(new ArrayList<>(partition));

        for (int i = idx + 1; i <= s.length(); ++i) {
            String substr = s.substring(idx,i);
            if (isPalindrome(substr)) {
                partition.add(substr);
                dfs(s, i, partition, ans);
                partition.remove(partition.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s) {
        int i = 0;
        int k = s.length() - 1;
        while(i < k)
            if (s.charAt(i++) != s.charAt(k--))
                return false;
        return true;
    }
}
