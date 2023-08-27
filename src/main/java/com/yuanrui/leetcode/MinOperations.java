package com.yuanrui.leetcode;

/**
 * @description:
 * @author: yuanrui
 * @email: xdyrfree@gmail.com
 * @date: 2023/8/27-11:38
 */
public class MinOperations {

    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{1,2,8},7));
    }
    public static int minOperations(int[] nums, int target) {
        int count = 0;
        int sum = 0;
        int i = 0;

        while (target > 0 && i < nums.length) {
            if (nums[i] > target) {
                i++;
            } else if (nums[i] == target) {
                count++;
                target = 0;
            } else {
                int temp = target / nums[i];
                count += temp;
                target -= temp * nums[i];
                i++;
            }
        }

        return target == 0 ? count : -1;
    }

}
