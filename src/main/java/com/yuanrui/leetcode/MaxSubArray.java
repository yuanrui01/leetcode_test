package com.yuanrui.leetcode;

import java.util.*;

/**
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/3/25-0:17
 */
public class MaxSubArray {

    public static void main(String[] args) {
        test();
    }

    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int temp = 0;
        for (int num : nums) {
            temp += num;
            ans = Math.max(ans, temp);
            if(temp < 0){
                temp = 0;
            }
        }
        return ans;
    }

    public static void test(){
        int[] src = new int[0];
        int[] temp = Arrays.copyOf(src, src.length);
        System.out.println(src.length);
    }


    public int[] intersect(int[] nums1, int[] nums2) {
        int[] nums2Count = new int[1001];
        List<Integer> ilst = new ArrayList<>();


        for(int i = 0; i < nums2.length; ++i){
            nums2Count[nums2[i]]++;
        }

        for(int i = 0; i < nums1.length; ++i){
            if(nums2Count[nums1[i]] > 0){
                ilst.add(nums1[i]);
                nums2Count[nums1[i]]--;
            }
        }

        return ilst.stream().mapToInt(Integer::valueOf).toArray();
    }
}
