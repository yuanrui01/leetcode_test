package com.yuanrui.leetcode;

/**
 * @author: yuanrui
 */
public class MaximumOddBinaryNumber {

    public static void main(String[] args) {
        MaximumOddBinaryNumber maximumOddBinaryNumber = new MaximumOddBinaryNumber();

        System.out.println(maximumOddBinaryNumber.maximumOddBinaryNumber("1"));
    }

    public String maximumOddBinaryNumber(String s) {
        int count1 = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '1')
                count1++;
        }

        int prefix1 = count1 - 1;
        StringBuilder sb = new StringBuilder();
        sb.append("1".repeat(prefix1));
        sb.append("0".repeat(s.length() - prefix1 - 1));
        sb.append("1");
        return sb.toString();
    }
}
