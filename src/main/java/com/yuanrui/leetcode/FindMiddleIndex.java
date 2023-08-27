package com.yuanrui.leetcode;

/**
 * @description: 1991. 找到数组的中间位置 ，这题相向双指针会更快
 * @author: yuanrui
 * @email: xdyrfree@gmail.com
 * @date: 2023/8/27-22:37
 */
public class FindMiddleIndex {

    public static void main(String[] args) {
        System.out.println(findMiddleIndex(new int[]{2,3,-1,8,4}));
        System.out.println(findMiddleIndex(new int[]{1,-1,4}));
        System.out.println(findMiddleIndex(new int[]{2,5}));

    }

    public static int findMiddleIndex(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        for (int i = 0;i < nums.length; ++i) {
            if (left(nums,i) == right(nums,i)) {
                return i;
            }
        }

        return -1;
    }

    private static int left(int[] nums, int k) {
        int result = 0;
        for (int i = 0; i < k; ++i) {
            result += nums[i];
        }
        return result;
    }

    private static int right(int[] nums, int k) {
        int result = 0;
        for (int i = k+1; i < nums.length; ++i) {
            result += nums[i];
        }
        return result;
    }
}
