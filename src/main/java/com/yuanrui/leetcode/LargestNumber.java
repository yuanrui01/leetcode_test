package com.yuanrui.leetcode;

/**
 * @description:
 * @author: yuanrui
 * @email: xdyrfree@gmail.com
 * @date: 2023/7/21-21:45
 */
public class LargestNumber {

    public static void main(String[] args) {

        int[] nums  = {10,2};
        //System.out.println(solution(nums));
    }

    public String solution(int[] nums) {
        if (nums.length == 1) {
            return Integer.toString(nums[0]);
        }
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < nums.length - 1; ++j) {
            int maxIdx = j;
            for (int i = j + 1; i < nums.length; ++i) {
                if (bigger(nums[i], nums[maxIdx])) {
                    maxIdx = i;
                }
            }
            sb.append(nums[maxIdx]);
            swap(nums, maxIdx, j);
        }
        sb.append(nums[nums.length - 1]);
        String result = sb.toString();

        if (result.charAt(0) == '0') {
            return "0";
        } else {
            return result;
        }
    }

    private boolean bigger(int i, int j) {
        if (i == j) {
            return false;
        }
        int firstI = getFirstDigit(i);
        int firstJ = getFirstDigit(j);
        if (firstI > firstJ) {
            return true;
        } else if (firstI < firstJ) {
            return false;
        } else {
            String one  = String.valueOf(i);
            String two = String.valueOf(j);
            return (one + two).compareTo(two + one)  > 0;
        }
    }

    private int getFirstDigit(int num) {
        while(num/10 != 0){
            num/=10;
        }
        return num;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
