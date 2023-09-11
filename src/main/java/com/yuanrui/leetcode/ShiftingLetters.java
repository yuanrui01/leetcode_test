package com.yuanrui.leetcode;


/**
 * 2381. 字母移位 II
 */
public class ShiftingLetters {

    public String shiftingLetters(String s, int[][] shifts) {
        char[] charArray = s.toCharArray();
        int[] diff = new int[s.length() + 1];

        for (int[] shift : shifts) {
            if (shift[2] == 1) {
                // 向前移动
                diff[shift[0]] += 1;
                diff[shift[1] + 1] -= 1;
            } else {
                // 向后移动
                diff[shift[0]] -= 1;
                diff[shift[1] + 1] += 1;
            }
        }
        int sum = 0;
        for (int i = 0; i < charArray.length; ++i) {
            sum += diff[i];
            char c = charArray[i];
            int c_diff = (c - 'a') + sum;
            c_diff = c_diff > 0 ? c_diff : c_diff%26 + 26;
            charArray[i] = (char) ('a' + (c_diff)%26);
        }

        return String.valueOf(charArray);
    }


    public static void main(String[] args) {
        System.out.println(-27%26);
    }
}
