package com.yuanrui.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/4/11-22:14
 */
public class FindAnagrams {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();

        if (s.length() < p.length())
            return ans;

        int pLen = p.length();
        int[] pMap = new int[26];
        int[] tMap = new int[26];

        for(int i  = 0; i < pLen; ++i){
            pMap[(p.charAt(i) - 'a')]++;
            tMap[(s.charAt(i) - 'a')]++;
        }

        for (int i = pLen; i <= s.length(); ++i){
            if (Arrays.equals(pMap, tMap))
                ans.add(i - pLen);
            if(i != s.length()){
                tMap[s.charAt(i - pLen) - 'a']--;
                tMap[s.charAt(i) - 'a']++;
            }
        }

        return ans;
    }
}
