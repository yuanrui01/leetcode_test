package com.yuanrui.leetcode;

/**
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/3/21-13:20
 */
public class MaxArea {

    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while(left < right){
            int hg = Math.max(height[left], height[right]);

            maxArea = Math.max(maxArea,hg * (right - left));
            if(height[left] >= height[right]){
                right--;
            }else{
                left++;
            }
        }

        return maxArea;
    }
}
