package com.yuanrui.leetcode;

public class SingleNonDuplicate {


    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 2;
        while (left <= right) {
            int middle = (left + right) >>> 1;
            if ((middle % 2 == 0 && nums[middle] == nums[middle + 1])
                    || (middle % 2 != 0 && nums[middle] != nums[middle + 1]))
                left = middle + 1;
            else
                right = middle - 1;
        }
        return nums[left];
    }


    public static void main(String[] args) {
        int[] nums = {0,1,1,2,2,5,5};
        SingleNonDuplicate singleNonDuplicate = new SingleNonDuplicate();
        System.out.println(singleNonDuplicate.singleNonDuplicate(nums));
    }
}
