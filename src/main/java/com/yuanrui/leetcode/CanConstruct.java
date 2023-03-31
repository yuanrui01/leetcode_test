package com.yuanrui.leetcode;

public class CanConstruct {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] magazineCount = new int[26];

        for(int i = 0; i < magazine.length(); ++i){
            magazineCount[magazine.charAt(i) - 'a']++;
        }
        for(int i = 0; i < ransomNote.length(); ++i){
            if(--magazineCount[ransomNote.charAt(i) - 'a'] < 0){
                return false;
            }
        }
        return true;
    }
}
