package com.yuanrui.leetcode;

import java.util.Arrays;

public class IsAnagram {

    public boolean isAnagram(String s, String t) {
        int[] sCount = new int[26];
        int[] tCount = new int[26];


        for(int i = 0; i < s.length(); ++i){
            sCount[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < t.length(); ++i){
            tCount[t.charAt(i) - 'a']++;
        }

        if(Arrays.equals(sCount,tCount)){
            return true;
        }else{
            return false;
        }
    }
}
