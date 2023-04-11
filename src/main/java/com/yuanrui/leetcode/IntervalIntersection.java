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

        List<List<Integer>> ill = new ArrayList<>();
        while(i != firstList.length && j != secondList.length){
            List<Integer> res = interval(firstList[i], secondList[j]);
            if (!res.isEmpty())
                ill.add(res);
            //不同区间进行比较，小的那个+1
            if (firstList[i][1] > secondList[j][1])
                j++;
            else
                i++;
        }

        int[][] ans = new int[ill.size()][];
        for (int k = 0; k < ill.size(); ++k){
            ans[k] = new int[]{ill.get(k).get(0), ill.get(k).get(1)};
        }
        return ans;
    }

    /**
     * 求两段区间的交集
     * @param il1
     * @param il2
     * @return
     */
    private List<Integer> interval(int[] il1, int[] il2){
        List<Integer> ans = new ArrayList<>();
        if (!(il1[0] > il2[1] || il2[0] > il1[1])){
            ans.add(Math.max(il1[0], il2[0]));
            ans.add(Math.min(il1[1], il2[1]));
        }
        return ans;
    }
}
