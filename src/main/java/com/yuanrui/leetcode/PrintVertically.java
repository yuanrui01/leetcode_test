package com.yuanrui.leetcode;

import java.util.ArrayList;
import java.util.List;


/**
 * 1324. 竖直打印单词
 */
public class PrintVertically {

    public static void main(String[] args) {
        System.out.println(printVertically("TO BE OR NOT TO BE"));
    }


    public static List<String> printVertically(String s) {
        List<String> ans = new ArrayList<>();

        String[] sArr = s.split(" ");

        int longestWord = 0;
        for (int i = 0; i < sArr.length; ++i) {
            longestWord = Math.max(longestWord, sArr[i].length());
        }

        for (int i = 0; i < longestWord; ++i) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < sArr.length; ++j) {
                if (sArr[j].length() <= i) {
                    sb.append(" ");
                } else {
                    sb.append(sArr[j].charAt(i));
                }
            }
            ans.add(sb.toString().replaceAll("\\s+$", ""));
        }

        return ans;
    }
}
