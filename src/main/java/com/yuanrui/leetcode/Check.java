package com.yuanrui.leetcode;

/**
 * 1752. 检查数组是否经排序和轮转得到
 * @author: yuanrui
 */
public class Check {

    public static void main(String[] args) {
        int[] nums1 = {3,4,5,1,2};
        check(nums1);
    }

    public static boolean check(int[] nums) {
        if (nums.length == 1)
            return true;
        int len = nums.length;
        int breakCnt = 0;
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] > nums[i+1]) {
                if (nums[0] < nums[len - 1])
                    return false;
                breakCnt++;
            }
        }

        return breakCnt <= 1;
    }
}
