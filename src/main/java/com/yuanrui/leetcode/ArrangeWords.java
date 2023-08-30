package com.yuanrui.leetcode;


import java.util.Arrays;
import java.util.Comparator;

/**
 * 1451. 重新排列句子中的单词
 * 「句子」是一个用空格分隔单词的字符串。给你一个满足下述格式的句子 text :
 * 句子的首字母大写
 * text 中的每个单词都用单个空格分隔。
 * 请你重新排列 text 中的单词，使所有单词按其长度的升序排列。如果两个单词的长度相同，则保留其在原句子中的相对顺序。
 * 请同样按上述格式返回新的句子。
 */
public class ArrangeWords {

    public static void main(String[] args) {
        String text = "Leetcode is cool";

        System.out.println(arrangeWords(text));
    }


    /**
     * 输入：text = "Leetcode is cool"
     * 输出："Is cool leetcode"
     * 解释：句子中共有 3 个单词，长度为 8 的 "Leetcode" ，长度为 2 的 "is" 以及长度为 4 的 "cool" 。
     * 输出需要按单词的长度升序排列，新句子中的第一个单词首字母需要大写。
     * @param text
     * @return
     */
    public static String arrangeWords(String text) {
        if (text.length() == 1)
            return text;
        text = text.toLowerCase();
        String[] s = text.split(" ");
        Arrays.sort(s, Comparator.comparingInt(String::length));
        String join = String.join(" ", s);
        return join.substring(0,1).toUpperCase() + join.substring(1);
    }
}
