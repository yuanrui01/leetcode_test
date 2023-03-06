package com.yuanrui.leetcode;

import java.util.Arrays;

public class MinimumOperations {

    public int minimumOperations(int[] nums) {
        if(nums.length == 1){
            if (nums[0] == 0){
                return 0;
            }else{
                return 1;
            }
        }
        int nextNotZeroNum = -1;
        int count = 0;
        int accumulateMinus = 0;
        Arrays.sort(nums);
        int idx = 0;
        while(nextNotZeroNum == -1 && idx < nums.length){
            if(nums[idx] > 0){
                nextNotZeroNum = idx;
                break;
            }
            idx++;
        }
        if(idx == nums.length){
            return 0;
        }
        for(int i = nextNotZeroNum; i < nums.length; ++i){
            if((nums[i] - accumulateMinus) > 0){
                accumulateMinus = nums[i];
                count++;
            }
        }

        return count;
    }
}
