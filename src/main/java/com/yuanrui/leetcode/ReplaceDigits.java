package com.yuanrui.leetcode;

/**
 * 1844. 将所有数字用字符替换
 * 给你一个下标从 0 开始的字符串 s ，它的 偶数 下标处为小写英文字母，奇数 下标处为数字。
 * 定义一个函数 shift(c, x) ，其中 c 是一个字符且 x 是一个数字，函数返回字母表中 c 后面第 x 个字符。
 * 比方说，shift('a', 5) = 'f' 和 shift('x', 0) = 'x' 。
 * 对于每个 奇数 下标 i ，你需要将数字 s[i] 用 shift(s[i-1], s[i]) 替换。
 * 请你替换所有数字以后，将字符串 s 返回。题目 保证 shift(s[i-1], s[i]) 不会超过 'z' 。
 */
public class ReplaceDigits {

    public static void main(String[] args) {
        String s = "a1c1e1";
        System.out.println(replaceDigits(s));
    }

    public static String replaceDigits(String s) {
        int length = s.length();
        if (length == 0)
            return s;

        StringBuilder sb = new StringBuilder();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < length; ++i) {
            if (!(i%2 == 0)) {
                sb.append(shift(charArray[i-1], charArray[i] - '0'));
            } else {
                sb.append(charArray[i]);
            }
        }

        return sb.toString();
    }

    private static char shift(char c, int x) {
        return (char)(c + x);
    }
}
