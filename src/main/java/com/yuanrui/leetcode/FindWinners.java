package com.yuanrui.leetcode;

import java.util.*;

/**
 * 2225. 找出输掉零场或一场比赛的玩家
 */
public class FindWinners {

    public static void main(String[] args) {
        int[][] matches = {{1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9}};
        System.out.println(findWinners(matches));
    }

    public static List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> winMap = new LinkedHashMap<>();
        Map<Integer, Integer> loseMap = new LinkedHashMap<>();
        List<List<Integer>> ans = new ArrayList<>();

        for (int[] match : matches) {
            int winner = match[0];
            int loser = match[1];
            winMap.merge(winner, 1, Integer::sum);
            loseMap.merge(loser, 1, Integer::sum);
        }

        List<Integer> winList = new ArrayList<>();
        for (Integer i : winMap.keySet()) {
            if (loseMap.containsKey(i))
                continue;
            winList.add(i);
        }
        Collections.sort(winList);

        List<Integer> loseList = new ArrayList<>();
        for (Integer i : loseMap.keySet()) {
            if (loseMap.get(i) == 1)
                loseList.add(i);
        }
        Collections.sort(loseList);

        ans.add(winList);
        ans.add(loseList);

        return ans;
    }
}
