package com.yuanrui.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: yuanrui
 */
class UndergroundSystem {

    class Start {
        String station;
        int time;

        public Start(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    Map<Integer, Start> stationRecord;
    Map<String, int[]> map;

    public UndergroundSystem() {
        stationRecord = new HashMap<>();
        map = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        stationRecord.put(id, new Start(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        int usedTime = t - stationRecord.get(id).time;
        String key = stationRecord.get(id).station + "," + stationName;
        int[] count = map.getOrDefault(key, new int[]{0,0});
        count[0] += usedTime;
        count[1]++;
        map.put(key, count);
    }

    public double getAverageTime(String startStation, String endStation) {
        int[] count = map.get(startStation + "," + endStation);
        return (double)count[0]/count[1];
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */