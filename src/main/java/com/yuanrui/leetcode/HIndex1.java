package com.yuanrui.leetcode;

/**
 * 274. H 指数
 */
public class HIndex1 {

    public int hIndex(int[] citations) {
        int[] count = new int[1001];
        int cum = 0;
        for (int citation : citations)
            count[citation]++;
        for (int i = 1000; i >= 0; --i)
            if ((cum += count[i]) >= i)
                return i;
        return 0;
    }

    public static void main(String[] args) {
        HIndex1 hIndex1 = new HIndex1();
        int[] citation = {1,3,1};
        System.out.println(hIndex1.hIndex(citation));
    }
}
