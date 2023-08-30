package com.yuanrui.leetcode;

/**
 * 同向双指针例题：209. 长度最小的子数组
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/3/12-0:27
 */
public class MinSubArrayLen {

    public int minSubArrayLen(int target, int[] nums) {
        int right = 0;
        int ans = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for(right = 0; right < nums.length; ++right){
            sum += nums[right];
            while(sum > target){
                ans = Math.min(ans, right - left + 1);
                sum -= nums[left++];
            }
            // 如果有答案，1就是最小的
            if (ans == 1)
                return ans;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
