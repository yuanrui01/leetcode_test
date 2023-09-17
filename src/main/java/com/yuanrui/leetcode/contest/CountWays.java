package com.yuanrui.leetcode.contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 100040. Happy Students
 * @author: yuanrui
 */
public class CountWays {

    private int ans;
    private int checkNum;
    public int countWays(List<Integer> nums) {
        ans = 0;
        checkNum = 0;
        generateCombinations(nums);
        return ans;
    }

    private void dp(List<Integer> nums, int k) {

    }

    private void generate(List<Integer> nums, int index, int[] current) {
        if (index == nums.size()) {
            if (checkPermutation(nums, current))
                ans++;
            return;
        }

        // 不选择当前数字
        if (checkNum < nums.get(index)) {
            current[index] = 0;
            generate(nums, index + 1, current);
            current[index] = 0;
        }

        // 选择当前数字
        if (nums.get(index) < (checkNum + nums.size() - index)) {
            current[index] = 1;
            checkNum++;
            generate(nums, index + 1, current);
            current[index] = 0;
            checkNum--;
        }
    }
    public void generateCombinations(List<Integer> nums) {
        int[] current = new int[nums.size()];
        generate(nums, 0, current);
    }

    private boolean checkPermutation(List<Integer> nums, int[] current) {
        for (int i = 0;i < current.length; ++i) {
            if ((current[i] == 0 && checkNum >= nums.get(i)) || (current[i] == 1 && checkNum <= nums.get(i)))
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        CountWays countWays = new CountWays();
        System.out.println(countWays.countWays(List.of(6,0,3,3,6,7,2,7)));
    }

}
