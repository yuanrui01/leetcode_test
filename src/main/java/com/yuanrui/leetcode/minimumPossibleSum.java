package com.yuanrui.leetcode;

/**
 * @description:
 * @author: yuanrui
 * @email: xdyrfree@gmail.com
 * @date: 2023/8/27-10:35
 */
public class minimumPossibleSum {

    public static void main(String[] args) {
        System.out.println(minimumPossibleSum(2,3));

        System.out.println(minimumPossibleSum(3,3));
        System.out.println(minimumPossibleSum(1,1));
        System.out.println(minimumPossibleSum(16,6));

    }


    public static long minimumPossibleSum(int n, int target) {
        if (n == 1) {
            return 1;
        }
        int[] nums = new int[n];
        long result = 0L;
        boolean flag = false;
        boolean isEven = (target % 2 == 0);
        nums[0] = 1;
        for (int i = 1; i < n; i++) {
            if (!flag) {
                if (isEven) {
                    nums[i] = i+1;
                    if (i >= 2 && ((nums[i] + nums[i - 2]) == target)) {
                        nums[i] = target;
                        flag = true;
                    }
                } else {
                    nums[i] = i+1;
                    if ((nums[i] + nums[i - 1]) == target) {
                        nums[i] = target;
                        flag = true;
                    }
                }
            } else {
                nums[i] = ++target;
            }
        }


        for(int i = 0; i < nums.length; ++i) {
            result += nums[i];
        }

        return result;
    }
}
