package com.yuanrui.leetcode;

/**
 * 2446. 判断两个事件是否存在冲突
 * @author: yuanrui
 */
public class HaveConflict {
    public static void main(String[] args) {
        String[] event1 = {"01:15","02:00"};
        String[] event2 = {"02:00","03:00"};

        System.out.println(haveConflict(event1,event2));
    }

    public static boolean haveConflict(String[] event1, String[] event2) {
        if (compare(event1[0], event2[1]) <= 0 && compare(event1[0],  event2[0]) >= 0) {
            return true;
        } else if (compare(event2[0], event1[1]) <= 0 && compare(event2[0],  event1[0]) >= 0) {
            return true;
        } else {
            return false;
        }
    }

    private static int compare(String s1, String s2) {
        String[] s1Arr = s1.split(":");
        String[] s2Arr = s2.split(":");
        if (Integer.parseInt(s1Arr[0]) > Integer.parseInt(s2Arr[0])) {
            return 1;
        } else if (Integer.parseInt(s1Arr[0]) < Integer.parseInt(s2Arr[0])) {
            return -1;
        } else {
            if (Integer.parseInt(s1Arr[1]) > Integer.parseInt(s2Arr[1])) {
                return 1;
            } else if (Integer.parseInt(s1Arr[1]) < Integer.parseInt(s2Arr[1])) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}
