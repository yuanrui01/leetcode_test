package com.yuanrui.leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * 1313. 解压缩编码列表
 */
public class DecompressRLElist {

    public int[] decompressRLElist(int[] nums) {
        List<Integer> ilist = new ArrayList<>();
        for (int i = 0; i < nums.length; i+=2) {
            int times = nums[i];
            while (times-- > 0)
                ilist.add(nums[i+1]);
        }

        return ilist.stream().mapToInt(i->i).toArray();
    }
}
