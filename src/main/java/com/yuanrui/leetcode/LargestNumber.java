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
        System.out.println(solution(nums));
    }

    public static String solution(int[] nums) {
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
        return sb.toString();
    }

    private static boolean bigger(int i, int j) {
        if (i == j) {
            return false;
        }
        int originalI = i;
        int originalJ = j;

        while(i!=0&&j!=0) {
            int firstI = getFirstDigit(i);
            int firstJ = getFirstDigit(j);

            if (firstI > firstJ) {
                return true;
            } else if (firstI < firstJ) {
                return false;
            } else {
                int nextI = i/10;
                int nextJ = j/10;
                if (nextI == 0 && nextJ != 0) {
                    return i*10+firstI > j ;
                } else if (nextJ == 0 && nextI != 0) {
                    return  i > j*10+firstI;
                } else {
                    return bigger(nextI, nextJ);
                }
            }
        }
    }

    private static int getFirstDigit(int num) {
        while(num/10 != 0){
            num/=10;
        }
        return num;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
