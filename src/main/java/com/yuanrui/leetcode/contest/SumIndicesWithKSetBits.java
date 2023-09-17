package com.yuanrui.leetcode.contest;

import java.util.List;

/**
 * @author: yuanrui
 */
public class SumIndicesWithKSetBits {

    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int ans = 0;

        for (int i = 0; i < nums.size(); i++) {
            if (countOnesInBinary(i) == k)
                ans += nums.get(i);
        }
        return ans;
    }

    public int countOnesInBinary(int num) {
        int count = 0;
        while (num != 0) {
            count += num & 1; // 判断最低位是否为1
            num >>>= 1; // 右移一位
        }
        return count;
    }

    public static void main(String[] args) {

        List<Integer> list = List.of(4,3,2,1);
        SumIndicesWithKSetBits sumIndicesWithKSetBits = new SumIndicesWithKSetBits();

        System.out.println(sumIndicesWithKSetBits.sumIndicesWithKSetBits(list,2));
    }
}
