package com.yuanrui.leetcode;

public class FirtBadVersion {

    public static void main(String[] args) {
        System.out.println(firstBadVersion(2126753390));
    }

    public static int firstBadVersion(int n) {
        if(n == 1){
            return n;
        }

        long start = 1;
        long end = n;

        //start : 1
        //end : 2
        while(start <= end){
            int mid = (int)((start + end) >> 1);
            if(isBadVersion(mid)){
                if(mid == 1){
                    return 1;
                }else if(!isBadVersion(mid - 1)){
                    return mid;
                }else{
                    end = mid - 1;
                    mid = (int)((start + end) >> 1);
                }
            }else{
                start = mid + 1;
                mid = (int)((start + end) >> 1);
            }
        }

        return (int)(start);
    }

    private static boolean isBadVersion(int n){
        if(n == 1702766719){
            return true;
        }else{
            return false;
        }
    }
    //public int firstBadVersion(int start,)
}
