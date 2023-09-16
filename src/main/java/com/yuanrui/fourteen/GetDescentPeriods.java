package com.yuanrui.fourteen;

/**
 * 2110. Number of Smooth Descent Periods of a Stock
 * @author: yuanrui
 */
public class GetDescentPeriods {

    public long getDescentPeriods(int[] prices) {
        long ans = 1L;
        long contiguous = 1L;
        for(int i = 1; i < prices.length; ++i) {
            if (prices[i-1] - prices[i] == 1)
                contiguous += 1;
            else
                contiguous = 1;
            ans += contiguous;
        }
        return ans;
    }

    public static void main(String[] args) {
        GetDescentPeriods getDescentPeriods = new GetDescentPeriods();
        int[] prices = {3,2,1,4};
        System.out.println(getDescentPeriods.getDescentPeriods(prices));
    }

}
