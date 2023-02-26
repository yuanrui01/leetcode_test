package com.yuanrui.leetcode;

import java.util.Random;

/**
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/2/26-14:14
 */
public class Rod {

    public int rob(int[] nums) {
        //边界条件判断
        if (nums == null || nums.length == 0)
            return 0;
        int length = nums.length;
        int dp0 = 0;//第1家没偷
        int dp1 = nums[0];//第1家偷了
        //从第2个开始判断
        for (int i = 1; i < length; i++) {
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


    public int rob2(int[] nums) {
        //边界条件判断
        if (nums == null || nums.length == 0)
            return 0;
        int length = nums.length;
        int[][] dp = new int[length][2];
        dp[0][0] = 0;//第1家没偷
        dp[0][1] = nums[0];//第1家偷了
        //从第2个开始判断
        for (int i = 1; i < length; i++) {
            //下面两行是递推公式
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        //最后取最大值即可
        return Math.max(dp[length - 1][0], dp[length - 1][1]);
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int min = prices[0];
        for(int i = 1; i < prices.length; ++i){
            min = Math.min(min,prices[i]);
            maxProfit = Math.max(prices[i] - min,maxProfit);
        }
        return maxProfit;
    }

    public class Solution {
        private int[] nums;
        private Random random;

        public Solution(int[] nums) {
            this.nums = nums;
            random = new Random();
        }

        //重置数组，就是返回之前的数组
        public int[] reset() {
            return nums;
        }


        //打乱数组
        public int[] shuffle() {
            if (nums == null)
                return null;
            int[] a = nums.clone();//clone一个新的数组
            for (int j = 1; j < a.length; j++) {
                int i = random.nextInt(j + 1);
                swap(a, i, j);
            }
            return a;
        }

        //交换两个数字的值
//        private void swap(int[] a, int i, int j) {
//            if (i != j) {
//                a[i] ^= a[j];
//                a[j] ^= a[i];
//                a[i] ^= a[j];
//            }
//        }

        private void swap(int[] a, int i, int j) {
            if (i != j) {
                a[i] = a[i] + a[j];
                a[j] = a[i] - a[j];
                a[i] = a[i] - a[j];
            }
        }
    }
}
