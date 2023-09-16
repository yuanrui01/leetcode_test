package com.yuanrui.leetcode.contest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yuanrui
 */
public class E20230916 {


    public static void main(String[] args) {

        E20230916 e20230916 = new E20230916();
        int[] nums = {1,3,5};
        // [63,51,65,87,6,17,32,14,42,46]
        List<Integer> ilist = List.of(63,51,65,87,6,17,32,14,42,46);

        System.out.println(e20230916.minimumRightShifts(ilist));
    }

    public int findMinIdx(int[] nums) {
        int left = -1, right = nums.length - 1, len = nums.length; // 开区间 (-1, n-1)
        while (left + 1 < right) { // 开区间不为空
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[len - 1]) right = mid; // 蓝色
            else left = mid; // 红色
        }

        return right;
    }

    public int minimumRightShifts(List<Integer> nums) {
        int size = nums.size();
        if (size == 1)
            return 0;
        int min = 101;
        int minIdx = 0;
        for (int i = 0; i < size; ++i)
            if (min > nums.get(i)) {
                minIdx = i;
                min = nums.get(i);
            }
        int k = 0;
        while (k < size - 1) {
            if (nums.get((minIdx + k) % size) > nums.get((minIdx + k + 1) % size))
                return -1;
            k++;
        }
        if (minIdx == 0)
            return 0;
        else
            return size - minIdx;
    }
}
