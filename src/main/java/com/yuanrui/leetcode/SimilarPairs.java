package com.yuanrui.leetcode;

/**
 * 2506. 统计相似字符串对的数目
 * @author: yuanrui
 */
public class SimilarPairs {

    public int similarPairs(String[] words) {
        boolean[][] pattern = new boolean[words.length][27];
        int ans = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); ++j) {
                pattern[i][word.charAt(j) - 'a'] = true;
            }
        }

        for (int i = 0; i < pattern.length - 1; ++i) {
            for (int j = i+1; j < pattern.length; ++j) {
                if (isSimilar(pattern[i], pattern[j]))
                    ans++;
            }
        }

        return ans;
    }

    private boolean isSimilar(boolean[] a, boolean[] b) {
        for (int i = 0; i < a.length; ++i) {
            if (a[i] != b[i])
                return false;
        }
        return true;
    }
}
