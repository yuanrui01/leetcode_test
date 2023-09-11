package com.yuanrui.leetcode;

/**
 * 2772. 使数组中的所有元素都等于零
 * @author: yuanrui
 */
public class CheckArray {

    public static void main(String[] args) {
        int[] nums = {2,2,3,1,1,0};
        int k = 3;

        System.out.println(checkArray(nums,k));
    }

    public static boolean checkArray(int[] nums, int k) {
        int[] diff = new int[nums.length + k];

        int i = 0;
        int sum = 0;
        while ( i <= nums.length - k) {
            if (nums[i] + sum < 0)
                return false;
            else if (nums[i] + sum > 0) {
                diff[i] -= (nums[i] + sum);
                diff[i+k-1] += (nums[i] + sum);
            }
            sum += diff[i];
            i++;
        }
        while (i < nums.length) {
            if (nums[i] + sum != 0)
                return false;
            sum += diff[i];
            i++;
        }
        return true;
    }
}
