package com.yuanrui.leetcode;


/**
 * 2657. 找到两个数组的前缀公共数组
 * 给你两个下标从 0 开始长度为 n 的整数排列 A 和 B 。
 * A 和 B 的 前缀公共数组 定义为数组 C ，其中 C[i] 是数组 A 和 B 到下标为 i 之前公共元素的数目。
 * 请你返回 A 和 B 的 前缀公共数组 。
 * 如果一个长度为 n 的数组包含 1 到 n 的元素恰好一次，我们称这个数组是一个长度为 n 的 排列 。
 */
public class FindThePrefixCommonArray {

    public static void main(String[] args) {
        int[] A = new int[]{1,3,2,4};
        int[] B = new int[]{3,1,2,4};
        findThePrefixCommonArray(A, B);
    }


    /**
     * 输入：A = [1,3,2,4], B = [3,1,2,4]
     * 输出：[0,2,3,4]
     * 解释：i = 0：没有公共元素，所以 C[0] = 0 。
     * i = 1：1 和 3 是两个数组的前缀公共元素，所以 C[1] = 2 。
     * i = 2：1，2 和 3 是两个数组的前缀公共元素，所以 C[2] = 3 。
     * i = 3：1，2，3 和 4 是两个数组的前缀公共元素，所以 C[3] = 4
     * @param A
     * @param B
     * @return
     */
    public static int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] C = new int[n];
        if (n == 1) {
            C[0] = 1;
            return C;
        }
        int[] flagCount = new int[n + 1];

        int cValue = 0;
        for (int i = 0; i < n; ++i) {
            if (A[i] == B[i]) {
                cValue++;
            } else {
                flagCount[A[i]]++;
                flagCount[B[i]]++;
                if (flagCount[A[i]] == 2)
                    cValue++;
                if (flagCount[B[i]] == 2)
                    cValue++;
            }
            C[i] = cValue;
        }
        return C;
    }
}
