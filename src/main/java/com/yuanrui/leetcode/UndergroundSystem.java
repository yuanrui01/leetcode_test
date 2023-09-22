package com.yuanrui.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: yuanrui
 */
class UndergroundSystem {

    Map<Integer, String> stationRecord;
    Map<Integer, Integer> idRecord;

    Map<String, int[]> map;

    public UndergroundSystem() {
        stationRecord = new HashMap<>();
        idRecord = new HashMap<>();
        map = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        idRecord.put(id, t);
        stationRecord.put(id, stationName);
    }

    public void checkOut(int id, String stationName, int t) {
        int usedTime = t - idRecord.get(id);
        String key = stationRecord.get(id) + "," + stationName;
        int[] count = map.getOrDefault(key, new int[]{0,0});
        count[0] += usedTime;
        count[1]++;
        map.put(key, count);
    }

    public double getAverageTime(String startStation, String endStation) {
        int[] longs = map.get(startStation + "," + endStation);
        return (double)longs[0]/longs[1];
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */