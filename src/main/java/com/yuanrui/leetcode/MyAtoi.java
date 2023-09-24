package com.yuanrui.leetcode;

/**
 * @author: yuanrui
 */
public class MyAtoi {

    public int myAtoi(String s) {
        if (s.isEmpty())
            return 0;

        int firstNotSpaceCharIdx = 0;
        while(firstNotSpaceCharIdx < s.length() && s.charAt(firstNotSpaceCharIdx) == ' ')
            firstNotSpaceCharIdx++;
        if (firstNotSpaceCharIdx == s.length())
            return 0;
        if (s.charAt(firstNotSpaceCharIdx) != '-' && s.charAt(firstNotSpaceCharIdx) != '+' &&
                (s.charAt(firstNotSpaceCharIdx) < '0' || s.charAt(firstNotSpaceCharIdx) > '9'))
            return 0;
        int y = -1;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-')
                y = i;
        }
        if (y > -1 && y < s.length() - 1 && (s.charAt(y+1)<'0' || s.charAt(y+1) > '9'))
            return 0;

        int firstNumIdx = -1;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i)>= '0' && s.charAt(i)<='9') {
                firstNumIdx = i;
                break;
            }
        }
        if (firstNumIdx == -1)
            return 0;
        int flag = 1;
        if (firstNumIdx > 0 && s.charAt(firstNumIdx-1) == '-')
            flag = -1;
        if (firstNumIdx > 1 && ("+-".contains(s.charAt(firstNumIdx - 1)+"") && "+-".contains(s.charAt(firstNumIdx - 2)+"")))
            return 0;

        StringBuilder sb = new StringBuilder();
        int k = firstNumIdx;
        while (k < s.length() && s.charAt(k)>='0' && s.charAt(k) <= '9') {
            sb.append(s.charAt(k++));
        }
        String extractNumber = sb.toString();
        int ans;
        try {
            ans = Integer.parseInt(extractNumber);
        } catch (Exception e) {
            if (flag == 1)
                return Integer.MAX_VALUE;
            else
                return Integer.MIN_VALUE;
        }
        return flag*ans;
    }
}
