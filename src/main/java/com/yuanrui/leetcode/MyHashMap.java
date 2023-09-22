package com.yuanrui.leetcode;

/**
 * 706. 设计哈希映射
 */
class MyHashMap {
    int[] cheat;

    public MyHashMap() {
        cheat = new int[1000001];
    }

    public void put(int key, int value) {
        cheat[key] = value + 1;
    }

    public int get(int key) {
        return cheat[key] - 1;
    }

    public void remove(int key) {
        cheat[key] = 0;
    }
}