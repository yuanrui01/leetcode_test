package com.yuanrui.leetcode;

public class ReverseBits {
    public static void main(String[] args) {
        reverseBits(43261596);
    }

    public static int reverseBits(int n) {
        int mask = 1;
        int flag1 = 1;
        int flag0 = 0;
        int res = 0;
        for(int i = 0; i < 32; ++i){
            if((mask & n) == 0){
                res |= flag0;
                System.out.print(flag0);
            }else{
                res |= flag1;
                System.out.print(flag1);
            }
            res = res << 1;
            mask <<= 1;
        }
        System.out.println();
        System.out.println(res);
        return res;
    }
    //00000010100101000001111010011100
    //00000010100101000001111010011100
}
