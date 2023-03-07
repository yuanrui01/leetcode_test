package com.yuanrui.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SubSets {
    private final List<List<Integer>> ans = new ArrayList<>();
    private final List<Integer> path = new ArrayList<>();
    private int nums[];

    public List<List<Integer>> subsets(int[] nums) {
        int length = nums.length;
        if (length == 0){
            return ans;
        }else{
            this.nums = nums;
            dfs(0);
            return ans;
        }
    }
    private void dfs(int n){
        if(n == nums.length){
            ans.add(new ArrayList<>(path));
            return;
        }
        //不取第n个
        dfs(n+1);
        //取第n个
        path.add(nums[n]);
        dfs(n+1);
        path.remove(path.size() - 1);
    }
}
