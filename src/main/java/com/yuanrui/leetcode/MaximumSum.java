package com.yuanrui.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 2342. 数位和相等数对的最大和
 * @author: yuanrui
 * @email: xdyrfree@gmail.com
 * @date: 2023/8/29-18:15
 */
public class MaximumSum {

    public static void main(String[] args) {

        int[] nums = new int[]{229,398,269,317,420,464,491,218,439,153,482,169,411,93,147,50,347,210,251,366,401};
        System.out.println(maximumSum(nums));
    }

    public static int maximumSum(int[] nums) {
        int res = -1;
        if (nums.length == 1)
            return res;

        //构造HashMap，所有数位和相同的放一起
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            int digitSum = digitSum(nums[i]);
            int[] ints = map.get(digitSum);
            if (ints == null) {
                ints = new int[2];
                ints[0] = nums[i];
                map.put(digitSum, ints);
            } else {
                if (nums[i] >= ints[0]) {
                    ints[1] = ints[0];
                    ints[0] = nums[i];
                } else if (nums[i] > ints[1]) {
                    ints[1] = nums[i];
                }
            }
        }

        for (int[] value : map.values()) {
            if (value[1] == 0)
                continue;
            res = Math.max(res, value[0] + value[1]);
        }

        return res;
    }

    private static int digitSum(int n) {
        int res = 0;
        for (char c : String.valueOf(n).toCharArray()) {
            res += c - '0';
        }
        return res;
    }
}
