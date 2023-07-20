package com.yuanrui.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 复原IP地址
 */
public class RestoreIpAddresses {

    private static List<String> rlist = new ArrayList<>();


    public static void main(String[] args) {
        System.out.println(solution("25525511135"));
    }

    /*
    输入：s = "25525511135"
    输出：["255.255.11.135","255.255.111.35"]
    */
    public static List<String> solution(String s) {
        if (s.length() < 4 || s.length() > 12) {
            return new ArrayList<>();
        } else {
            recur("","",s,4);
        }
        return rlist;
    }

    private static void recur(String result, String prefix, String remainder, int dotCount) {
        if (dotCount < Math.ceil(remainder.length()/3.0)) {
            return ;
        } else if (remainder.length() > 0 && remainder.charAt(0) == '0') {
            if (prefix.length() > 2) {
                return ;
            } else {
                recur(result + "0.", "", remainder.substring(1), dotCount - 1);
            }
        } else if (remainder.length() > 0) {
            if (Integer.parseInt(prefix + remainder.charAt(0)) > 255) {
                recur(result  + prefix + ".", "", remainder.substring(1), dotCount - 1);
            } else {
                recur(result + prefix + remainder.charAt(0) + ".", "", remainder.substring(1), dotCount - 1);
                recur(result, prefix + remainder.charAt(0), remainder.substring(1), dotCount);
            }
        } else if (remainder.length() == 0) {
            if (prefix.length() == 0) {
                if (!rlist.contains(result)) {
                    rlist.add(result);
                }
            } else if (Integer.parseInt(prefix) < 256){
                rlist.add(result + "." + prefix);
            }
        }
    }
}
