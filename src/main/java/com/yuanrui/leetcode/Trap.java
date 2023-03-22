package com.yuanrui.leetcode;

/**
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/3/21-22:43
 */
public class Trap {

    public static void main(String[] args) {
        trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
    }

    /**
     * 接雨水
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        int ans = 0;
        int length = height.length;
        if(length == 1){
            return ans;
        }
        //整三个数组，
        //一个左挡板
        int[] leftGuard = new int[length];
        //一个右挡板
        int[] rightGuard = new int[length];
        //一个地板高度即height

        for(int i = 1; i < length; ++i){
            leftGuard[i] = Math.max(leftGuard[i-1],height[i-1]);
        }

        for(int i = length - 2; i >= 0; --i){
            rightGuard[i] = Math.max(rightGuard[i+1],height[i+1]);
        }

        for(int i = 0; i < length; ++i){
            int floor = height[i];
            int maxGuard = Math.max(leftGuard[i],rightGuard[i]);

            if(maxGuard <= floor){
                continue;
            }else{
                ans += maxGuard - floor;
            }
        }

        return ans;
    }
}
