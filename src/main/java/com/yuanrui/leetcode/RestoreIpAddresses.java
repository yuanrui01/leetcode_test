package com.yuanrui.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 复原IP地址
 */
public class RestoreIpAddresses {
    public static void main(String[] args) {
        System.out.println(solution("25525511135"));
    }

    /*
    输入：s = "25525511135"
    输出：["255.255.11.135","255.255.111.35"]
    */
    public static List<String> solution(String s) {
        List<String> rlist = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) {
            return new ArrayList<>();
        } else {
            recur(rlist, "","",s,4);
        }
        return rlist.stream().distinct().collect(Collectors.toList());
    }

    private static void recur(List<String> rlist, String result, String prefix, String remainder, int dotCount) {
        if ((dotCount < Math.ceil(remainder.length()/3.0) || dotCount > remainder.length())) {
            return ;
        } else if (prefix.length() > 1 && prefix.charAt(0) == '0') {
            return;
        } else if (remainder.length() > 0) {
            if (Integer.parseInt(prefix + remainder.charAt(0)) > 255) {
                recur(rlist, result  + prefix + ".", "", remainder, dotCount - 1);
            } else {
                if (remainder.length() == 1) {
                    recur(rlist,result + prefix + remainder.charAt(0), "", remainder.substring(1), dotCount - 1);
                } else if (prefix.equals("0") && remainder.charAt(0) != 0) {
                    recur(rlist,result, prefix + remainder.charAt(0), remainder.substring(1), dotCount);
                } else {
                    recur(rlist,result, prefix + remainder.charAt(0), remainder.substring(1), dotCount);
                    recur(rlist,result + prefix + remainder.charAt(0) + ".", "", remainder.substring(1), dotCount - 1);
                }
            }
        } else if (remainder.length() == 0) {
            if (prefix.length() == 0) {
                String lastLoc = result.substring(result.lastIndexOf('.') + 1);
                if (lastLoc.length() > 1 && lastLoc.startsWith("0")) {
                    return;
                } else {
                    rlist.add(result);
                }
            } else if (Integer.parseInt(prefix) < 256){
                if (result.endsWith(".")) {
                    rlist.add(result + prefix);
                } else {
                    rlist.add(result + "." + prefix);
                }
            }
        }
    }
}
