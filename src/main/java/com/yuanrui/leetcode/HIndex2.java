package com.yuanrui.leetcode;

public class HIndex2 {

    public int hIndex(int[] citations) {
        int size = citations.length;
        int left = 0;
        int right = citations.length - 1;
        if (citations[0] >= size)
            return size;

        while(left < right) {
            int middle = (left + right) >>> 1;
            if ((size - middle) < citations[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return left == 0 ? 0 : Math.min(left, citations[left - 1]);
    }

    public static void main(String[] args) {
        HIndex2 hIndex2 = new HIndex2();
        int[] citations = {1,1,3};
        System.out.println(hIndex2.hIndex(citations));
    }
}
