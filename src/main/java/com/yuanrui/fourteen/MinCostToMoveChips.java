package com.yuanrui.fourteen;

/**
 * 1217. 玩筹码
 * @author: yuanrui
 */
public class MinCostToMoveChips {

    public int minCostToMoveChips(int[] position) {
        int evenCount = 0;
        int oddCount = 0;
        for (int j : position)
            if (j % 2 == 0)
                evenCount++;
            else
                oddCount++;
        return evenCount == 0 || oddCount == 0 ? 0 : Math.min(oddCount, evenCount);
    }
}
