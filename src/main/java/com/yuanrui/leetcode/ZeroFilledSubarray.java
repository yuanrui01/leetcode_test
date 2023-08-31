package com.yuanrui.leetcode;


/**
 * 2348. 全 0 子数组的数目
 */
public class ZeroFilledSubarray {

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,0,0,2,0,0,4};
        System.out.println(zeroFilledSubarray(nums));
    }

    public static long zeroFilledSubarray(int[] nums) {
        long ans = 0;

        int k = 0;
        while (k < nums.length) {
            while (k < nums.length && nums[k] != 0) {
                k++;
            }
            if (k != nums.length) {
                int setSize = 0;
                while (k < nums.length && nums[k] == 0) {
                    k++;
                    setSize++;
                }
                ans +=  (long)setSize * (1 + setSize) / 2;
            }
        }

        return ans;
    }
}
