package com.yuanrui.leetcode;


import java.util.*;

/**
 * 1338. 数组大小减半
 * 给你一个整数数组 arr。你可以从中选出一个整数集合，并删除这些整数在数组中的每次出现。
 * 返回 至少 能删除数组中的一半整数的整数集合的最小大小。
 */
public class MinSetSize {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10};
        System.out.println(minSetSize(arr));
    }


    /**
     * 超时做法
     */
    public static int minSetSize(int[] arr) {
        Map<String, Integer> map = new TreeMap<>();

        for (int j : arr) {
            Integer count = map.get(String.valueOf(j));
            if (map.get(String.valueOf(j)) == null) {
                map.put(String.valueOf(j), 1);
            } else {
                map.put(String.valueOf(j), count + 1);
            }
        }

        Map<String, Integer> sortedMap = new TreeMap<>((k1,k2)-> {
            if (map.get(k2) - map.get(k1) > 0) {
                return 1;
            } else {
                return -1;
            }
        });
        sortedMap.putAll(map);
        System.out.println(sortedMap);
        System.out.println(map);
        System.out.println(sortedMap.get("9"));

        int accmulate = 0;
        int count = 0;
        for (String s : sortedMap.keySet()) {
            // 你问我为什么这里取得是map而不是sortedMap?我也不知道
            accmulate += sortedMap.get(s);
            count++;
            if (accmulate >= arr.length/2) {
                break;
            }
        }

        return count;
    }

    /**
     * 正常解法
     */
//    public static int minSetSize(int[] arr) {
//        int[] count = new int[100001];
//        for (int i : arr)
//            count[i]++;
//        // 将出现次数存储到列表中
//        List<Integer> counts = new ArrayList<>();
//        for (int c : count)
//            if (c > 0)
//                counts.add(c);
//        // 对出现次数列表进行排序
//        counts.sort(Collections.reverseOrder());
//        int accmulate = 0;
//        int setSize = 0;
//        for (int i : counts) {
//            accmulate += i;
//            setSize++;
//            if (accmulate >= arr.length/2)
//                break;
//        }
//        return setSize;
//    }
}
