package com.yuanrui.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/3/11-22:52
 */
public class ContainsDuplicate {

    public static void main(String[] args) {
        containsDuplicate(new int[]{0,4,5,0,3,6});
    }

    public static boolean containsDuplicate(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; ++i){
            if(map.get(nums[i]) != null){
                map.put(nums[i], nums[i] + 1);
            }else{
                map.put(nums[i], 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() > 1){
                return true;
            }
        }

        return false;
    }


    public static boolean containsDuplicate2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if(set.contains(num)){
                return true;
            }else {
                set.add(num);
            }
        }
        return false;
    }
}
