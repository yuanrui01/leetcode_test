package com.yuanrui.leetcode;

import java.util.Arrays;

/**
 * 806. 写字符串需要的行数
 * 我们要把给定的字符串 S 从左到右写到每一行上，每一行的最大宽度为100个单位，
 * 如果我们在写某个字母的时候会使这行超过了100 个单位，那么我们应该把这个字母写到下一行。
 * 我们给定了一个数组 widths ，这个数组 widths[0] 代表 'a' 需要的单位，
 * widths[1] 代表 'b' 需要的单位，...， widths[25] 代表 'z' 需要的单位。
 * 现在回答两个问题：至少多少行能放下S，以及最后一行使用的宽度是多少个单位？将你的答案作为长度为2的整数列表返回。
 */
public class NumberOfLines {

    /**
     * widths = [10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10]
     * S = "abcdefghijklmnopqrstuvwxyz"
     * @param args
     */
    public static void main(String[] args) {
//        int[] widths = new int[]{4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
//        String s = "bbbcccdddaaa";
        int[] widths = new int[]{10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
        String s = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(Arrays.toString(numberOfLines(widths, s)));
    }

    public static int[] numberOfLines(int[] widths, String s) {
        int[] result = new int[2];
        int lines = 0;
        int lineChar = 0;
        for (char c : s.toCharArray()) {
            int width = widths[c - 'a'];
            if (lineChar + width > 100) {
                lines++;
                lineChar = 0;
            }
            lineChar += width;
        }
        result[1] = lineChar;
        result[0] = lines + (lineChar > 0 ? 1 : 0);
        return result;
    }
}
