package com.yuanrui.leetcode;

/**
 * 2240. 买钢笔和铅笔的方案数
 * @author: yuanrui
 */
public class WaysToBuyPensPencils {

    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        if (cost2 < cost1)
            return waysToBuyPensPencils(total, cost2, cost1);

        long res = 0;
        int cnt = 0;
        while(cost1*cnt <= total) {
            res += (total - cost1*cnt)/cost2 + 1;
            cnt++;
        }
        return res;
    }
}
