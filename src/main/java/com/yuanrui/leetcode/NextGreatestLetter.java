package com.yuanrui.leetcode;

/**
 * 744. 寻找比目标字母大的最小字母
 */
public class NextGreatestLetter {

    public static void main(String[] args) {

    }

    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;
        int middle;
        while (left <= right) {
            middle = (left + right) / 2;
            if (letters[middle] <= target)
                left = left + 1;
            else
                right = right - 1;
        }
        if (right == -1 || left == letters.length)
            return letters[0];
        else
            return letters[left];
    }
}
