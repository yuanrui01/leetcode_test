package com.yuanrui.leetcode;

/**
 * 213. 打家劫舍 II
 * @author: yuanrui
 */
public class Rob2 {

    public int rob(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        if(nums.length == 2)
            return Math.max(nums[0], nums[1]);
        return Math.max(dp(nums, 1, nums.length - 1), dp(nums, 2, nums.length - 2) + nums[0]);
    }

    public int dp(int[] nums, int left, int right) {
        if (left > right)
            return 0;
        int dp0 = 0;//第1家没偷
        int dp1 = nums[left];//第1家偷了
        //从第2个开始判断
        for (int i = left+1; i <= right; i++) {
            //防止dp0被修改之后对下面运算造成影响，这里
            //使用一个临时变量temp先把结果存起来，计算完
            //之后再赋值给dp0.
            int temp = Math.max(dp0, dp1);
            dp1 = dp0 + nums[i];
            dp0 = temp;
        }
        //最后取最大值即可
        return Math.max(dp0, dp1);
    }
}
