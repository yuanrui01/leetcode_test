package com.yuanrui.leetcode;


/**
 * 2109. 向字符串添加空格
 */
public class AddSpaces {

    public static void main(String[] args) {

        String s = "LeetcodeHelpsMeLearn";
        int[] spaces = new int[]{8,13,15};
        System.out.println(addSpaces(s, spaces));
    }

    public static String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        int k = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (k < spaces.length && i == spaces[k]) {
                sb.append(' ');
                k++;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
