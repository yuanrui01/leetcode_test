package com.yuanrui.leetcode;

public class TriangularSum {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(triangularSum(nums));
    }

    public static int triangularSum(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int[] tmp = new int[nums.length];
        for (int i = nums.length - 1; i > 0; --i) {
            for (int j = 0; j < i; ++j)
                tmp[j] = (nums[j] + nums[j+1]) % 10;
            int[] t1 = nums;
            nums = tmp;
            tmp = t1;
        }
        return nums[0];
    }

    private static void swap(int[] a, int[] b) {
        int[] tmp = b;
        b = a;
        a = tmp;
    }
}
