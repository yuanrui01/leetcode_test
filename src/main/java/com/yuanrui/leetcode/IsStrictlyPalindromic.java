package com.yuanrui.leetcode;


/**
 * 2396. 严格回文的数字
 */
public class IsStrictlyPalindromic {

    public static void main(String[] args) {
        isStrictlyPalindromic(123,17);
    }
    public static boolean isStrictlyPalindromic(int n, int radix) {

        String result = Integer.toString(n, radix);
        System.out.println(result); // 输出：7B

        return true;
    }
}
