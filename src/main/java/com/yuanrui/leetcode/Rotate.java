package com.yuanrui.leetcode;

public class Rotate {

    public void rotate(int[] nums, int k) {
        int[] temp = nums.clone();
        int length = nums.length;
        k = k%length;

        for(int i = 0; i < length; ++i){
            temp[(i+k)%length] = nums[i];
        }

        for(int i = 0; i < length; ++i){
            nums[i] = temp[i];
        }
    }
}
