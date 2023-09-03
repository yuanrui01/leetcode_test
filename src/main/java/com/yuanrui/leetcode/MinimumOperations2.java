package com.yuanrui.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: yuanrui
 */
public class MinimumOperations2 {


    public static void main(String[] args) {
        System.out.println(minimumOperations("50986431"));
    }

    public static int minimumOperations(String num) {
        if (num.endsWith("00") || num.endsWith("25") || num.endsWith("50") || num.endsWith("75"))
            return 0;

        int len = num.length();

        //==================================
        int idx25 = Integer.MAX_VALUE;
        int idx25count = 0;
        int tmpIdx25 = 0;
        // 使得num变成25结尾需要的最小操作数
        int i = len - 1;
        while(i >= 0 && num.charAt(i) != '5') {
            --i;
            tmpIdx25++;
        }
        if (i!=-1 && num.charAt(i) == '5')
            idx25count++;
        --i;
        if (i >= 0) {
            while(i >= 0 && num.charAt(i) != '2') {
                --i;
                tmpIdx25++;
            }
            if (i!=-1 && num.charAt(i) == '2')
                idx25count++;
        }
        if (idx25count == 2)
            idx25 = tmpIdx25;
        //==================================

        //==================================
        int idx50 = Integer.MAX_VALUE;
        int idx50count = 0;
        int tmpIdx50 = 0;
        // 使得num变成25结尾需要的最小操作数
        i = len - 1;
        while(i >= 0 && num.charAt(i) != '0') {
            --i;
            tmpIdx50++;
        }
        if (i!=-1 && num.charAt(i) == '0')
            idx50count++;
        --i;
        if (i >= 0) {
            while(i >= 0 && num.charAt(i) != '5') {
                --i;
                tmpIdx50++;
            }
            if (i!=-1 && num.charAt(i) == '5')
                idx50count++;
        }
        if (idx50count == 2)
            idx50 = tmpIdx50;
        //==================================

        //==================================
        int idx75 = Integer.MAX_VALUE;
        int idx75count = 0;
        int tmpIdx75 = 0;
        // 使得num变成25结尾需要的最小操作数
        i = len - 1;
        while(i >= 0 && num.charAt(i) != '5') {
            --i;
            tmpIdx75++;
        }
        if (i!=-1 && num.charAt(i) == '5')
            idx75count++;
        --i;
        if (i >= 0) {
            while(i >= 0 && num.charAt(i) != '7') {
                --i;
                tmpIdx75++;
            }
            if (i!=-1 && num.charAt(i) == '7')
                idx75count++;
        }
        if (idx75count == 2)
            idx75 = tmpIdx75;
        //==================================

        //==================================
        int idx00 = Integer.MAX_VALUE;
        int idx00count = 0;
        int tmpIdx00 = 0;
        // 使得num变成00结尾需要的最小操作数
        i = len - 1;
        while(i >= 0 && num.charAt(i) != '0') {
            --i;
            tmpIdx00++;
        }
        if (i!=-1 && num.charAt(i) == '0')
            idx00count++;
        --i;
        if (i >= 0) {
            while(i >= 0 && num.charAt(i) != '0') {
                --i;
                tmpIdx00++;
            }
            if (i!=-1 && num.charAt(i) == '0')
                idx00count++;
        }
        if (idx00count == 2)
            idx00 = tmpIdx00;
        //==================================

        if (idx00 == Integer.MAX_VALUE && idx25 == Integer.MAX_VALUE &&idx50 == Integer.MAX_VALUE &&idx75 == Integer.MAX_VALUE) {
            int countZero = 0;
            for (int k = 0; k < len; ++k) {
                if (num.charAt(k) == '0')
                    countZero++;
            }
            return Math.min(len - countZero, len);
        }
        else
            return Math.min(Math.min(idx00, idx25), Math.min(idx50, idx75));
    }


//    public static int dp(String num, Map<String, Integer> map) {
//        if (num.length() <=0 )
//            return 0;
//        // 如果可以不删，直接返回
//        if (isDivisibleBy25(num))
//            return 0;
//        int ans = Integer.MAX_VALUE;
//        // 如果一定要删
//        for (int i = 0; i < num.length(); ++i) {
//            String subString = num.substring(0,i) + num.substring(i+1);
//            if ()
//            if (map.get(subString) != null) {
//                ans = Math.min(ans, map.get(subString));
//            } else {
//                ans = Math.min(ans, dp(num.substring(0,i) + num.substring(i+1), map));
//            }
//        }
//        map.put(num, ans+1);
//        return ans + 1;
//    }

    public static boolean isDivisibleBy25(String num) {
        // 将字符串逆序存储到数组中
        char[] digits = num.toCharArray();
        int n = digits.length;

        // 计算累加结果
        long sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            int digit = digits[i] - '0';
            long weight = (long) Math.pow(10, n - 1 - i);
            sum += digit * weight;
        }

        // 判断累加结果是否能被25整除
        if (sum % 25 == 0) {
            return true;
        } else {
            return false;
        }
    }
}
