package com.yuanrui.leetcode;

import java.util.Arrays;
import java.util.Collections;

/**
 * 2587. 重排数组以得到最大前缀分数
 * @author yuanrui
 */
public class MaxScore {

    public static void main(String[] args) {
        System.out.println(maxScore(new int[]{-1}));;

    }

    public static int maxScore(int[] nums) {
        int ans = 0;

        Arrays.sort(nums);
        long sum = 0;
        for (int i = nums.length - 1; i >= 0; --i) {
            sum += nums[i];
            if (sum > 0)
                ans++;
        }
        return ans;
    }
}
