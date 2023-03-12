package com.yuanrui.leetcode;

/**
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/3/12-1:54
 */
public class NumSubarrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1){
            return 0;
        }
        int ans = 0;
        int prod = 1;
        int left = 0;

        for(int i = 0; i < nums.length; ++i){
            prod *= nums[i];

            while(prod < k){
                ans++;
                prod /= nums[left++];
            }
        }
        return ans;
    }
}
