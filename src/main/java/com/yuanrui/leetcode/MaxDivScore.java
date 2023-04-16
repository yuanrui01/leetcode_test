package com.yuanrui.leetcode;

/**
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/4/16-10:41
 */
public class MaxDivScore {


/*    [4,7,9,3,9]
            [5,2,3]*/
    public static void main(String[] args) {
        int[] nums = {4,7,9,3,9};
        int[] divisors = {5,2,3};
        System.out.println(maxDivScore(nums, divisors));
    }

    public static int maxDivScore(int[] nums, int[] divisors) {
        int minDivisors = Integer.MAX_VALUE;
        int nums_length = nums.length;
        int divisors_length = divisors.length;
        int maxCnt = -1;

        for(int j = 0; j < divisors_length; ++j){
            int cnt = 0;
            for(int i = 0; i < nums_length; ++i){
                if(isDivided(nums[i], divisors[j]))
                    cnt++;
            }

            if(cnt >= maxCnt){
                if((cnt > maxCnt) || (cnt == maxCnt && divisors[j] < minDivisors)){
                    minDivisors = divisors[j];
                }
                maxCnt = cnt;
            }
        }

        return minDivisors;
    }

    private static boolean isDivided(int dividend, int divisor){
        return dividend % divisor == 0;
    }
}
