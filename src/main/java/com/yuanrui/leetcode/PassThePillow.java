package com.yuanrui.leetcode;

/**
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/3/5-10:33
 */
public class PassThePillow {
    public static void main(String[] args) {
        System.out.println(passThePillow(5,13));
    }

    public static int passThePillow(int n, int time) {
        if(time == 0){
            return 1;
        }
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return time%2 + 1;
        }
        int period = 2*(n - 1);
        time = time%period;

        int idx = 1;
        while(time != 0 && idx < n) {
            idx++;
            time--;
        }

        while(time!=0 && idx >= 0){
            idx--;
            time--;
        }

        return idx;
    }
}
