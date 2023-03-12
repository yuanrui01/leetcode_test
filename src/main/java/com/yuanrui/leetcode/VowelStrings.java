package com.yuanrui.leetcode;

/**
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/3/12-11:00
 */
public class VowelStrings {

    public static void main(String[] args) {
        System.out.println(vowelStrings(new String[]{"hey","aeo","mu","ooo","artro"},1,4));;
    }

    public static int vowelStrings(String[] words, int left, int right) {
        int ans = 0;

        for(int i = left; i <= right; ++i){
            if(isVowelString(words[i])){
                ans++;
            }
        }

        return ans;
    }

    private static boolean isVowelString(String s){
        char first = s.charAt(0);
        char last = s.charAt(s.length() - 1);
        if(!('a' == first) && !('e' == first) && !('i' == first) && !('o' == first) && !('u' == first)) {
            return false;
        }
        if(!('a' == last) && !('e' == last) && !('i' == last) && !('o' == last) && !('u' == last)) {
            return false;
        }
        return true;
    }
}
