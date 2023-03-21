package com.yuanrui.leetcode;

/**
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/3/21-22:23
 */
public class FirstUniqChar {

    public int firstUniqChar(String s) {
        int ans = -1;
        int[] map = new int[26];

        for(int i = 0; i < s.length(); ++i){
            map[s.charAt(i) - 'a']++;
        }

        for(int i = 0; i < s.length(); ++i){
            if(map[s.charAt(i) - 'a'] == 1){
                ans = i;
            }
        }

        return ans;
    }
}
