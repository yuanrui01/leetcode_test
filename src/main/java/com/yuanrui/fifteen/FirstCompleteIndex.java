package com.yuanrui.fifteen;

import java.util.HashMap;
import java.util.Map;

public class FirstCompleteIndex {

    private static class MPoint {
        int x;
        int y;

        MPoint(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int ans = -1;
        int m = mat.length;
        int n = mat[0].length;
        int[] mCount = new int[100001];
        int[] nCount = new int[100001];

        // 维护元素到坐标的集合
        Map<Integer, MPoint> map = new HashMap<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                map.put(mat[i][j], new MPoint(i,j));
            }
        }

        for (int i = 0; i < arr.length; ++i) {
            MPoint mPoint = map.get(arr[i]);
            if (++mCount[mPoint.y] >= m) {
                ans = i;
                break;
            }
            if (++nCount[mPoint.x] >= n) {
                ans = i;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        FirstCompleteIndex firstCompleteIndex = new FirstCompleteIndex();
        int[] arr = {1,4,5,2,6,3};
        int[][] mat = {{4,3,5},{1,2,6}};
        System.out.println(firstCompleteIndex.firstCompleteIndex(arr, mat));
    }
}
