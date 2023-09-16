package com.yuanrui.leetcode;

/**
 * 2744. 最大字符串配对数目
 * @author: yuanrui
 */
public class MaximumNumberOfStringPairs {
    public int maximumNumberOfStringPairs(String[] words) {
        int ans = 0;
        int len = words.length;
        for (int i = 0; i < len; ++i)
            for (int j = i + 1; j < len; ++j)
                if (words[i].charAt(0) == words[j].charAt(1) && words[i].charAt(1) == words[j].charAt(0))
                    ans++;
        return ans;
    }
}
