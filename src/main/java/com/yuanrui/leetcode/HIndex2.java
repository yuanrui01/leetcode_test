package com.yuanrui.leetcode;

public class HIndex2 {

    public int hIndex(int[] citations) {
        int size = citations.length;
        int left = 0;
        int right = citations.length - 2;
        // 理解为求极大值点即可 --- Math.min(size - middle, citations[middle])
        while(left <= right) {
            int middle = (left + right) / 2;
            int middleH = Math.min(size - middle, citations[middle]);
            int middlePlusH = Math.min(size - middle - 1, citations[middle + 1]);
            if (middleH <= middlePlusH) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        int lastHIndex = Math.min(1, citations[size - 1]);
        int hIndex = Math.min(size - left, citations[left]);
        return Math.max(hIndex, lastHIndex);
    }

    public static void main(String[] args) {
        HIndex2 hIndex2 = new HIndex2();
        int[] citations = {0,1,3,5,6};
        System.out.println(hIndex2.hIndex(citations));
    }
}
