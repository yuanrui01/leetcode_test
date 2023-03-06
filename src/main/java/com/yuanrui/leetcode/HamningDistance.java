package com.yuanrui.leetcode;

public class HamningDistance    {

    public int hammingDistance(int x, int y) {
        int same = 0;
        for(int i = 0,mask=1; i < 32; ++i,mask<<=1){
            int resx = mask & x;
            int resy = mask & y;
            if(resx == resy){
                same++;
            }}

        return 32-same;
    }

}
