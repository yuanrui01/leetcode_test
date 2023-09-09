package com.yuanrui.leetcode;

import java.util.*;

/**
 * 207. Course Schedule 课程表
 * @author: yuanrui
 */
public class CanFinish {

    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{2,0},{1,0},{3,1},{3,2},{1,3}};
        System.out.println(canFinish(numCourses, prerequisites));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] finish = new boolean[numCourses];
        Map<Integer,List<Integer>> map = new HashMap<>();
        Arrays.fill(finish, true);
        for (int[] prerequisite : prerequisites) {
            if (prerequisite[0] == prerequisite[1])
                return false;
            finish[prerequisite[0]] = false;
            if (map.get(prerequisite[0]) != null) {
                map.get(prerequisite[0]).add(prerequisite[1]);
            } else {
                List<Integer> required = new ArrayList<>();
                required.add(prerequisite[1]);
                map.put(prerequisite[0], required);
            }
        }

        // 先把不需要依赖的学完了，再看需要依赖的，一旦出现环路就返回false
        for (int[] prerequisite : prerequisites) {
            if (!(finish[prerequisite[0]])) {
                // 判断先修课程是否可完成，判断是否有环。。
                int lesson = prerequisite[0];
                Set<Integer> set = new HashSet<>();
                if (!checkRequisite(lesson, map, set, finish))
                    return false;
            }
        }
        return true;
    }

    /**
     * 检查依赖树
     * @return
     */
    private static boolean checkRequisite(int lesson, Map<Integer,List<Integer>> map, Set<Integer> set, boolean[] finish) {
        List<Integer> requisite = map.get(lesson);
        for (int i = 0 ; i < requisite.size(); ++i) {
            if (finish[requisite.get(i)])
                continue;
            if (set.contains(requisite.get(i))) {
                return false;
            } else {
                set.add(lesson);
                if (!checkRequisite(requisite.get(i), map, set, finish))
                    return false;
                set.remove(lesson);
            }
        }
        finish[lesson] = true;
        return true;
    }
}
