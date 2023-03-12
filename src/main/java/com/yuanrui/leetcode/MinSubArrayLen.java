package com.yuanrui.leetcode;

/**
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/3/12-0:27
 */
public class MinSubArrayLen {

    public int minSubArrayLen(int target, int[] nums) {
        int length = nums.length;
        int right = 0;
        int ans = 1000001;
        int left = 0;
        int sum = 0;
        for(right = 0; right < length; ++right){
            sum += nums[right];

            while(sum > target){
                ans = Math.min(ans, right - left + 1);
                sum -= nums[left++];
            }
        }
        return ans == 1000001 ? 0 : ans;
    }
}
