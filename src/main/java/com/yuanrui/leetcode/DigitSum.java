package com.yuanrui.leetcode;

/**
 * @description: 2243. 计算字符串的数字和
 * @author: yuanrui
 * @email: xdyrfree@gmail.com
 * @date: 2023/8/27-21:57
 */
public class DigitSum {

    public static void main(String[] args) {
        String s = "11111222223";
        int k = 3;

        System.out.println(digitSum(s,k));
    }

    public static String digitSum(String s, int k) {
        while (true) {
            if (s.length() <= k) {
                return s;
            }
            int i = 0;
            StringBuilder sb = new StringBuilder();
            for (; (i + k) <= s.length(); i+=k) {
                sb.append(process(s.substring(i, i+k)));
            }
            if (i < s.length()) {
                sb.append(process(s.substring(i)));
            }
            s = sb.toString();
        }
    }

    private static String process(String s) {
        if ("".equals(s)) {
            return s;
        }
        int result = 0;
        for (char c : s.toCharArray()) {
            result += Character.getNumericValue(c);
        }
        return String.valueOf(result);
    }

}
