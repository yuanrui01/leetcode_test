package com.yuanrui.leetcode.contest;

public class MaximumTripletValue {

    public long maximumTripletValue(int[] nums) {
        long ans = 0;
        int maxProct = 0;
        int preMax = nums[0];

        for (int i = 1; i < nums.length - 1; ++i) {
            // 处理i位置的值，拿num[i]
            maxProct = Math.max(maxProct, (preMax - nums[i]));
            ans  = Math.max(ans, (long)nums[i+1] * maxProct);
            if (nums[i] > preMax)
                preMax = nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1000000,1,1000000};
        MaximumTripletValue maximumTripletValue = new MaximumTripletValue();
        System.out.println(maximumTripletValue.maximumTripletValue(nums));
    }
}
