package com.yuanrui.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/3/21-1:40
 */
public class Intersect {

    public static void main(String[] args) {

        //intersect(new int[]{1,2,2,1},new int[]{2,2});
    }

/*    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> ilist = new ArrayList<>();

        for(int i = 0; i < nums1.length; ++i){
            Integer t = map.get(Integer.valueOf(nums1[i]));
            if(t != null){
                map.put(nums1[i], ++t);
            }else{
                map.put(nums1[i], 1);
            }
        }

        for(int i = 0; i < nums2.length; ++i){
            Integer t = map.get(Integer.valueOf(nums2[i]));
            if(t != null && t > 0){
                map.put(nums1[i], t--);
                ilist.add(nums2[i]);
            }
        }

        return ilist.stream().mapToInt(Integer::valueOf).toArray();
    }*/

    public int[] intersect(int[] nums1, int[] nums2) {
        int[] mapArr = new int[1001];
        List<Integer> ilist = new ArrayList<>();

        for(int i = 0; i < nums1.length; ++i){
            mapArr[nums1[i]]++;
        }

        for(int i = 0; i < nums2.length; ++i){
            if(mapArr[nums2[i]] > 0){
                ilist.add(nums2[i]);
                mapArr[nums2[i]]--;
            }
        }

        return ilist.stream().mapToInt(Integer::valueOf).toArray();
    }
}
