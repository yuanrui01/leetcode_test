package com.yuanrui.leetcode;

/**
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/3/22-11:31
 */
public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        int left = -1, right = nums.length - 1; // 开区间 (-1, n-1)
        while (left + 1 < right) { // 开区间不为空
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) right = mid; // 蓝色
            else left = mid; // 红色
        }
        return right;
    }

    public int findPeakElement2(int[] nums) {
        int len = nums.length;
        if(len == 1){
            return 0;
        }else if(nums[0] > nums[1]){
            return 0;
        }else if(nums[len - 1] > nums[len - 2]){
            return len - 1;
        }else{
            int begin = 1;
            int end = len - 2;

            while(begin <= end){
                int mid = (begin + end) / 2;
                if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]){
                    return mid;
                }else if(nums[mid] < nums[mid + 1]){
                    begin = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
        }

        return -1;
    }
}
