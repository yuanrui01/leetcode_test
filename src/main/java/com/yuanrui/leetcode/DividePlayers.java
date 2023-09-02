package com.yuanrui.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2491. 划分技能点相等的团队
 * @author: yuanrui
 */
public class DividePlayers {

    public long dividePlayers(int[] skill) {
        long ans = 0L;
        int len = skill.length;
        int k = len / 2;
        Arrays.sort(skill);

        List<int[]> ill = new ArrayList<>();
        int partSum = skill[0] + skill[len - 1];

        for (int i = 0; i < k; ++i)
            if (partSum != (skill[i] + skill[len - i -1]))
                return -1;
            else
                ill.add(new int[]{skill[i], skill[len - i -1]});

        for (int[] ints : ill)
            ans += (long) ints[0]*ints[1];
        return ans;
    }
}
