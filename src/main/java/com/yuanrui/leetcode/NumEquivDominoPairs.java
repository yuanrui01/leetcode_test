package com.yuanrui.leetcode;

/**
 * @author: yuanrui
 */
public class NumEquivDominoPairs {

    public static void main(String[] args) {
        int[][] dominoes = {{1,2},{1,2},{1,1},{1,2},{2,2}};
        System.out.println(numEquivDominoPairs(dominoes));
    }

    public static int numEquivDominoPairs(int[][] dominoes) {
        int ans = 0;
        int[][] count = new int[10][10];
        boolean[][] isCal = new boolean[10][10];
        for (int[] dominoe : dominoes) {
            count[dominoe[0]][dominoe[1]]++;
        }
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 10; ++j)
                if (!isCal[i][j]) {
                    int n = count[i][j];
                    if (i != j)
                        n += count[j][i];
                    if (n >= 2)
                        ans += n*(n-1)/2;
                    isCal[j][i]=true;
                }
        return ans;
    }

    private static boolean isEqual(int[] a, int[] b) {
        if ((a[0] == b[0] && a[1] == b[1]) || (a[0] == b[1] && a[1] == b[0]))
            return true;
        else
            return false;
    }
}
