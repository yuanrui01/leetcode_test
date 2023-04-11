package com.yuanrui.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/4/11-20:50
 */
public class IntervalIntersection {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if (firstList.length == 0 || secondList.length == 0)
            return new int[0][];

        //两个区间列表都有值
        int i = 0;
        int j = 0;
        List<int[]> ans = new ArrayList<>();
        while(i != firstList.length && j != secondList.length){
            if (!(firstList[i][0] > secondList[j][1] || secondList[j][0] > firstList[i][1]))
                ans.add(new int[]{Math.max(firstList[i][0], secondList[j][0]), Math.min(firstList[i][1], secondList[j][1])});
            //不同区间进行比较，小的那个+1
            if (firstList[i][1] > secondList[j][1])
                j++;
            else
                i++;
        }

        return ans.toArray(new int[ans.size()][]);
    }
}
