package com.yuanrui.leetcode;

/**
 * @author: yuanrui
 */
public class Zhousai090201 {


    public static void main(String[] args) {

        System.out.println(canBeEqual("abe", "bea"));
        //System.out.println(canBeEqual("abcd", "dacb"));
        //System.out.println(canBeEqual("abcd", "cbad"));
    }

    public static boolean canBeEqual(String s1, String s2) {
        if (s1.equals(s2))
            return true;
        int[] s1Arr1 = new int[27];
        int[] s1Arr2 = new int[27];
        int[] s2Arr1 = new int[27];
        int[] s2Arr2 = new int[27];


        for (int i = 0; i < s1.length(); i++) {
            if (i%2 == 0)
                s1Arr1[s1.charAt(i) - 'a']++;
            else
                s1Arr2[s1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s2.length(); i++) {
            if (i%2 == 0)
                s2Arr1[s2.charAt(i) - 'a']++;
            else
                s2Arr2[s2.charAt(i) - 'a']++;
        }

//        for (int i = 0; i < s1.length(); ++i) {
//            if (i%2 == 0) {
//                if (s1Arr1[s1.charAt(i) - 'a'] != s2Arr1[s2.charAt(i) - 'a'])
//                    return false;
//            } else {
//                if (s1Arr2[s1.charAt(i) - 'a'] != s2Arr2[s2.charAt(i) - 'a'])
//                    return false;
//            }
//        }

        for (int i = 0; i < s1Arr1.length; i++) {
            if (s1Arr1[i] != s2Arr1[i])
                return false;
        }

        for (int i = 0; i < s1Arr2.length; i++) {
            if (s1Arr2[i] != s2Arr2[i])
                return false;
        }

        return true;
    }
}
