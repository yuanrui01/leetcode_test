package com.yuanrui.leetcode;

import java.util.Arrays;

/**
 * 2640. 一个数组所有前缀的分数
 * 定义一个数组 arr 的 转换数组 conver 为：
 * conver[i] = arr[i] + max(arr[0..i])，其中 max(arr[0..i]) 是满足 0 <= j <= i 的所有 arr[j] 中的最大值。
 * 定义一个数组 arr 的 分数 为 arr 转换数组中所有元素的和。
 * 给你一个下标从 0 开始长度为 n 的整数数组 nums ，请你返回一个长度为 n 的数组 ans ，其中 ans[i]是前缀 nums[0..i] 的分数。
 */
public class FindPrefixScore {


    public static void main(String[] args) {
        int[] nums = new int[]{2,3,7,5,10};
        System.out.println(Arrays.toString(findPrefixScore(nums)));
    }

    /**
     * 输入：nums = [2,3,7,5,10]
     * 输出：[4,10,24,36,56]
     * @param nums balabla
     */
    public static long[] findPrefixScore(int[] nums) {
        if(nums.length == 1)
            return new long[]{(long)nums[0]*nums[0]};

        //long[] cover = new long[nums.length];
        long[] ans = new long[nums.length];
        int preMax = -1;
        long preVal = 0;

        for (int i = 0; i < nums.length; ++i) {
            preMax = Math.max(nums[i], preMax);
            ans[i] = nums[i] + preMax + preVal;
            preVal = ans[i];
        }

        return ans;
    }
}
