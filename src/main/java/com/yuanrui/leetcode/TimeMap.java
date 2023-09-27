package com.yuanrui.leetcode;

import java.util.*;

public class TimeMap {

    class TimeNode {
        int timestamp;
        String value;
        TimeNode(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    Map<String, List<TimeNode>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, v -> new ArrayList<>()).add(new TimeNode(timestamp,value));
    }

    public String get(String key, int timestamp) {
        List<TimeNode> list = map.getOrDefault(key, Collections.emptyList());
        int left = 0;
        int right = list.size() - 1;
        while (left <= right) {
            int middle = (left + right) >>> 1;
            if (list.get(middle).timestamp <= timestamp)
                left = middle + 1;
            else
                right = middle - 1;
        }
        return left == 0 ? "" : list.get(left-1).value;
    }

    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();

        timeMap.set("love","high", 10);
        timeMap.set("love","low", 20);
        System.out.println(timeMap.get("love", 5));
        System.out.println(timeMap.get("love", 10));
        System.out.println(timeMap.get("love", 15));
        System.out.println(timeMap.get("love", 20));
        System.out.println(timeMap.get("love", 25));

//        int[] array = {1,3,5,7,9};
//        int target = -10;
//
//        int left = 0;
//        int right = array.length - 1;
//        int middle = -1;
//        while (left <= right) {
//            middle = (left + right) >>> 1;
//            if (array[middle] <= target)
//                left = middle + 1;
//            else
//                right = middle - 1;
//        }
//
//        System.out.println(left - 1);
    }
}
