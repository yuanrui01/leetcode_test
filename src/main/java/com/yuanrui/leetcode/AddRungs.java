package com.yuanrui.leetcode;

/**
 * 1936. 新增的最少台阶数
 * @author: yuanrui
 */
public class AddRungs {

    public static void main(String[] args) {
        int[] rungs = {3,6,8,10};
        int dist = 3;
        System.out.println(addRungs(rungs, dist));
    }
    public static int addRungs(int[] rungs, int dist) {
        int ans = 0;
        for (int i = 1; i < rungs.length; ++i) {
            int diff = rungs[i] - rungs[i-1];
            ans += (dist >= diff) ? 0 : (diff % dist == 0 ? diff / dist - 1 : diff / dist);
        }
        ans += (dist >= rungs[0]) ? 0 : (rungs[0] % dist == 0 ? rungs[0] / dist - 1 : rungs[0] / dist);
        return ans;
    }
}
