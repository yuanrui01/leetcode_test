package com.yuanrui.leetcode.contest;

import java.util.List;

/**
 * @author: yuanrui
 */
public class CountPairs {

    public int countPairs(List<List<Integer>> coordinates, int k) {
        int ans = 0;

        for (int i = 0; i < coordinates.size(); ++i) {
            for (int j = i+1; j < coordinates.size(); ++j) {
                if ((coordinates.get(i).get(0) ^ coordinates.get(j).get(0)) + (coordinates.get(i).get(1) ^ coordinates.get(j).get(1)) == k)
                    ans++;
            }
        }

        return ans;
    }
}
