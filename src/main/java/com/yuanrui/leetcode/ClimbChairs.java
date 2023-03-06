package com.yuanrui.leetcode;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class ClimbChairs {
    private static final int SIZE = 46;
    public static Map<Integer,Integer> resultCache = new HashMap<>();
    public static void main(String[] args) {

    }
    public static int climbStairs(int n) {
        if(n == 1){
            return 1;
        }else if(n == 2){
            return 2;
        }else{
            int i = 0;
            int k = 0;
            if(resultCache.get(n-1) != null){
                i = resultCache.get(n-1);
            }else{
                i = climbStairs(n-1);
            }

            if(resultCache.get(n-2) != null){
                k = resultCache.get(n-2);
            }else{
                k = climbStairs(n-2);
            }
            return i + k;
        }
    }

    public int maxProfit(int[] prices) {
        if(prices.length == 1){
            return 0;
        }
        boolean flag = false;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length - 1; ++i){
            if(prices[i] < prices[i+1]){
                flag = true;
                if(min > prices[i])
                    min = prices[i];
                if(max < prices[i+1]){
                    max = prices[i+1];
                }
            }
        }

        return flag ? max - min : 0;
    }
}
