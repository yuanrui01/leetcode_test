package com.yuanrui.leetcode;

import java.util.List;

/**
 * @author: yuanrui
 */
public class ValidWordSquare {
    public boolean validWordSquare(List<String> words) {
        for(int i = 0; i < words.size(); ++i) {
            String s = words.get(i);
            if (words.size() < s.length())
                return false;
            for (int j = 0; j < s.length(); ++j) {
                String sj = words.get(j);
                // now we have (i,j)
                // firstly, check if exists (j,i), if not exists, return false
                // secondly, if (i,j) not equals to (j,i), return false
                if (i >= sj.length())
                    return false;
                if (sj.charAt(i) != s.charAt(j))
                    return false;
            }
        }
        return true;
    }
}
