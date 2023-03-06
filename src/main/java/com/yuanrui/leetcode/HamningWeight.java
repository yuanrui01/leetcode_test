package com.yuanrui.leetcode;

public class HamningWeight {


    public int hammingWeight(int n) {
        int cnt = 0;
        int mask = 1;

        for(int i = 0; i < 32; ++i){
            if((mask & n) != 0){
                cnt++;
            }
            mask<<=1;
        }

        return cnt;
    }
}
