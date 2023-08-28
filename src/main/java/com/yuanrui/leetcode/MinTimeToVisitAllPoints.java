package com.yuanrui.leetcode;

/**
 * 1266. 访问所有点的最小时间
 */
public class MinTimeToVisitAllPoints {

    public static void main(String[] args) {
        int[][] points = new int[][]{{1,1},{3,4},{-1,0}};
        int[][] points2 = new int[][]{{3,2}, {-2,2}};
        System.out.println(minTimeToVisitAllPoints(points));
        System.out.println(minTimeToVisitAllPoints(points2));
    }

    /**
     * 输入：points = [[1,1],[3,4],[-1,0]]
     * 输出：7
     * 解释：一条最佳的访问路径是： [1,1] -> [2,2] -> [3,3] -> [3,4] -> [2,3] -> [1,2] -> [0,1] -> [-1,0]
     * 从 [1,1] 到 [3,4] 需要 3 秒
     * 从 [3,4] 到 [-1,0] 需要 4 秒
     * 一共需要 7 秒
     * @param points
     * @return
     */
    public static int minTimeToVisitAllPoints(int[][] points) {
        int res = 0;
        if (points.length == 0)
            return res;
        for (int i = 0; i < points.length - 1; ++i) {
            res += distance(points[i],points[i + 1]);
        }

        return res;
    }

    private static int distance(int[] p1, int[] p2) {
        if (p1[0] == p2[0]) {
            if (p1[1] == p2[1])
                return 0;
            else
                return Math.abs(p2[1] - p1[1]);
        } else if (p1[1] == p2[1]) {
            return Math.abs(p2[0] - p1[0]);
        } else {
            int l1 = Math.abs(p2[0] - p1[0]);
            int l2 = Math.abs(p2[1] - p1[1]);
            return Math.min(l1,l2) + Math.abs(l1 - l2);
        }
    }
}
