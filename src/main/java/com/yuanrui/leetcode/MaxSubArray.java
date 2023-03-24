package com.yuanrui.leetcode;

/**
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/3/25-0:17
 */
public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int temp = 0;
        for (int num : nums) {
            temp += num;
            ans = Math.max(ans, temp);
            if(temp < 0){
                temp = 0;
            }
        }
        return ans;
    }
}
