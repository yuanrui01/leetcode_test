package com.yuanrui;

/**
 * 1672. 最富有客户的资产总量
 */
public class MaximumWealth {

    public int maximumWealth(int[][] accounts) {
        int richest = 0;
        int maximumWealth = 0;
        int m = accounts.length;
        int n = accounts[0].length;

        for(int i = 0; i < m; ++i) {
            int dogMoney = 0;
            for(int j = 0; j < n; ++j) {
                dogMoney += accounts[i][j];
            }
            if (dogMoney > maximumWealth) {
                maximumWealth = dogMoney;
                richest = i;
            }
        }

        return maximumWealth;
    }
}
