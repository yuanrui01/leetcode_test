package com.yuanrui.leetcode;


import java.util.*;

/**
 * 1462. 课程表 IV
 */
public class CheckIfPrerequisite {

    Map<Integer, Set<Integer>> map;

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Boolean> ans = new ArrayList<>();
        // 有啥思路。。
        // 蛋疼，老感觉要卡我TLE
        map = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            if (map.get(prerequisite[0]) == null) {
                Set<Integer> set = new HashSet<>();
                set.add(prerequisite[1]);
                map.put(prerequisite[0], set);
            } else {
                map.get(prerequisite[0]).add(prerequisite[1]);
            }
        }
        // 提前处理下，把依赖树展开为依赖列表
        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
            Set<Integer> value = entry.getValue();
            Set<Integer> flat = new HashSet<>();
            process(value, flat);
            entry.setValue(flat);
        }

        for (int[] query : queries) {
            int i1 = query[0];
            int i2 = query[1];
            Set<Integer> preReq = map.get(i1);
            if (preReq == null)
                ans.add(false);
            else
                ans.add(preReq.contains(i2));
        }

        return ans;
    }

    private void process(Set<Integer> set, Set<Integer> flat) {
        for (Integer i : set)
            if (map.get(i) != null)
                process(map.get(i), flat);
        flat.addAll(set);
    }


    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1,0}};
        int[][] queries = {{0,1},{1,0}};

        CheckIfPrerequisite checkIfPrerequisite = new CheckIfPrerequisite();

        System.out.println(checkIfPrerequisite.checkIfPrerequisite(numCourses, prerequisites, queries));
    }
}
