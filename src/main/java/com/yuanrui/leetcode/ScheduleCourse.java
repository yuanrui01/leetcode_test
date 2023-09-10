package com.yuanrui.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 630. 课程表 III
 * @author: yuanrui
 */
public class ScheduleCourse {
    int[][] courses;
    int[][] cache;

    public int scheduleCourse(int[][] courses) {
        int len = courses.length;
        cache = new int[courses.length][10000];
        Arrays.sort(courses, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        for (int[] ints : cache) {
            Arrays.fill(ints,-1);
        }

        this.courses = courses;
        return dp(len - 1, courses[len - 1][1]);
    }

    /**
     * 在给定剩余时间内，能从（1，idx）中最多选择多少门课程
     * @param idx
     * @return
     */
    private int dp(int idx, int endTime) {
        if (idx == 0) {
            if (endTime >= courses[0][0])
                return 1;
            else
                return 0;
        }
        if (cache[idx][endTime] != -1)
            return cache[idx][endTime];
        // 没时间选了
        if (courses[idx][0] > endTime) {
            return cache[idx][endTime] = dp(idx-1, Math.min(endTime, courses[idx-1][1]));
        }
        int beginTime = endTime - courses[idx][0];
        // 可以选，也可以不选，返回选或不选的最大值
        return cache[idx][endTime] = Math.max(dp(idx-1, Math.min(beginTime, courses[idx - 1][1])) + 1,
                dp(idx-1, Math.min(endTime, courses[idx-1][1])));
    }


    public static void main(String[] args) {
//        int[][] courses = {{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}};
        int[][] courses = {{7,16},{2,3},{3,12},{3,14},{10,19},{10,16},{6,8},{6,11},{3,13},{6,16}};
        int[][] courses1 = {{1, 2}};
        int[][] courses2 = {{3,2}, {4,3}};
        int[][] courses3 = {{5,5}, {4,6},{2,6}};
//        Arrays.sort(courses, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[1] - o2[1];
//            }
//        });

        ScheduleCourse scheduleCourse = new ScheduleCourse();

        System.out.println(scheduleCourse.scheduleCourse(courses));
//        System.out.println(scheduleCourse.scheduleCourse(courses1));
//        System.out.println(scheduleCourse.scheduleCourse(courses2));
    }
}
