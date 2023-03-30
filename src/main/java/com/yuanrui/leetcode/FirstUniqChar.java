package com.yuanrui.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/3/21-22:23
 */
public class FirstUniqChar {

    public static void main(String[] args) {
        firstUniqChar1("leetcode");
    }

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


    public static int firstUniqChar1(String s) {
        Map<Character, Integer> map = new HashMap<>();
        Integer t = 1;

        for(int i = 0; i < s.length(); ++i){
            if(map.get(s.charAt(i)) != null){
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }else{
                map.put(s.charAt(i), 0);
            }
        }


        for(int i = 0; i < s.length(); ++i){
            if(t.equals(map.get(s.charAt(i)))){
                return i;
            }
        }


        return -1;
    }
}
