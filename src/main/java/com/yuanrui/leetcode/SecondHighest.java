package com.yuanrui.leetcode;

/**
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/3/21-18:02
 */
public class SecondHighest {

    public static void main(String[] args) {

    }

    public int secondHighest(int[] arr) {
        int first = -1, second = -1;
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if (num > first) {
                second = first;
                first = num;
            } else if (num < first && num > second) {
                second = num;
            }
        }
        return second;
    }
}
