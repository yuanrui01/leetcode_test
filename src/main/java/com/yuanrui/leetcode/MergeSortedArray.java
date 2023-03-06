package com.yuanrui.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSortedArray {

    public static void main(String[] args) {
        int[] num1 = {1,2,3,0,0,0};
        int[] num2 = {2,5,6};
        merge(num1,3,num2,3);

        System.out.println(Arrays.toString(num1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n){
        if(m==0&&n==0)
            return;
        int i = 0;
        int j = 0;
        int k = 0;
        int[] numsk = new int[m+n];
        List<Integer> il = new ArrayList<>();
        while(i != m && j != n){
            if(nums1[i] < nums2[j]){
                numsk[k++] = nums1[i++];
            }else{
                numsk[k++] = nums2[j++];
            }
        }
        while (i!=m)
            numsk[k++] = nums1[i++];
        while (j!=n)
            numsk[k++] = nums2[j++];

        for(int x = 0; x < m+n; ++x){
            nums1[x] = numsk[x];
        }
    }
}
